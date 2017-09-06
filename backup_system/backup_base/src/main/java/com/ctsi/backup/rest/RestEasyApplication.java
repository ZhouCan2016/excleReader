package com.ctsi.backup.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.apache.log4j.Logger;
import org.reflections.Reflections;

import com.ctsi.backup.utils.SpringContextUtils;


public class RestEasyApplication extends Application{

	private Logger LOG = Logger.getLogger(RestEasyApplication.class);

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public RestEasyApplication() {
		try {
			Reflections reflections = (Reflections) SpringContextUtils.getBeanByClass(Reflections.class);
			Set<Class<? extends WebService>> set = reflections.getSubTypesOf(WebService.class);
			for (Class<? extends WebService> clazz : set) {
				try {
					Object obj = SpringContextUtils.getBeanByClass(clazz);
					if(obj != null){
						singletons.add(obj); // 通过类名从spring容器中来获取实例
					}
				} catch (Exception e) {
					LOG.error("there is no bean named "+ clazz.getName() +" in the spring context! ");
					continue;
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
