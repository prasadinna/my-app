package test.com.bid.app.server.bootstrap;

import com.bid.app.server.bootstrap.AbstractServiceFactory;

public class MockServiceBFactory extends AbstractServiceFactory {

	protected MockServiceBFactory(String serviceName, int ServiceTypeId) {
		super(serviceName, ServiceTypeId);
	}

	@Override
	public void createInstance(int serviceId) {
		new MockServiceB(this.getServiceName(),this.getServiceTypeId(),serviceId);

	}

}
