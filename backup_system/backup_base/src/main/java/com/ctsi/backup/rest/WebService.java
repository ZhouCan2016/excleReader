package com.ctsi.backup.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import com.ctsi.backup.utils.ListClause;


/**
 * A base Web service class with default and common Web service behavior.
 * 
 * @author ranlingfeng@ctsi.com.cn
 */
public class WebService {

	protected UriInfo uriInfo;
	
	public WebService(){};
	
	public WebService(@Context UriInfo uriInfo, @Context HttpHeaders headers, @Context SecurityContext securityContext){
		this.uriInfo =  uriInfo;
	}
	
	/**
	 * Returns the request URI.
	 * 
	 * @return the string with the request URI
	 */
	protected String getRequestURI() {
		return uriInfo.getRequestUri().toString();
    }

	
	public Response listContextInter(ListClause<String, String> clause) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Response listContextInfo(ListClause<String, String> clause) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
