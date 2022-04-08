package py.com.progweb.primerParcial.ejb.business;

import py.com.progweb.primerParcial.ejb.dao.ReglaAsignacionDao;
import py.com.progweb.primerParcial.models.ReglaAsignacion;

import javax.inject.Inject;
import java.util.List;

public class ReglaAsignacionBusiness {
    @Inject
    ReglaAsignacionDao reglaAsignacionDao;

    public List<ReglaAsignacion> getAll() {
        return reglaAsignacionDao.getAll();
    }

    public ReglaAsignacion getEntity(int id) {
        return reglaAsignacionDao.getEntity(id);
    }

    public ReglaAsignacion create(ReglaAsignacion entity) {
        if (entity.getLimiteInferior() == null || entity.getLimiteSuperior() < 0) entity.setLimiteInferior(0);
        if (entity.getLimiteSuperior() == null) entity.setLimiteSuperior(Integer.MAX_VALUE);
        return reglaAsignacionDao.create(entity);
    }

    public ReglaAsignacion update(ReglaAsignacion entity, ReglaAsignacion updates) {
        if (updates.getLimiteInferior() == null || updates.getLimiteSuperior() < 0) updates.setLimiteInferior(0);
        if (updates.getLimiteSuperior() == null) updates.setLimiteSuperior(Integer.MAX_VALUE);
        entity.setLimiteInferior(updates.getLimiteInferior())
                .setLimiteSuperior(updates.getLimiteSuperior())
                .setEquivalencia(updates.getEquivalencia());
        return reglaAsignacionDao.update(entity);
    }

    public ReglaAsignacion delete(ReglaAsignacion entity) {
        return reglaAsignacionDao.delete(entity);
    }

    public int getEquivalenciaPuntos(int montoTransaccion) throws Exception {
        int equivalencia = reglaAsignacionDao.getEquivalencia(montoTransaccion);
        return montoTransaccion / equivalencia;
    }
}
