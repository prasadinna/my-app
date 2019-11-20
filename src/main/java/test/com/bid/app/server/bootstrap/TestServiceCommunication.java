package test.com.bid.app.server.bootstrap;

import java.util.ArrayList;
import java.util.List;

import com.bid.app.server.bootstrap.AbstractServiceFactory;
import com.bid.app.server.bootstrap.GenericContainer;
import com.bid.app.server.bootstrap.ServiceRegistry;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class TestServiceCommunication {
	public static void main(String args[]){
		testServiceCommunication();
	}
  private static void testServiceCommunication(){
	  MockServiceAFactory factoryA = new MockServiceAFactory("ServiceA",5);
	  MockServiceBFactory factoryB = new MockServiceBFactory("ServiceB",7);
	  List<AbstractServiceFactory> serviceFactoryList = new ArrayList<AbstractServiceFactory>();
	  serviceFactoryList.add(factoryA);
	  serviceFactoryList.add(factoryB);
	  Configuration conf = new Configuration();
	  ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()
		.applySettings(conf.getProperties()).build();
	  SessionFactory sessionFactory = conf.buildSessionFactory();
	  GenericContainer container = new GenericContainer(serviceFactoryList,sessionFactory);
	  container.initContainer();
	  MockServiceIB serviceB = (MockServiceIB)ServiceRegistry.getInstance().getServiceByName("ServiceB");
	  boolean testStatus = serviceB.computeSum();
	  if(testStatus){
		  System.out.println("Service interaction successfull");
	  }else{
		  System.out.println("Service interaction failure");
	  }
	  
  }
}
