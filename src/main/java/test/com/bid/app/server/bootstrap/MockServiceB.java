package test.com.bid.app.server.bootstrap;

import com.bid.app.server.bootstrap.AbstractService;
import com.bid.app.server.bootstrap.ServiceRegistry;

public class MockServiceB extends AbstractService implements MockServiceIB {

	protected MockServiceB(String serviceName, int serviceTypeId,int serviceId) {
		super(serviceName,serviceTypeId,serviceId);
	}
	
	public boolean computeSum(){
		int first = 10;
		int second = 20;
		MockServiceIA serviceA = (MockServiceIA)ServiceRegistry.getInstance().getServiceByName("ServiceA");
		int sum = serviceA.getSum(first, second);
		return sum==30;
	}

}
