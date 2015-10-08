package com.ashish.jaxrsannotation;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.Response;

/**
 * JAX-RS Multiple @PathParam Annotation
*/

@Path("/hello")  
public class HelloService2{  
    @GET  
    @Path("/{year}/{month}/{day}")  
    public Response getDate(  
            @PathParam("year") int year,  
            @PathParam("month") int month,   
            @PathParam("day") int day) {  
   
       String date = year + "/" + month + "/" + day;  
   
       return Response.status(200)  
        .entity("<h1>getDate is called, year/month/day : " + date + "</h1>")  
        .build();  
    }  
 }  