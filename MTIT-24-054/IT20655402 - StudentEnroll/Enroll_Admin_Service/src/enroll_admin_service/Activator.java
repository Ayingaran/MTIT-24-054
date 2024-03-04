package enroll_admin_service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration<?> Registration;

	private static BundleContext context;

	
	public void start(BundleContext bundleContext) throws Exception {
		//Activator.context = bundleContext;
		System.out.println("Enroll Admin service start.....");
		EnrollAdminService enrollService=new EnrollAdminServicelmpl();

		Registration=context.registerService(EnrollAdminService.class.getName(), enrollService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		//Activator.context = null;
		System.out.println("Enroll Admin service stop.....");
		Registration.unregister();
	}

}
