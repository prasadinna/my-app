package com.bid.app.server.web;

import com.bid.app.server.bootstrap.AppWebServiceHandler;
import com.bid.app.server.bootstrap.GenericContainer;
import com.bid.app.server.bootstrap.MessageBase;

public abstract class AbstractAppWebServiceHandler implements AppWebServiceHandler{
	private String moduleName;
	private String componentName;
	private GenericContainer container;
	public static final String URI_INFO_KEY = "URIINFO";
  protected AbstractAppWebServiceHandler(String moduleName,String componentName, GenericContainer container){
	  this.moduleName = moduleName;
	  this.componentName = componentName;
	  this.container = container;
	  this.container.setAppWebServiceHandler(this);
  }
  @Override
  public final String getModuleName(){
	  return moduleName;
  }
  
  @Override
  public final String getComponentName(){
	  return componentName;
  }
  
  @Override
  public MessageBase getMessage(int messageId){
	  return null;
	  
  }
  
}
