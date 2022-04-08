package py.com.progweb.primerParcial.ejb.business;

import py.com.progweb.primerParcial.ejb.dao.BolsaDao;
import py.com.progweb.primerParcial.ejb.dao.ParametrizacionDao;
import py.com.progweb.primerParcial.ejb.dao.UsuarioDao;
import py.com.progweb.primerParcial.models.Bolsa;
import py.com.progweb.primerParcial.models.Parametrizacion;
import py.com.progweb.primerParcial.models.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Stateless
public class CargaPuntosBusiness {
    @Inject
    UsuarioDao usuarioDao;
    @Inject
    BolsaDao bolsaDao;
    @Inject
    ParametrizacionDao parametrizacionDao;
    @Inject
    ReglaAsignacionBusiness reglaAsignacionBusiness;

    public Bolsa cargarPuntos(int userId, int montoTransaccion) throws Exception {
        Usuario usuario = usuarioDao.getEntity(userId);
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        Parametrizacion parametrizacion = parametrizacionDao.getDuracionPuntajeFromToday();
        Date fechaCaducidad = Date.from(now.plusDays(parametrizacion.getDuracion()).atZone(ZoneId.systemDefault()).toInstant());
        int puntajeAsignado = reglaAsignacionBusiness.getEquivalenciaPuntos(montoTransaccion);

        Bolsa nuevaBolsa = new Bolsa();

        nuevaBolsa.setFechaCaducidad(fechaCaducidad)
                .setUsuario(usuario)
                .setFechaAsignacion(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .setMonto(montoTransaccion)
                .setPuntajeAsignado(puntajeAsignado)
                .setPuntajeUtilizado(0)
                .setSaldo(puntajeAsignado);

        return bolsaDao.create(nuevaBolsa);
    }
}
