package py.com.progweb.primerParcial.ejb.dao;

import py.com.progweb.primerParcial.models.ConceptoUsoPuntos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ConceptoUsoPuntosDao {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public ConceptoUsoPuntos create(ConceptoUsoPuntos entity) {
        this.em.persist(entity);
        return entity;
    }

    public ConceptoUsoPuntos update(ConceptoUsoPuntos entity, ConceptoUsoPuntos updatedEntity) {
        entity.setDescripcion(updatedEntity.getDescripcion())
                .setPuntosRequeridos(updatedEntity.getPuntosRequeridos());
        return this.em.merge(entity);
    }

    public ConceptoUsoPuntos delete(ConceptoUsoPuntos entity) {
        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        return entity;
    }

    public ConceptoUsoPuntos getEntity(Integer id) {
        return this.em.find(ConceptoUsoPuntos.class, id);
    }

    public List<ConceptoUsoPuntos> getAll() {
        Query q = this.em.createQuery("select p from ConceptoUsoPuntos p");
        return (List<ConceptoUsoPuntos>) q.getResultList();
    }
}
