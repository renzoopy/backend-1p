package py.com.progweb.primerParcial.ejb.business;

import py.com.progweb.primerParcial.ejb.business.exceptions.BusinessException;
import py.com.progweb.primerParcial.ejb.dao.BolsaDao;
import py.com.progweb.primerParcial.ejb.dao.DetalleUsoPuntosDao;
import py.com.progweb.primerParcial.ejb.dao.UsoPuntosDao;
import py.com.progweb.primerParcial.models.*;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Stateless
public class UsoPuntosBusiness {
    @Inject
    UsoPuntosDao usoPuntosDao;
    @Inject
    DetalleUsoPuntosDao detalleUsoPuntosDao;
    @Inject
    BolsaDao bolsaDao;
    @Inject
    EmailSenderBusiness emailSenderBusiness;

    public UsoPuntos create(Usuario user, ConceptoUsoPuntos concepto) throws Exception {
        UsoPuntos usoPuntos = new UsoPuntos();
        usoPuntos.setConceptoUso(concepto)
                .setFecha(new Date())
                .setUsuario(user)
                .setPuntajeUtilizado(concepto.getPuntosRequeridos());
        int puntos_restantes = usoPuntos.getPuntajeUtilizado();
        List<Bolsa> bolsasDisponibles = bolsaDao.getAllSortedByFechaVencimiento();
        usoPuntos = usoPuntosDao.create(usoPuntos);
        usoPuntos.setDetalle(new ArrayList<>());
        for (Bolsa b : bolsasDisponibles) {
            if (puntos_restantes > 0) {
                int puntosUtilizados = Math.min(b.getSaldo(), puntos_restantes);
                DetalleUsoPuntos detalle = new DetalleUsoPuntos();
                detalle.setUsoPuntos(usoPuntos)
                        .setBolsa(b)
                        .setPuntajeUtilizado(puntosUtilizados);

                detalleUsoPuntosDao.create(detalle);
                b.setSaldo(b.getSaldo() - puntosUtilizados);
                b.setPuntajeUtilizado(b.getPuntajeUtilizado() + puntosUtilizados);
                bolsaDao.update(b);
                usoPuntos.getDetalle().add(detalle);
                puntos_restantes -= puntosUtilizados;
            } else
                break;
        }
        if (puntos_restantes > 0)
            throw new BusinessException("No se tienen puntos suficientes para canjear puntos");
        if (user.getEmail() != null)
            emailSenderBusiness.sendMessage(user.getEmail(), usoPuntos);

        return usoPuntosDao.getEntity(usoPuntos.getId());
    }

    public List<UsoPuntos> getFiltefedList(Map<String, List<String>> paramsMap) {
        return usoPuntosDao.getFiltefedList(paramsMap);
    }
}