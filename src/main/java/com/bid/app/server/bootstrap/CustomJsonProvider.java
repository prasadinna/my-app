package com.bid.app.server.bootstrap;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

public class CustomJsonProvider extends JacksonJaxbJsonProvider {
	 public CustomJsonProvider(){

	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, false);
	        mapper.configure(org.codehaus.jackson.map.SerializationConfig.Feature.WRAP_ROOT_VALUE, false);
	        _mapperConfig.setMapper(mapper);
	        _mapperConfig.getConfiguredMapper().setAnnotationIntrospector(new JaxbAnnotationIntrospector());
	       
	    }
}
