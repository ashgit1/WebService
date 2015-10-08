package com.ashish.jaxrsannotation;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.Response;  

/**
 * JAX-RS @Path, @GET and @PathParam Annotations
*/

@Path("/hello")  
public class HelloService{  
    @GET  
    @Path("/{param}")  
    public Response getMsg(@PathParam("param") String msg) {  
        String output = "Jersey say Hello : " + msg + " !!!";  
        return Response.status(200).entity("<h1>" + output + "</h1>").build();  
    }  
}  