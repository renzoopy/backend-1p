package py.com.progweb.primerParcial.rest;


import py.com.progweb.primerParcial.ejb.business.ParametrizacionBusiness;
import py.com.progweb.primerParcial.models.Parametrizacion;
import py.com.progweb.primerParcial.models.dto.ErrorDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("parametrizacion")
@Consumes("application/json")
@Produces("application/json")
public class ParametrizacionRest {
    @Inject
    private ParametrizacionBusiness parametrizacionBusiness;

    @GET
    @Path("/")
    public Response getAll() {
        try {
            return Response.ok(parametrizacionBusiness.getAll()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Parametrizacion p) {
        try {
            Parametrizacion entity = parametrizacionBusiness.getEntity(id);
            return Response.ok(parametrizacionBusiness.update(entity, p)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @POST
    @Path("/")
    public Response create(Parametrizacion p) {
        try {
            return Response.status(Response.Status.CREATED).entity(parametrizacionBusiness.create(p)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        try {
            Parametrizacion eliminar = this.parametrizacionBusiness.getEntity(id);
            return Response.ok(parametrizacionBusiness.delete(eliminar)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }
}
