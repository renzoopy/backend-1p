package py.com.progweb.primerParcial.rest;

import py.com.progweb.primerParcial.ejb.business.UsoPuntosBusiness;
import py.com.progweb.primerParcial.ejb.business.UsuarioBusiness;
import py.com.progweb.primerParcial.ejb.dao.ConceptoUsoPuntosDao;
import py.com.progweb.primerParcial.models.ConceptoUsoPuntos;
import py.com.progweb.primerParcial.models.UsoPuntos;
import py.com.progweb.primerParcial.models.Usuario;
import py.com.progweb.primerParcial.models.dto.ErrorDTO;
import py.com.progweb.primerParcial.models.dto.UsoPuntosDTO;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("uso-puntos")
@Consumes("application/json")
@Produces("application/json")
public class UsoPuntosREST {
    @Inject
    UsoPuntosBusiness usoPuntosBusiness;
    @Inject
    UsuarioBusiness usuarioBusiness;
    @Inject
    ConceptoUsoPuntosDao conceptoUsoPuntosDao;
    @POST
    public Response registrarUsoPuntos(UsoPuntosDTO payload){
        try{
            Usuario usuario = usuarioBusiness.getEntity(payload.getUsuarioId());
            ConceptoUsoPuntos concepto = conceptoUsoPuntosDao.getEntity(payload.getConceptoUsoId());
            UsoPuntos usoPuntos = usoPuntosBusiness.create(usuario, concepto);

            return Response.status(Response.Status.CREATED).entity(usoPuntos).build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }
}
