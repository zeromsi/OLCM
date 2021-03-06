/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import olcm.core.CreateResponse;
import olcm.core.Json;

/**
 *
 * @author Admin
 */
@Stateless
@Path("edge")
public class Service_edge {

    @Inject
    Bean_edge bean_edge;
    @Inject
    Json json;
    @Inject
    Bean_edgePosting bean_edgePosting;

    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response create(final List<EdgeAndEdgeRoleMappingPostingTemplate> edgeAndEdgeRoleMappingPostingTemplates, @Context HttpServletRequest request) {
        return bean_edgePosting.save(edgeAndEdgeRoleMappingPostingTemplates)
                ? CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE)
                : CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
    }

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll(@Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_edge.getAll()), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }
}
