package hotelproducer;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import BartenderImplService.BartenderImplService;
import BartenderService.BartenderService;

public class Activator implements BundleActivator {
	
	ServiceRegistration serviceRegisterrrrr;

	@Override
	public void start(BundleContext context) throws Exception {
		 //Life cycle method-start
		System.out.println("=====================HotelProducer service started.==============================");
		BartenderService bartenderService = new BartenderImplService();
		serviceRegisterrrrr = context.registerService(BartenderService.class.getName(), bartenderService, null); 
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==============Hotel service closed.=============");
		serviceRegisterrrrr.unregister();
	}

}
