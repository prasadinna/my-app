package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.bid.app.server.web.MockRestServiceHandler;

public class LoadSpringApp {

public static void main(String args[]){
	System.out.println("started spring bean loading");
	 ApplicationContext context = new FileSystemXmlApplicationContext
	            ("C:\\Users\\i307242\\git\\prapp\\src\\main\\webapp\\WEB-INF\\META-INF\\ApplicationContext.xml");
	 MockRestServiceHandler mockrestservice = (MockRestServiceHandler) context.getBean("mockrestservice");
	 System.out.println("completed spring bean loading");
}
}
