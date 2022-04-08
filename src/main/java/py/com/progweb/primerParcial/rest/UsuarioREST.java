package py.com.progweb.primerParcial.rest;

import py.com.progweb.primerParcial.ejb.business.UsuarioBusiness;
import py.com.progweb.primerParcial.models.Usuario;
import py.com.progweb.primerParcial.models.dto.ErrorDTO;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("usuario")
@Consumes("application/json")
@Produces("application/json")
public class UsuarioREST {
    @Inject
    UsuarioBusiness usuarioBusiness;

    @GET
    @Path("/")
    public Response getAll() {
        try {
            return Response.ok(usuarioBusiness.getAll())
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @PUT
    @Path("{userId}")
    public Response update(@PathParam("userId") int userId, Usuario updatedUsuario) {
        try {
            Usuario user = usuarioBusiness.getEntity(userId);
            return Response.ok(usuarioBusiness.update(user, updatedUsuario)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @DELETE
    @Path("{userId}")
    public Response delete(@PathParam("userId") int userId) {
        try {
            Usuario usuario = usuarioBusiness.getEntity(userId);
            return Response.ok(usuarioBusiness.delete(usuario)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @POST
    @Path("/")
    public Response create(Usuario usuario) {
        try{
            Usuario user = usuarioBusiness.create(usuario);
            return Response.status(Response.Status.CREATED.getStatusCode()).entity(user).build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }

    }
}
