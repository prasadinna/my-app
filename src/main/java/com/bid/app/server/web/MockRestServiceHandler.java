package com.bid.app.server.web;

import java.util.Map;

import com.bid.app.server.bootstrap.GenericContainer;
import com.bid.app.server.bootstrap.WrappedMessage;

public class MockRestServiceHandler extends AbstractAppWebServiceHandler {

	protected MockRestServiceHandler(String moduleName, String componentName,
			GenericContainer container) {
		super(moduleName, componentName, container);
	}

	@Override
	public Object getResponse(Map args, WrappedMessage msg) {
		return "successfully giving the response";
	}

}
