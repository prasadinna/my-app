package com.bid.app.server.bootstrap;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.bid.app.server.web.MockRestServiceHandler;

public class AppContextListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("App context listener started...");
		XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("/WEB-INF/META-INF/ApplicationContext.xml");
        context.setServletContext(sce.getServletContext());
        context.refresh();
        MockRestServiceHandler hello = (MockRestServiceHandler) context.getBean("mockrestservice");
        System.out.println("App context listener completed...");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
