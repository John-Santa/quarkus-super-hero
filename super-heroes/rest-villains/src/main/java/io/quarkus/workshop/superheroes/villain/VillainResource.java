package io.quarkus.workshop.superheroes.villain;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/villains")
public class VillainResource {

    @Inject
    Logger logger;

    @Inject
    VillainService villainService;

    @GET
    @Path("/random")
    public Response randomVillain() {
        Villain villain = villainService.findRandomVillain();
        logger.debugf("Found random villain: %s", villain);
        return Response.ok(villain).build();
    }

    @GET
    public Response getAllVillains() {
        List<Villain> villains = villainService.findAllVillains();
        logger.debugf("Found %d villains", villains);
        return Response.ok(villains).build();
    }

    @GET
    @Path("/{id}")
    public Response getVillainById(@RestPath Long id) {
        Villain villain = villainService.findVillainById(id);
        if (villain != null) {
            logger.debugf("Found villain: %s", villain);
            return Response.ok(villain).build();
        } else {
            logger.debugf("No villain found with id: %d", id);
            return Response.noContent().build();
        }
    }

    @POST
    public Response createVillain(@Valid Villain villain, @Context UriInfo uriInfo) {
        villain = villainService.persistVillain(villain);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(villain.id));
        logger.debugf("New villain created with URI %s", uriBuilder.build().toString());
        return Response.created(uriBuilder.build()).build();
    }

    @PUT
    public Response updateVillain(@Valid Villain villain) {
        villain = villainService.updateVillain(villain);
        logger.debugf("Updated villain: %s", villain);
        return Response.ok(villain).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVillain(@RestPath Long id) {
        villainService.deleteVillain(id);
        logger.debugf("Deleted villain with id: %d", id);
        return Response.noContent().build();
    }

    @GET
    @Path("/hello")
    @Produces(TEXT_PLAIN)
    public String hello() {
        return "Hello from Villain resource";
    }
}
