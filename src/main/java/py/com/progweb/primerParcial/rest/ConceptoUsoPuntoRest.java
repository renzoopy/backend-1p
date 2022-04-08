package py.com.progweb.primerParcial.rest;

import py.com.progweb.primerParcial.ejb.dao.ConceptoUsoPuntosDao;
import py.com.progweb.primerParcial.models.ConceptoUsoPuntos;
import py.com.progweb.primerParcial.models.dto.ErrorDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("concepto-uso-puntos")
@Consumes("application/json")
@Produces("application/json")
public class ConceptoUsoPuntoRest {
    @Inject
    private ConceptoUsoPuntosDao conceptoUsoPuntosDao;

    @GET
    @Path("/")
    public Response getAll() {
        try {
            return Response.ok(conceptoUsoPuntosDao.getAll()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, ConceptoUsoPuntos conceptoUsoPuntos) {
        try {
            ConceptoUsoPuntos actualizacion = conceptoUsoPuntosDao.getEntity(id);

            return Response.ok(conceptoUsoPuntosDao.update(actualizacion, conceptoUsoPuntos)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @POST
    @Path("/")
    public Response create(ConceptoUsoPuntos p) {
        try {
            return Response.status(Response.Status.CREATED).entity(conceptoUsoPuntosDao.create(p)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarPunto(@PathParam("id") Integer id) {
        try {
            ConceptoUsoPuntos eliminar = conceptoUsoPuntosDao.getEntity(id);
            return Response.ok(conceptoUsoPuntosDao.delete(eliminar)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }
}
