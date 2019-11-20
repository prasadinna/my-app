package test.com.bid.app.server.bootstrap;

import com.bid.app.server.bootstrap.AbstractServiceFactory;

public class MockServiceAFactory extends AbstractServiceFactory {

	protected MockServiceAFactory(String serviceName, int serviceTypeId) {
		super(serviceName,serviceTypeId);
	}

	@Override
	public void createInstance(int serviceId) {
	   new MockServiceA(this.getServiceName(),this.getServiceTypeId(),serviceId);
	}

}
