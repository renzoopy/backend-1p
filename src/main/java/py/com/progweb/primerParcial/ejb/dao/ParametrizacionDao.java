package py.com.progweb.primerParcial.ejb.dao;

import py.com.progweb.primerParcial.models.Parametrizacion;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Stateless
public class ParametrizacionDao {
    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;

    public Parametrizacion create(Parametrizacion entity) {
        this.em.persist(entity);
        return entity;
    }

    public Parametrizacion update(Parametrizacion entity) {
        return this.em.merge(entity);
    }

    public Parametrizacion delete(Parametrizacion entity) {
        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
        return entity;
    }

    public Parametrizacion getEntity(Integer id) {
        return this.em.find(Parametrizacion.class, id);
    }

    public List<Parametrizacion> getAll() {
        Query q = this.em.createQuery("select p from Parametrizacion p");
        return (List<Parametrizacion>) q.getResultList();
    }

    public Parametrizacion getDuracionPuntajeFromToday() throws Exception {
        Query q = this.em.createQuery("select p from Parametrizacion p WHERE p.fechaInicio <= current_date and p.fechaFin >= current_date");
        return (Parametrizacion) q.getSingleResult();
    }

    public boolean seSolapaCon(Parametrizacion p) {
        Query q = em.createQuery("SELECT p FROM Parametrizacion p WHERE ((p.fechaInicio <= :fechaInicio AND :fechaInicio <= p.fechaFin) OR (p.fechaInicio <= :fechaFin AND :fechaFin <= p.fechaFin)) AND p.id <> :id ");
        q = q.setParameter("fechaInicio", p.getFechaInicio())
                .setParameter("id", p.getId())
                .setParameter("fechaFin", p.getFechaFin());
        return q.getResultList().size() != 0;
    }
}
