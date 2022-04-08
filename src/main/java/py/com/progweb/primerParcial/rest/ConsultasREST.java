package py.com.progweb.primerParcial.rest;

import py.com.progweb.primerParcial.ejb.business.BolsaBusiness;
import py.com.progweb.primerParcial.ejb.business.ReglaAsignacionBusiness;
import py.com.progweb.primerParcial.ejb.business.UsoPuntosBusiness;
import py.com.progweb.primerParcial.ejb.business.UsuarioBusiness;
import py.com.progweb.primerParcial.models.Bolsa;
import py.com.progweb.primerParcial.models.UsoPuntos;
import py.com.progweb.primerParcial.models.Usuario;
import py.com.progweb.primerParcial.models.dto.EquivalenciaMontoDTO;
import py.com.progweb.primerParcial.models.dto.ErrorDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.*;

@Path("consultas")
@Consumes("application/json")
@Produces("application/json")
public class ConsultasREST {

    @Inject
    UsuarioBusiness usuarioBusiness;
    @Inject
    ReglaAsignacionBusiness reglaAsignacionBusiness;
    @Inject
    BolsaBusiness bolsaBusiness;
    @Inject
    UsoPuntosBusiness usoPuntosBusiness;

    @GET
    @Path("clientes")
    public Response clientes(@Context UriInfo uriInfo) {
        try {
            Set<Map.Entry<String, List<String>>> params = uriInfo.getQueryParameters().entrySet();
            Map<String, List<String>> paramsMap = new HashMap<>();
            for (Map.Entry<String, List<String>> entry : new ArrayList<>(params)) {
                paramsMap.put(entry.getKey(), entry.getValue());
            }
            List<Usuario> filteredUsuarios = usuarioBusiness.getFiltefedList(paramsMap);
            return Response.ok(filteredUsuarios)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @GET
    @Path("puntos-a-vencer/{dias}")
    public Response clientesConPuntosAVencer(@PathParam("dias") int dias) {
        try {
            List<Usuario> list = usuarioBusiness.getClientesConPuntosAVencerEn(dias);
            return Response.ok(list).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @GET
    @Path("equivalencia/{monto}")
    public Response equivalenciaMonto(@PathParam("monto") int monto) {
        try {
            int equivalencia = reglaAsignacionBusiness.getEquivalenciaPuntos(monto);
            return Response.ok(new EquivalenciaMontoDTO(equivalencia)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }

    @GET
    @Path("bolsas")
    public Response bolsasPorCliente(@Context UriInfo uriInfo){
        try {
            Set<Map.Entry<String, List<String>>> params = uriInfo.getQueryParameters().entrySet();
            Map<String, List<String>> paramsMap = new HashMap<>();
            for (Map.Entry<String, List<String>> entry : new ArrayList<>(params)) {
                paramsMap.put(entry.getKey(), entry.getValue());
            }
            List<Bolsa> filteredBolsas = bolsaBusiness.getFilteredList(paramsMap);
            return Response.ok(filteredBolsas)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }


    @GET
    @Path("uso-puntos")
    public Response usoPuntos(@Context UriInfo uriInfo) {
        try {
            Set<Map.Entry<String, List<String>>> params = uriInfo.getQueryParameters().entrySet();
            Map<String, List<String>> paramsMap = new HashMap<>();
            for (Map.Entry<String, List<String>> entry : new ArrayList<>(params)) {
                paramsMap.put(entry.getKey(), entry.getValue());
            }
            List<UsoPuntos> filteredUso = usoPuntosBusiness.getFiltefedList(paramsMap);
            return Response.ok(filteredUso)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDTO(e.getMessage())).build();
        }
    }
}
