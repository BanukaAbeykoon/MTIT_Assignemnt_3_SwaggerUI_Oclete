package customerproducer;

import org.osgi.framework.BundleActivator;


import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import customerImplService.CustomerImplService;
import customerService.CustomerService;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterrrrr;

	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Customer service started.============");
		CustomerService customerService = new CustomerImplService();
		serviceRegisterrrrr = context.registerService(CustomerService.class.getName(), customerService, null); 
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==============Customer service closed.=============");
		serviceRegisterrrrr.unregister();
	}

}


