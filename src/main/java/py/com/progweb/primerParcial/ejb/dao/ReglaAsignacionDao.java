package py.com.progweb.primerParcial.ejb.dao;

import py.com.progweb.primerParcial.models.ReglaAsignacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ReglaAsignacionDao {
    @PersistenceContext(unitName = "pruebaPU")
    protected EntityManager em;

    public ReglaAsignacion create(ReglaAsignacion entity) {
        em.persist(entity);
        return entity;
    }

    public ReglaAsignacion update(ReglaAsignacion entity) {
        return this.em.merge(entity);
    }

    public ReglaAsignacion delete(ReglaAsignacion entity) {
        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }

        em.remove(entity);
        return entity;
    }

    public ReglaAsignacion getEntity(Integer id) {
        return this.em.find(ReglaAsignacion.class, id);
    }

    public List<ReglaAsignacion> getAll() {
        Query query = this.em.createQuery("select p from ReglaAsignacion p");
        return query.getResultList();
    }

    public int getEquivalencia(int monto) throws Exception {
        Query q = this.em.createQuery("SELECT r FROM ReglaAsignacion r WHERE r.limiteInferior <= :monto AND r.limiteSuperior >= :monto")
                .setParameter("monto", monto);
        List<ReglaAsignacion> list = q.getResultList();
        if(list.size() == 0){
            throw new Exception("No se encontro una regla de asignacion para el monto");
        }
        return list.get(0).getEquivalencia();
    }
}