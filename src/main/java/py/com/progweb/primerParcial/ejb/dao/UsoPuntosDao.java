package py.com.progweb.primerParcial.ejb.dao;

import py.com.progweb.primerParcial.ejb.utils.FilterFormater;
import py.com.progweb.primerParcial.models.ConceptoUsoPuntos;
import py.com.progweb.primerParcial.models.UsoPuntos;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class UsoPuntosDao {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public UsoPuntos create(UsoPuntos u) {
        em.persist(u);
        return u;
    }

    public UsoPuntos getEntity(Integer id) {
        return this.em.find(UsoPuntos.class, id);
    }

    public List<UsoPuntos> getFiltefedList(Map<String, List<String>> paramsMap) {
        String filter = FilterFormater.getUsoPuntosFilter(paramsMap);

        Query query = this.em.createQuery("select u from UsoPuntos u " + (filter.length() > 0 ? "where " + filter : ""));
        return query.getResultList();
    }
}
