package py.com.progweb.primerParcial.rest;

import py.com.progweb.primerParcial.ejb.business.ReglaAsignacionBusiness;
import py.com.progweb.primerParcial.ejb.dao.ReglaAsignacionDao;
import py.com.progweb.primerParcial.models.ReglaAsignacion;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("reglas-asignacion")
@Consumes("application/json")
@Produces("application/json")
public class ReglaAsignacionREST {
    @Inject
    ReglaAsignacionBusiness reglaAsignacionBusiness;

    @GET
    @Path("/")
    public Response getAll() {
        try {
            return Response.ok(reglaAsignacionBusiness.getAll())
                    .build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    public Response create(ReglaAsignacion regla) {
        try {
            return Response.ok(reglaAsignacionBusiness.create(regla)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }

    }

    @PUT
    @Path("/{reglaId}")
    public Response update(@PathParam("reglaId") int reglaId, ReglaAsignacion regla) {
        try {
            ReglaAsignacion entity = reglaAsignacionBusiness.getEntity(reglaId);
            return Response.ok(reglaAsignacionBusiness.update(entity, regla)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("{reglaId}")
    public Response update(@PathParam("reglaId") int reglaId) {
        try {
            ReglaAsignacion reglaAsignacion = reglaAsignacionBusiness.getEntity(reglaId);
            return Response.ok(reglaAsignacionBusiness.delete(reglaAsignacion)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }

    }
}
