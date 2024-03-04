package Examreservationadminservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class AdminActivator implements BundleActivator {

	ServiceRegistration<?> Registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("EXAM MANAGEMENT SYSTEM ADMIN SERVICE START.....");
		AdminService examService=new AdminServiceImpl();

		Registration=context.registerService(AdminService.class.getName(), examService, null);
		
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("EXAM  MANAGEMENT SYSTEM ADMIN SERVICE STOPED! ");
		Registration.unregister();
	}

}

