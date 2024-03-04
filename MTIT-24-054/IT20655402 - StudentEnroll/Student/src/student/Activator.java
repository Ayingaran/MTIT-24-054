package student;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import enroll_admin_service.Enroll;
import enroll_admin_service.EnrollAdminService;
import enrollment_delivery.Enrolldeliveryservice;

public class Activator implements BundleActivator {
	
	ServiceReference<?> Reference;
	
	EnrollAdminService enrollService;
	Enrolldeliveryservice deliveryService;
	
	Scanner in=new Scanner(System.in);

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Enrollment Start.....");
		Reference=context.getServiceReference(EnrollAdminService.class.getName());
		enrollService=(EnrollAdminService)context.getService(Reference);
		this.ChooseAdminService();

		Reference=context.getServiceReference(Enrolldeliveryservice.class.getName());
		deliveryService=(Enrolldeliveryservice)context.getService(Reference);
		this.ChooseAdminService();
	    System.out.println("Enrollment Started.....");
		
	}

	

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Enrollment Stop.....");
		context.ungetService(Reference);
	}
	
	private void ChooseAdminService() {
		// TODO Auto-generated method stub
		System.out.println("==========================================================");
		System.out.println("==========================================================");
		System.out.println("=======Welcome to the Enrollment Administration Service=======");
		System.out.println("=======Please select an option to get services============");
	
		System.out.println("1. Add Enrollment Details              ");
		System.out.println("2. Update Enrollment Details              ");
		System.out.println("3. Delete Update Details              ");
		System.out.println("4. View Enrollment Details              ");
		System.out.println("5. Cancel              ");
		System.out.println("==========================================================");
		System.out.print("Please select an option (No) :");
		int choose=in.nextInt();
		
		if(choose==1) {
			boolean i=true;
			System.out.println("=====================================================");
			System.out.println("==================Add Enrollment Details==================");
	
			while(i) {
		    System.out.println("=====================================================");
			System.out.print("Enter the Course name:");
			String course_name=in.next();
			System.out.print("Enter the "+course_name+" CourseFees:");
			double course_fees=in.nextDouble();
			
			
			enrollService.addenroll(course_name,course_fees);
			
			System.out.println("==================Succesfully added==================");
			System.out.print("Do you want to add another Enroll detail ?(yes/no)");
			String que=in.next();
			
			if("yes".equalsIgnoreCase(que)) {
				i=true;
			}else {
				
				i=false;
			}
			
			}
			
			this.ChooseAdminService();
			
		}
		else if(choose==2) {
			boolean i=true;
			System.out.println("=====================================================");
			System.out.println("=================Update Enroll Detail=================");
			
			
			
			while(i) {
			    System.out.println("=====================================================");
			    System.out.print("Enter the Enroll no:");
				int enroll_no=in.nextInt();
				System.out.print("Enter the Course name:");
				String course_name=in.next();
				System.out.print("Enter the "+course_name+" CourseFees:");
				double course_fees=in.nextDouble();
				
				//enrollService.updateEnroll(enroll_no,course_name, course_fees);
			
			System.out.println("=================Succesfully updated=================");
			System.out.print("Do you want to update another Enroll detail ?(yes/no)");
			String que=in.next();
			
			if("yes".equalsIgnoreCase(que)) {
				i=true;
			}else {
				
				this.ChooseAdminService();
				i=false;
			}
		}
	}
		else if(choose==3) {
			boolean i=true;
			
			System.out.println("=====================================================");
			System.out.println("=================Delete Enroll Detail=================");
			
	
			while(i) {
		    System.out.println("=====================================================");
			System.out.print("Enter the Enroll no:");
			int No=in.nextInt();
			
			
			
			enrollService.deleteEnroll(No);
			
			System.out.println("=====================================================");
			System.out.println("=================Succesfully Deleted=================");
			System.out.print("Do you want to delete another Enroll detail ?(yes/no)");
			String que=in.next();
			
			if("yes".equalsIgnoreCase(que)) {
				i=true;
			}else {
				
				this.ChooseAdminService();
				i=false;
			}
			}
		}
		else if(choose==4) {
			
			this.ChooseAdminService();  
			
		}
		else if(choose==5) {
			System.out.println("cancel");
			
		}
		else  {
			System.out.println("This option is not available");
		}
		
	}
	
	//this function prints List
		
      
		
	}


