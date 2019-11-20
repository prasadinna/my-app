package com.bid.app.server.bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
/*
 * This class is the backbone of the service structure. This class will hide the service retrival based
 * on the consistent hashing algorithem.Ideally in distributed environment
 * this should use the distributed cache to store the service
 * 
 * Warning:currently this is just in building phase in minimum viable product
 */
public class ServiceRegistry {
	
	private static ServiceRegistry instance;
	private Map<Integer,Service> serviceIdvsService = new ConcurrentHashMap<Integer,Service>();
	private Map<String,List<Service>> serviceClassVsServices = new ConcurrentHashMap<String,List<Service>>();
	private ServiceRegistry(){
		
	}
	public static ServiceRegistry getInstance(){
		if(instance == null){
			instance = new ServiceRegistry();
		}
		return instance;
	}
	public void setService(ServiceInvocationHandler invocationHandler){
		Service currentService = invocationHandler.getActualService();
		Service proxyService = invocationHandler.getProxyInstance();
		Integer serviceId = currentService.getServiceId();
		String serviceName = currentService.serviceName();
		serviceIdvsService.put(serviceId, proxyService);
		List serviceLists = serviceClassVsServices.get(serviceName);
		if(serviceLists == null){
			serviceLists = new ArrayList<Service>();
			serviceLists.add(proxyService);
			serviceClassVsServices.put(serviceName, serviceLists);
		}else{
			serviceLists.add(proxyService);
		}
	}
  /*This method is to retrieve service based on the consistent hashing but for now uses the 
   * random algo which doesnot work well on load distribution*/
  public Service getServiceByName(String serviceName){
	   Random random = new Random();
	  List<Service> serviceList = serviceClassVsServices.get(serviceName);
	  if(serviceList == null){
		  return null;
	  }
	  int size = serviceList.size();
	  return serviceList.get(random.nextInt(size));
  }
  
  public Service getServicebyId(Integer serviceId){
	 return serviceIdvsService.get(serviceId); 
  }
}
