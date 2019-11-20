package com.bid.app.server.email;
import java.util.EnumMap;
import java.util.Map;

import com.bid.app.server.bootstrap.AbstractService;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
/*
 * This is synchronous email api with high level structure, but we need to make following things
 * 1) enable asynchrounous by call back handler, dump the content in db and do batch processing?
 * 2) message acceptance instead of method invocation
 * 3) actual validation of all the passed fields
 * 4) Provide simple EmailObject which encapsulate all the content
 */
public class EmailServiceImpl extends AbstractService implements IEmailService {
	//ideally this should be injected from spring vial factory
	private static final String SENDGRIDAPIKEY ="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";
	private SendGrid sendgrid = new SendGrid(SENDGRIDAPIKEY);
	protected EmailServiceImpl(String serviceName, int serviceTypeId,
			int serviceId) {
		super(serviceName, serviceTypeId, serviceId);
	}
	private boolean validateMailAddress(String mailAddress){
		return true;
	}
	
	//currently this doesnot give failure type message, how to write junit?
	
	@Override
	public boolean sendEmail(EnumMap<EmailKeys, IEmailContentHandler> mailContent) {
	    SendGrid.Email email = new SendGrid.Email();		
		for(Map.Entry<EmailKeys,IEmailContentHandler> entry:mailContent.entrySet()){
			EmailKeys key = entry.getKey();
			IEmailContentHandler contentHandler = entry.getValue();
			String value = contentHandler.getContent();
			switch(key){
			case MAILTO:
				if(validateMailAddress(value)){
					email.addTo(value);
				}else{
					return false;
				}
				break;
			case MAILFROM:
				if(validateMailAddress(value)){
					email.setFrom(value);
				}
				break;
			case SUBJECT:
				email.setSubject(value);
				break;
			case BODY:
				email.setHtml(value);
				break;
			
			}
		}
	    try {
			SendGrid.Response response = sendgrid.send(email);
		} catch (SendGridException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
