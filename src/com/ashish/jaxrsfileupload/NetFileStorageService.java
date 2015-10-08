package com.ashish.jaxrsfileupload;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.akamai.netstorage.NetStorage;
import com.akamai.netstorage.NetStorageException;

@Path("/files")  
public class NetFileStorageService {  
    @POST  
    @Path("/uploadNS")  
    @Consumes(MediaType.MULTIPART_FORM_DATA)  
    public Response uploadFile(  
            @FormDataParam("file") InputStream uploadedInputStream,  
            @FormDataParam("file") FormDataContentDisposition fileDetail) {  
    	
            String fileLocation = "/289071/test/" + fileDetail.getFileName();  
            String hostname = "rohasda123-asdafiles.upload.akamai.com";
    		String username = "rohasda123";
    		String key 		= "gikqLBtZd3L5as10oIj3lSxEdRX84vu0OX7kNuhOc7s53Fg6e9";
    		String output	= "";

    		//Saving file...  
    		NetStorage ns = new NetStorage(hostname, username, key);
    		try {
    			if(ns.upload(fileLocation, uploadedInputStream)){
    				  output = "File successfully uploaded to : " + fileLocation + "on host: " + hostname;  
    			}
    			else{
    				  output = "Some Failure occured while uploading. Please check the Logs.";  
    			}
				
			} catch (NetStorageException | IOException e) {
				e.printStackTrace();
			}     
           
            return Response.status(200).entity(output).build();  
        }  
  }  