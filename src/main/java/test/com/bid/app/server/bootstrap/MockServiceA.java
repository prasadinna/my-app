package test.com.bid.app.server.bootstrap;

import com.bid.app.server.bootstrap.AbstractService;

public class MockServiceA  extends AbstractService implements MockServiceIA {

	public MockServiceA(String serviceName, int serviceTypeId,int serviceId) {
		super(serviceName,serviceTypeId,serviceId);
	}
	
	public int getSum(int first, int second){
		return first+second;
	}

}
