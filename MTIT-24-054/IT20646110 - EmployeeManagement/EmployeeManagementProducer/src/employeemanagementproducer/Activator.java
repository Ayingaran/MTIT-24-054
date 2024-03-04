package employeemanagementproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration<?> serviceRegistration;

	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Employee Producer Start");
		EmployeeManagementAdminService employeeProducer = new EmployeeManagementAdminServiceImpl();
		serviceRegistration = bundleContext.registerService(EmployeeManagementAdminService.class.getName(), employeeProducer, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Employee Producer Stop");
		serviceRegistration.unregister();
	}

}
