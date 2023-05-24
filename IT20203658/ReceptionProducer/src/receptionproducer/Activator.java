package receptionproducer;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import receptionimplService.ReceptionImplService;
import receptionService.ReceptionService;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterrrrr;

	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Reception service started.============");
		ReceptionService receptionService = new ReceptionImplService();
		serviceRegisterrrrr = context.registerService(ReceptionService.class.getName(), receptionService, null); 
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==============Reception service closed.=============");
		serviceRegisterrrrr.unregister();
	}

}


