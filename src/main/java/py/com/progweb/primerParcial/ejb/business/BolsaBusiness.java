package py.com.progweb.primerParcial.ejb.business;

import py.com.progweb.primerParcial.ejb.dao.BolsaDao;
import py.com.progweb.primerParcial.models.Bolsa;

import javax.ejb.*;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Stateless
public class BolsaBusiness {
    @Inject
    BolsaDao bolsaDao;
    @Schedule(hour = "*")
    public void verificarBolsas(final Timer t){
        List<Bolsa> lista = bolsaDao.getBolsasVencidas();
        for(Bolsa bolsa:lista){
            bolsaDao.update(bolsa.setSaldo(0));
        }
    }

    public List<Bolsa> getFilteredList(Map<String, List<String>> paramsMap){
        return bolsaDao.getFilteredList(paramsMap);
    }
}
