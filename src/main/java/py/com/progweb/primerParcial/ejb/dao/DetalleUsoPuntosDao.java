package py.com.progweb.primerParcial.ejb.dao;

import py.com.progweb.primerParcial.models.DetalleUsoPuntos;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DetalleUsoPuntosDao {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public DetalleUsoPuntos create(DetalleUsoPuntos d){
        em.persist(d);
        return d;
    }
}
