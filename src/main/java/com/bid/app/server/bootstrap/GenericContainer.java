package com.bid.app.server.bootstrap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;


public class GenericContainer {
	//this is not right way but not sure how to do otherwise now
	private static GenericContainer CurrentContainer;
	private Map<String,Map<String,AppWebServiceHandler>> webreqHandlerMap = 
			new HashMap<String,Map<String,AppWebServiceHandler>>();
	private List<AbstractServiceFactory> serviceFactoryList;
	private static SessionFactory sessionFactory;
	public static GenericContainer getCurrentContainer(){
		return CurrentContainer;
	}
	public GenericContainer(List<AbstractServiceFactory> serviceFactoryList, SessionFactory sessionFactory){
	  this.serviceFactoryList =   serviceFactoryList;
	  CurrentContainer = this;
	  this.sessionFactory = sessionFactory;
    }
	public void initContainer(){
		for(AbstractServiceFactory serviceFactory:serviceFactoryList){
			int numberOfInstance = serviceFactory.getNumberOfInstance();
			for(int index=0;index<numberOfInstance;index++){
				int serviceTypeId = serviceFactory.getServiceTypeId();
				int serviceId = serviceTypeId*1000*13+index;
				serviceFactory.createInstance(serviceId);
			}
		}
		initHibernateSessionFactory();
	}
	
	private void initHibernateSessionFactory(){
		/*Configuration conf = new Configuration();
		conf.addAnnotatedClass(User.class);
		System.out.println("generic container:hibernate file:"+hiberanteFile+":path:"+BaseDataAccessObject.class.getResource(".").getPath());
		java.net.URL resFileURL = BaseDataAccessObject.class.getResource(hiberanteFile);
		System.out.println("generic container:resurce file url:"+resFileURL);
		conf.configure(resFileURL);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(conf.getProperties()).build();
		try {
			sessionFactory = conf.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed."
					+ e);
			throw new ExceptionInInitializerError(e);
		} */
	}
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public void setAppWebServiceHandler(AppWebServiceHandler webreqHandler){
		String moduleName = webreqHandler.getModuleName();
		String componentName = webreqHandler.getComponentName();
		System.out.println("moduleName:"+moduleName+":componentName:"+componentName);
		Map<String,AppWebServiceHandler> componentVsHandlerMap = webreqHandlerMap.get(moduleName);
		if(componentVsHandlerMap == null){
			System.out.println("populating the module map since doesnot exists");
			componentVsHandlerMap = new HashMap<String,AppWebServiceHandler>();
			webreqHandlerMap.put(moduleName, componentVsHandlerMap);
		}
		System.out.println("populating the component map");
		componentVsHandlerMap.put(componentName, webreqHandler);
	}
	
	public AppWebServiceHandler getWebRequestHandler(String moduleName, String componentName){
		System.out.println("moduleName:"+moduleName+":componentName:"+componentName+":webreqHandlerMap:"+webreqHandlerMap);
		Map<String,AppWebServiceHandler> componentVsHandler = webreqHandlerMap.get(moduleName);
		System.out.println("componentVsHandler:"+componentVsHandler);
		if(componentVsHandler != null){
			System.out.println("componentVsHandler map not null");
			return componentVsHandler.get(componentName);
		}
		return null;
	}
	
	private String hfile;
	public String getHfile() {
		System.out.println("getter hfile name:"+hfile);
		return hfile;
	}
	public void setHfile(String hfile) {
		System.out.println("setter hfile name:"+hfile);
		this.hfile = hfile;
	}
	
}
