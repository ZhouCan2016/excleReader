package com.frank.axis.app;

import com.frank.axis.launcher.AppLauncher;

public class App extends com.frank.axis.launcher.AppLauncher {

    public static void main(String[] args) {
    	
//		try {
//			HttpConnectionManagerParams params = new HttpConnectionManagerParams();
//	    	params.setDefaultMaxConnectionsPerHost(20); //SET VALUE BASED ON YOUR REQUIREMENTS/LOAD TESTING etc
//
//	    	MultiThreadedHttpConnectionManager multiThreadedHttpConnectionManager = new MultiThreadedHttpConnectionManager();
//	    	multiThreadedHttpConnectionManager.setParams(params);
//
//	    	HttpClient httpClient = new HttpClient(multiThreadedHttpConnectionManager);
//
//	    	String path = AxisServlet.class.getResource("/").getPath();
//	    	ConfigurationContext configurationContext;
//			configurationContext = ConfigurationContextFactory.createConfigurationContextFromFileSystem(path);
//			configurationContext.setProperty(HTTPConstants.CACHED_HTTP_CLIENT, httpClient);
//		} catch (AxisFault e) {
//			e.printStackTrace();
//		}
		
        AppLauncher.main(args);
        System.out.println("----------------->start csdp_rack end!!!");
    }
}
