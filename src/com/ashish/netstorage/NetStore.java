package com.ashish.netstorage;

import java.io.IOException;
import java.io.InputStream;

import com.akamai.netstorage.NetStorage;
import com.akamai.netstorage.NetStorageException;

public class NetStore {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NetStorageException 
	 */
	
	
	public static void main(String[] args) throws NetStorageException, IOException {
		
		String hostname = "";
		String username = "";
		String key 		= "";
		String path		= "";
		InputStream uploadedInputStream = null;

		NetStorage ns = new NetStorage(hostname, username, key);
		ns.upload(path, uploadedInputStream);
		
	}

}
