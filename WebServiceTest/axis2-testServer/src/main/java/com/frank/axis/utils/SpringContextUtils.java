package com.frank.axis.utils;

import org.apache.axis2.transport.http.AxisServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;


/**
 * Created with IntelliJ IDEA.
 * User: Beckham007
 * Date: 9/10/12
 * Time: 1:55 下午
 * To change this template use File | Settings | File Templates.
 */
public class SpringContextUtils implements ApplicationContextAware {

    // Spring应用上下文环境
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param applicationContext Spring的上下文环境
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtils.applicationContext = applicationContext;       

        ServletContextHandler sc = applicationContext.getBean(ServletContextHandler.class);
          
          
        String path = AxisServlet.class.getResource("/").getPath();
        ServletHolder axisServlet = sc.getServletHandler().getServlet("axisServlet");
        axisServlet.setInitParameter("axis2.repository.path", path + "WEB-INF");
//        axisServlet.setInitParameter("axis2.xml.path", path);
       
       
        // 以下代码是关键  
//      sc.setClassLoader(applicationContext.getClassLoader());  
        
        
//        System.out.println(AxisServlet.class.getResource(""));
//        System.out.println(AxisServlet.class.getResource("/"));
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
//        System.out.println(AxisServlet.class.getClassLoader().getResource(""));
//        System.out.println(ClassLoader.getSystemResource(""));



        
		XmlWebApplicationContext xmlWebAppContext = new XmlWebApplicationContext();  
		xmlWebAppContext.setParent(applicationContext);  
		xmlWebAppContext.setConfigLocation("");  
		xmlWebAppContext.setServletContext(sc.getServletContext());  
		xmlWebAppContext.refresh();  
		sc.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,  
              xmlWebAppContext);  
//		FilterHolder filterHolder=new FilterHolder(DelegatingFilterProxy.class);
//		filterHolder.setName("shiroFilter");
//		sc.addFilter(filterHolder, "/*",null);
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象 这里重写了bean方法，起主要作用
     *
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> clazz) throws BeansException {
        return applicationContext.getBean(name, clazz);
    }

    public static Object getBeanByClass(Class<?> clazz) throws BeansException, ClassNotFoundException {
        return applicationContext.getBean(clazz);
    }

    public static Object getBeanByClassName(String name) throws BeansException, ClassNotFoundException {
        return applicationContext.getBean(Class.forName(name));
    }

    public static Object getBeanWithArgs(String name, Object... args) {
        return applicationContext.getBean(name, args);
    }

}
