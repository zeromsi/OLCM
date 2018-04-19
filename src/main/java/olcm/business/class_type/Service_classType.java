/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_type;

import java.text.ParseException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import olcm.business.class_status.Bean_classStatus;
import olcm.core.CreateResponse;
import olcm.core.Json;

/**
 *
 * @author Admin
 */
@Stateless
@Path("class")
public class Service_classType {

    @Inject
    Bean_classType bean_classType;
    @Inject
    Bean_classStatus bean_classStatus;
    @Inject
    Json json;

    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response create(final ClassType classType, @Context HttpServletRequest request) {
        try {
            bean_classType.save(classType);
            return CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE);
        } catch (Exception e) {
            return CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
        }

    }

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll(@Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_classType.getAll()), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{id}/statuses")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllByClass(@PathParam("id") Long id, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_classStatus.allStatusOfAClass(id)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @PUT
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response edit(final ClassType classType, @Context HttpServletRequest request) {
        Boolean result = bean_classType.edit(classType);
        if (result == true) {
            return CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE);
        } else {
            return CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
        }
    }
}
