package coursedeliveryproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration publishServiceReg;

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		CourseDelivery_Interface cd = new CourseDeliveryImplementation();
		System.out.println("Course Delivery service started.");
		publishServiceReg = bundleContext.registerService(CourseDelivery_Interface.class.getName(), cd, null);
		
		
		
		CourseDeliveryImplementation foodDelivery = new CourseDeliveryImplementation();
		
		CourseDelivery.displayMenu();
		CourseDelivery.selectCourse();
		CourseDelivery.addMoreCourseSelection();

	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Course Delivery service stopped.");
		publishServiceReg.unregister();
	}

}
