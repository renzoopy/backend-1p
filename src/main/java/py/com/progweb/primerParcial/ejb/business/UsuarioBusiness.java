package py.com.progweb.primerParcial.ejb.business;

import py.com.progweb.primerParcial.ejb.dao.BolsaDao;
import py.com.progweb.primerParcial.ejb.dao.UsuarioDao;
import py.com.progweb.primerParcial.models.Bolsa;
import py.com.progweb.primerParcial.models.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Stateless
public class UsuarioBusiness {
    @Inject
    UsuarioDao usuarioDao;
    @Inject
    BolsaDao bolsaDao;

    public List<Usuario> getAll() {
        return usuarioDao.getAll();
    }
    public Usuario create(Usuario u) {
        return usuarioDao.create(u);
    }
    public Usuario update(Usuario entity, Usuario updates) {
        return usuarioDao.update(entity, updates);
    }
    public Usuario delete(Usuario entity){
        return usuarioDao.delete(entity);
    }
    public List<Usuario> getFiltefedList(Map<String, List<String>> paramsMap) {
        return usuarioDao.getFiltefedList(paramsMap);
    }
    public List<Usuario> getClientesConPuntosAVencerEn(int dias){
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        Date fechaVencimiento = Date.from(now.plusDays(dias).atZone(ZoneId.systemDefault()).toInstant());
        List<Bolsa> bolsas = bolsaDao.getBolsasAVencerEl(fechaVencimiento);
        Set<Usuario> usuarioSet = new HashSet<>();
        for (Bolsa b: bolsas){
            usuarioSet.add(b.getUsuario());
        }
        return new ArrayList<>(usuarioSet);
    }

    public Usuario getEntity(int userId) {
        return usuarioDao.getEntity(userId);
    }
}
