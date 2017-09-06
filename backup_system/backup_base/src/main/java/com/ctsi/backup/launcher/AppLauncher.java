package com.ctsi.backup.launcher;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AppLauncher {
	
	public static ApplicationContext context;
	
	 public static void main(String[] args) {
	    	PrintStream printStream = new PrintStream(System.out) {
	    		 private Logger logger = LoggerFactory.getLogger(AppLauncher.class);
	    		 public void println(String x) {
	    			 logger.info(x);
	             }
	    		 public void println(Object x) {
	    			 logger.info(x.toString());
	    		 }
	    		 
	    	};
	    	//重定向System.out输出和e.printStackTrace();
	    	System.setOut(printStream);
	    	System.setErr(printStream);
		 
	        context = new ClassPathXmlApplicationContext(
	                "classpath*:spring-config.xml");
	        ((AbstractApplicationContext) context).registerShutdownHook();
	 }        
}
