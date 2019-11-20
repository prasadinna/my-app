package com.bid.app.server.bootstrap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class AbstractServiceMessageRegistry implements ServiceMessageRegistry {
	private Map<Integer, Class<? extends MessageBase>> messageIdVsMessageMap;
	private Map<Class<? extends MessageBase>,Integer> messageClassVsMessageIdMap;
	protected AbstractServiceMessageRegistry(String filepath){
		Properties prop = new Properties();
		InputStream input = null;

		try {
			System.out.println("loading the file..:"+filepath);
			input = this.getClass().getClassLoader().getResourceAsStream(filepath);
			prop.load(input);
			if(!(prop.size() > 0)){
				return;
			}
			messageIdVsMessageMap = new HashMap<Integer, Class<? extends MessageBase>>();
			messageClassVsMessageIdMap = new HashMap<Class<? extends MessageBase>, Integer>();
			for(Entry<Object, Object> entry:prop.entrySet()){
				String messageIdStr = (String)entry.getKey();
				Integer messageId = Integer.parseInt(messageIdStr);
				String valueClass = (String)entry.getValue();
				Class<? extends MessageBase> msgClass = (Class<? extends MessageBase>) this.getClass().getClassLoader().loadClass(valueClass);
				messageIdVsMessageMap.put(messageId, msgClass);
				messageClassVsMessageIdMap.put(msgClass, messageId);
				
				
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	  
	}
	@Override
	public Class< ? extends MessageBase> getMessage(int messageId) {
		return this.messageIdVsMessageMap.get(messageId);
	}
	@Override
	public int getMessageIfForClass(Class<? extends MessageBase> messageClass) {
		return messageClassVsMessageIdMap.get(messageClass);
	}

}
