package com.frank.axis.rest;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

@Provider
public class MyResteasyJacksonJsonProvider extends JacksonJsonProvider{
	
//	@Override
//    public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, 
//            MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) 
//            throws IOException 
//    {
//        ObjectMapper mapper = locateMapper(type, mediaType);
//
//        // 序列化
//        mapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL).withDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
//        
//        super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders, entityStream);
//    }
	
	@Override
	public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String,String> httpHeaders, InputStream entityStream) 
	        throws IOException{
		
		ObjectMapper mapper = locateMapper(type, mediaType);
		
		// 反序列化
//		mapper.getDeserializationConfig().withDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return super.readFrom(type, genericType, annotations, mediaType, httpHeaders, entityStream);
	}

}
