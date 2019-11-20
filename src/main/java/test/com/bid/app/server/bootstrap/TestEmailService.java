package test.com.bid.app.server.bootstrap;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bid.app.server.bootstrap.AbstractServiceFactory;
import com.bid.app.server.bootstrap.GenericContainer;
import com.bid.app.server.bootstrap.ServiceRegistry;
import com.bid.app.server.email.EmailKeys;
import com.bid.app.server.email.EmailServiceFactory;
import com.bid.app.server.email.GenericEmailContentHandlerImpl;
import com.bid.app.server.email.IEmailContentHandler;
import com.bid.app.server.email.IEmailService;

public class TestEmailService {
   public static boolean testEmailStatus(){
	   EmailServiceFactory emailFactory = new EmailServiceFactory("EmailService",9);
	   List<AbstractServiceFactory> serviceFactoryList = new ArrayList<AbstractServiceFactory>();
	   serviceFactoryList.add(emailFactory);
	   Configuration conf = new Configuration();
		  ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()
			.applySettings(conf.getProperties()).build();
		  SessionFactory sessionFactory = conf.buildSessionFactory();
		  GenericContainer container = new GenericContainer(serviceFactoryList,sessionFactory);
	   container.initContainer();
	   IEmailService mailService = (IEmailService)ServiceRegistry.getInstance().getServiceByName("EmailService");
	   EnumMap<EmailKeys,IEmailContentHandler> emailContent = new EnumMap<EmailKeys,IEmailContentHandler>(EmailKeys.class);
	   GenericEmailContentHandlerImpl subject = new GenericEmailContentHandlerImpl("MockService subject");
	   GenericEmailContentHandlerImpl body = new GenericEmailContentHandlerImpl("MockService body");
	   GenericEmailContentHandlerImpl from = new GenericEmailContentHandlerImpl("prapp-admin@prapp-devincorp.com");
	   GenericEmailContentHandlerImpl to = new GenericEmailContentHandlerImpl("prasad.inna@gmail.com");
	   emailContent.put(EmailKeys.SUBJECT, subject);
	   emailContent.put(EmailKeys.BODY, body);
	   emailContent.put(EmailKeys.MAILFROM, from);
	   emailContent.put(EmailKeys.MAILTO, to);
	   boolean status = mailService.sendEmail(emailContent);
	   return status;
   }
   public static void main(String args[]){
	   boolean status = testEmailStatus();
	   if(status){
		   System.out.println("Email sent successfully");
	   }else{
		   System.out.println("Email sending problems...");
	   }
   }
}
