package com.bid.app.server.web;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.bid.app.server.bootstrap.AppWebServiceHandler;
import com.bid.app.server.bootstrap.GenericContainer;
import com.bid.app.server.bootstrap.WrappedMessage;

@Path("/service/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestCallInterceptor {
	@GET
	@Path("/{module}/{component}/{urlpath : .*}")	
	public Response login(@PathParam("module") String module,
			@PathParam("component") String component,
			@PathParam("urlpath") String urlpath, @Context UriInfo info) {

		System.out.println("Rest call interceptor invoked..module:" + module
				+ ":component:" + component + ":uri info:" + info + ":urlpath:"
				+ urlpath);

		GenericContainer container = GenericContainer.getCurrentContainer();
		AppWebServiceHandler restHandler = container.getWebRequestHandler(
				module, component);
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put(AbstractAppWebServiceHandler.URI_INFO_KEY, info);
		Object respObj = restHandler.getResponse(queryParams,null);
		return Response.status(200).entity(respObj).build();
	}

	@POST
	@Path("/{module}/{component}/{urlpath : .*}")
	public Response loginpost(@PathParam("module") String module,
			@PathParam("component") String component,
			@PathParam("urlpath") String urlpath, @Context UriInfo info, WrappedMessage wrappedMsg) {

		System.out.println("Rest call interceptor invoked..module:" + module
				+ ":component:" + component + ":uri info:" + info + ":urlpath:"
				+ urlpath+":message:"+wrappedMsg);
		
		GenericContainer container = GenericContainer.getCurrentContainer();
		AppWebServiceHandler restHandler = container.getWebRequestHandler(
				module, component);
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put(AbstractAppWebServiceHandler.URI_INFO_KEY, info);
		Object respObj = restHandler.getResponse(queryParams,wrappedMsg);
		return Response.status(200).entity(respObj).build();
	}
}
