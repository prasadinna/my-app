package com.bid.app.server.user;

import java.util.Map;

import javax.ws.rs.core.UriInfo;

import test.com.bid.app.server.bootstrap.MockServiceIB;

import com.bid.app.server.bootstrap.GenericContainer;
import com.bid.app.server.bootstrap.JsonMessageUtil;
import com.bid.app.server.bootstrap.MessageBase;
import com.bid.app.server.bootstrap.ServiceRegistry;
import com.bid.app.server.bootstrap.WrappedMessage;
import com.bid.app.server.web.AbstractAppWebServiceHandler;

public class UserRestServiceHandler extends AbstractAppWebServiceHandler {

	protected UserRestServiceHandler(String moduleName, String componentName,
			GenericContainer container) {
		super(moduleName, componentName, container);
	}

	@Override
	public Object getResponse(Map args, WrappedMessage wrappedMessage) {
		UriInfo info = (UriInfo) args.get(AbstractAppWebServiceHandler.URI_INFO_KEY);
		IUserService userService = (IUserService)ServiceRegistry.getInstance().getServiceByName("user-service");
		MessageBase returnMessage = userService.handleMessage(wrappedMessage);
		WrappedMessage wrapMessage = JsonMessageUtil.convertToWrappedMessage(returnMessage);
		return JsonMessageUtil.toJsonString(wrapMessage);

	}

}
