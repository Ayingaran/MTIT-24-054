package coursedeliveryconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
	ServiceReference serviceReferance;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		prompt();
	}

	private void prompt() {
		// TODO Auto-generated method stub
		Scanner myinput = new Scanner(System.in);
		ServiceReference service_1 = context.getServiceReference(CourseDelivery_Interface.class.getName());
		CourseDelivery_Interface the_int =(CourseDeliveryService)context.getService(service_1);
		CourseDeliveryService.CourseDeliveryService(the_int);
		
		context.ungetService(service_1);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Course service stopped");
	}

}
