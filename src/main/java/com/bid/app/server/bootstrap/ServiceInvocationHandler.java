package com.bid.app.server.bootstrap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*This is the main handler class for the remote method invocation
 * Currently this is just used to abstracting the decouple of method
 * invocation*/
public final class ServiceInvocationHandler implements InvocationHandler {
	private Service serviceObject;
	private Service proxyService;

	protected ServiceInvocationHandler(Service currentService) {
		serviceObject = currentService;
	}
	

	protected Service getProxyInstance() {
		Class<?>[] classArray = serviceObject.getClass().getInterfaces();
		Class[] arrayWithServie = new Class[classArray.length+1];
		System.arraycopy(classArray, 0, arrayWithServie, 0, classArray.length);
		arrayWithServie[classArray.length] = ServiceInterface.class;
		proxyService =  (Service) java.lang.reflect.Proxy.newProxyInstance(serviceObject
				.getClass().getClassLoader(), serviceObject.getClass().getInterfaces(),
				this);
		return proxyService;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(serviceObject, args);
	}
	
	public Service getActualService(){
		return serviceObject;
	}

}
