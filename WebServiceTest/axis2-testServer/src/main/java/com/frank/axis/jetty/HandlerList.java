package com.frank.axis.jetty;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.springframework.http.MediaType;


public class HandlerList extends HandlerCollection{
	
	String SESSION_KEY = "requestId";
	
	@Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException
    {
		String token = java.util.UUID.randomUUID().toString();
//		MDC.put(SESSION_KEY, request.getRequestedSessionId());
        Handler[] handlers = getHandlers();
        
        if (handlers!=null && isStarted())
        {
            for (int i=0;i<handlers.length;i++)
            {
            	HttpServletRequest requestWrapper = null;    
            	
                if(request instanceof HttpServletRequest && request.getContentType()!=null) {
                	if ( !request.getContentType().contains(MediaType.MULTIPART_FORM_DATA.toString())
                			&& !request.getContentType().contains(MediaType.APPLICATION_FORM_URLENCODED_VALUE.toString())) {    
	                    requestWrapper = new MAPIHttpServletRequestWrapper((HttpServletRequest) request);
	                    handlers[i].handle(target,baseRequest, requestWrapper, response);
                	} else {
                		handlers[i].handle(target,baseRequest, request, response);	
                	}
                } else {
                	handlers[i].handle(target,baseRequest, request, response);
                }
                if ( baseRequest.isHandled())
                    return;
            }
        }
//        MDC.remove(SESSION_KEY);
    }
	
	
	public class MAPIHttpServletRequestWrapper extends HttpServletRequestWrapper {  
	      
	    private final byte[] body; // 报文  
	  
	    public MAPIHttpServletRequestWrapper(HttpServletRequest request) throws IOException {  
	        super(request);  
	        body = readBytes(request.getInputStream());  
	    }  
	      
	    @Override  
	    public BufferedReader getReader() throws IOException {  
	        return new BufferedReader(new InputStreamReader(getInputStream()));  
	    }  
	      
	    @Override  
	    public ServletInputStream getInputStream() throws IOException {  
	        final ByteArrayInputStream bais = new ByteArrayInputStream(body);  
	        return new ServletInputStream() {  
	              
	            @Override  
	            public int read() throws IOException {  
	                return bais.read();  
	            }  
	        };  
	    }  
	    
	    public byte[] readBytes(InputStream is){
	    	StringBuffer sb = new StringBuffer() ; 
			try {
				InputStreamReader isr = new InputStreamReader(is);   
		    	BufferedReader br = new BufferedReader(isr); 
		    	String s = "" ; 
		    	while((s=br.readLine())!=null){ 
		    		sb.append(s) ; 
		    	} 
		    	if (is.markSupported())
		    		is.reset();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	String str =sb.toString(); 
	    	return str.getBytes();
	    	
	    }
	  
	}  

}

