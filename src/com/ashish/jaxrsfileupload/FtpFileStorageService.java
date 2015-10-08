package com.ashish.jaxrsfileupload;

import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/files")  
public class FtpFileStorageService {  
    @POST  
    @Path("/uploadFTP")  
    @Consumes(MediaType.MULTIPART_FORM_DATA)  
    public Response uploadFile(  
            @FormDataParam("file") InputStream uploadedInputStream,  
            @FormDataParam("file") FormDataContentDisposition fileDetail) {  
    	
            String fileLocation = "/289071/test/Ashish/" + fileDetail.getFileName();  
            String output	= "";
            String server = "asdafiles.upload.akamai.com";
    		int port = 21;
    		String user = "rohasda123";
    		String pass = "rohasda123";
    		
    		FTPClient ftpClient = new FTPClient();
            try {
     
                ftpClient.connect(server, port);
                ftpClient.login(user, pass);
                ftpClient.enterLocalPassiveMode();
     
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
     
                System.out.println("Start uploading first file");
                boolean done = ftpClient.storeFile(fileLocation, uploadedInputStream);
                uploadedInputStream.close();
                if (done) {
                    System.out.println("The first file is uploaded successfully.");
                    output = "File successfully uploaded to :" + server + fileLocation; 
                }else{
                	output = "Some Failure occured while uploading. Please check the Logs.";  
                }

     
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                try {
                    if (ftpClient.isConnected()) {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
            return Response.status(200).entity(output).build();  
        }  
  }
