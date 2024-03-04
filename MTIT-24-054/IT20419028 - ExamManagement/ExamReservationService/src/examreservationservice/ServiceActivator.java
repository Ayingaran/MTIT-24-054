package examreservationservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class ServiceActivator implements BundleActivator {

	ServiceRegistration<?> Registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Exam Reservation Service Start.....");
		StudentService studentService=new StudentServiceImpl();
		
		Registration=context.registerService(StudentService.class.getName(), studentService, null);
		
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Exam RESERVATION SERVICE STOPPED!");
		Registration.unregister();
	}

}
