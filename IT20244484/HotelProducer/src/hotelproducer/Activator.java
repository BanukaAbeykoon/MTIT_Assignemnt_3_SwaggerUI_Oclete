package hotelproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import managerImplService.ManagerImplService;
import managerService.ManagerService;

//import managerImplService.ManagerImplService;,ManagerImplService;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterrrrr;

	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Hotel service started.============");
		ManagerService managerService = new ManagerImplService();
		serviceRegisterrrrr = context.registerService(ManagerService.class.getName(), managerService, null); 
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==============Hotel service closed.=============");
		serviceRegisterrrrr.unregister();
	}

}
