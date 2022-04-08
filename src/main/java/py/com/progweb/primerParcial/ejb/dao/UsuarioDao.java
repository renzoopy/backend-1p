package py.com.progweb.primerParcial.ejb.dao;

import py.com.progweb.primerParcial.ejb.utils.FilterFormater;
import py.com.progweb.primerParcial.models.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Stateless
public class UsuarioDao {

    @PersistenceContext(unitName = "pruebaPU")
    protected EntityManager em;

    public Usuario create(Usuario entity) {
        if (entity.getListaBolsas() == null) entity.setListaBolsas(new ArrayList<>());
        em.persist(entity);
        return entity;
    }

    public Usuario update(Usuario entity, Usuario updatedUsuario) {
        entity.setNombre(updatedUsuario.getNombre())
                .setApellido(updatedUsuario.getApellido())
                .setEmail(updatedUsuario.getEmail())
                .setNumeroDocumento(updatedUsuario.getNumeroDocumento())
                .setTipoDocumento(updatedUsuario.getTipoDocumento())
                .setNacionalidad(updatedUsuario.getNacionalidad())
                .setTelefono(updatedUsuario.getTelefono())
                .setFechaNacimiento(updatedUsuario.getFechaNacimiento());
        return this.em.merge(entity);
    }

    public Usuario delete(Usuario entity) {
        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }

        em.remove(entity);
        return entity;
    }

    public Usuario getEntity(Integer id) {
        return this.em.find(Usuario.class, id);
    }

    public List<Usuario> getAll() {

        Query query = this.em.createQuery("select p from Usuario p");
        return query.getResultList();
    }

    public List<Usuario> getFiltefedList(Map<String, List<String>> paramsMap) {
        String filter = FilterFormater.getFinalUsuarioFilter(paramsMap);

        Query query = this.em.createQuery("select p from Usuario p " + (filter.length() > 0 ? "where " + filter : ""));
        return query.getResultList();
    }
}
