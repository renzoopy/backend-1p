package py.com.progweb.primerParcial.ejb.dao;

import py.com.progweb.primerParcial.ejb.utils.FilterFormater;
import py.com.progweb.primerParcial.models.Bolsa;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Stateless
public class BolsaDao {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public Bolsa create(Bolsa entity) {
        this.em.persist(entity);
        return entity;
    }

    public List<Bolsa> getBolsasVencidas() {
        Query q = em.createQuery("SELECT b from Bolsa b WHERE b.fechaCaducidad < current_date AND b.saldo > 0");
        return q.getResultList();
    }

    public List<Bolsa> getBolsasAVencerEl(Date date) {
        Query q = em.createQuery("SELECT b from Bolsa b WHERE b.fechaCaducidad = :fecha AND b.saldo > 0").setParameter("fecha", date);
        return q.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public Bolsa update(Bolsa b) {
        return this.em.merge(b);
    }

    public List<Bolsa> getFilteredList(Map<String, List<String>> paramsMap) {
        String filter = FilterFormater.getBolsaFilter(paramsMap);

        Query query = this.em.createQuery("select p from Bolsa p " + (filter.length() > 0 ? "where " + filter : ""));
        return query.getResultList();
    }

    public List<Bolsa> getAllSortedByFechaVencimiento() {
        Query q = em.createQuery("SELECT b from Bolsa b WHERE b.saldo > 0 ORDER BY b.fechaAsignacion asc");
        return q.getResultList();
    }
}
