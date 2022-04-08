package py.com.progweb.primerParcial.ejb.business;

import py.com.progweb.primerParcial.ejb.business.exceptions.BusinessException;
import py.com.progweb.primerParcial.ejb.dao.ParametrizacionDao;
import py.com.progweb.primerParcial.models.Parametrizacion;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ParametrizacionBusiness {
    @Inject
    ParametrizacionDao dao;

    public Parametrizacion create(Parametrizacion entity) throws Exception {
        if (dao.seSolapaCon(entity))
            throw new BusinessException("Ya existe una parametrizacion que se solapa con esta parametrizacion");
        return dao.create(entity);
    }

    public Parametrizacion getEntity(int id) {
        return dao.getEntity(id);
    }

    public Parametrizacion update(Parametrizacion entity, Parametrizacion updates) throws Exception {
        if (dao.seSolapaCon(updates))
            throw new BusinessException("Ya existe una parametrizacion que se solapa con esta parametrizacion");
        entity.setDuracion(updates.getDuracion());
        entity.setFechaFin(updates.getFechaFin());
        entity.setFechaInicio(updates.getFechaInicio());

        return dao.update(entity);
    }

    public List<Parametrizacion> getAll() {
        return dao.getAll();
    }

    public Parametrizacion delete(Parametrizacion entity) {
        return dao.delete(entity);
    }

}
