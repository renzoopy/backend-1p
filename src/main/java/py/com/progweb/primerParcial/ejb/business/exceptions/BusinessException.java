package py.com.progweb.primerParcial.ejb.business.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends Exception{
    public BusinessException(String e){
        super(e);
    }
}