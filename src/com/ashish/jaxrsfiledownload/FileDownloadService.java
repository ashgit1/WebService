package com.ashish.jaxrsfiledownload;

import java.io.File;  
import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.Response;  
import javax.ws.rs.core.Response.ResponseBuilder; 


@Path("/files")  
public class FileDownloadService {  

	private static final String FILE_PATH = "C:/Ashish/Release/jax-rs-files/myfile.txt";  
	private static final String IMG_PATH  = "C:/Ashish/Release/jax-rs-files/Holi.jpg";
	private static final String PDF_PATH  = "C:/Ashish/Release/jax-rs-files/javaContest.pdf";
    
	@GET  
    @Path("/txt")  
    @Produces("text/plain")  
    public Response getFile() {  
        File file = new File(FILE_PATH);  
        ResponseBuilder response = Response.ok((Object) file);  
        response.header("Content-Disposition","attachment; filename=\"MyFileText.txt\"");  
        return response.build();   
    }  
	
	@GET  
    @Path("/image")  
    @Produces("image/png")  
    public Response getImgFile() {  
        File file = new File(IMG_PATH);  
        ResponseBuilder response = Response.ok((Object) file);  
        response.header("Content-Disposition","attachment; filename=\"MyHoli.jpg\"");  
        return response.build();  
    }  
	
	@GET  
    @Path("/pdf")  
    @Produces("application/pdf")  
    public Response getPdfFile() {  
        File file = new File(PDF_PATH);  
        ResponseBuilder response = Response.ok((Object) file);  
        response.header("Content-Disposition","attachment; filename=\"javaWhiteContest.pdf\"");  
        return response.build();  
    }  
 }  