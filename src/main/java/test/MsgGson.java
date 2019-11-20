package test;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bid.app.server.bootstrap.WrappedMessage;
import com.bid.app.server.user.messages.GetUserInfoRequest;
import com.google.gson.Gson;

public class MsgGson {
	public static void main(String args[]){
		Gson gson = new Gson();
		GetUserInfoRequest req = new GetUserInfoRequest();
		req.setUserId(123);
		req.setUserName("hulk");
		ObjectMapper objectMapper = new ObjectMapper();
		WrappedMessage object = new WrappedMessage(123,"test desription");
		String json = gson.toJson(req);
		WrappedMessage wrapmsg=new WrappedMessage(10011,json);
		//String wrapjson = new Gson().toJson(wrapmsg);
		//System.out.println(wrapjson);
		try {
			objectMapper.writeValue(System.out, wrapmsg);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String json = ow.writeValueAsString(req);
		
	}
}
