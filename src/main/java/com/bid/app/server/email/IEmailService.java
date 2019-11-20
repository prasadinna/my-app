package com.bid.app.server.email;

import java.util.EnumMap;

import com.bid.app.server.bootstrap.ServiceInterface;

public interface IEmailService extends ServiceInterface {
	public boolean sendEmail(EnumMap<EmailKeys,IEmailContentHandler> mailContent);
}
