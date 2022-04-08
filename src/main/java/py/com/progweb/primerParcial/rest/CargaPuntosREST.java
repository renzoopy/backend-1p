package py.com.progweb.primerParcial.rest;

import py.com.progweb.primerParcial.ejb.business.CargaPuntosBusiness;
import py.com.progweb.primerParcial.models.Bolsa;
import py.com.progweb.primerParcial.models.dto.CargaPuntosDTO;
import py.com.progweb.primerParcial.models.dto.ErrorDTO;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("carga-puntos")
@Consumes("application/json")
@Produces("application/json")
public class CargaPuntosREST {
    @Inject
    CargaPuntosBusiness cargaPuntosBusiness;

    @POST
    public Response cargarPuntos(CargaPuntosDTO payload){
        try{
            Bolsa b = cargaPuntosBusiness.cargarPuntos(payload.getIdUsuario(), payload.getMontoOperacion());
            return Response.ok(b).build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }
}
