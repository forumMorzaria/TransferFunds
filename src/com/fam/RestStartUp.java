package com.fam;

import com.fam.data.AccountDataStore;
import com.sun.net.httpserver.HttpServer;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;

 
/**
 * This class is the entry point for the demo app. 
 * @author forum
 *
 */
public class RestStartUp {
	private final static int port = 9998;
	private final static String host="http://localhost/";
		
	public static void main(String args[]){
		URI baseUri = UriBuilder.fromUri(host).port(port).build();
		ResourceConfig config = new ResourceConfig(FundHandler.class);
		// Load dummy data.
		AccountDataStore.getInstance().loadData();
		JdkHttpServerFactory.createHttpServer(baseUri, config);
	}
		
}
