package enrollment_delivery;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import enroll_admin_service.EnrollAdminService;
import enroll_admin_service.EnrollAdminServicelmpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	private ServiceRegistration<?> Registration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Enroll Admin service start.....");
		EnrollAdminService enrollService=new EnrollAdminServicelmpl();

		Registration=context.registerService(EnrollAdminService.class.getName(), enrollService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Enroll Admin service start.....");
		EnrollAdminService enrollService=new EnrollAdminServicelmpl();

		Registration=context.registerService(EnrollAdminService.class.getName(), enrollService, null);
	}

}
