package student;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import Examreservationadminservice.AdminService;
import Examreservationadminservice.Exam;
import examreservationservice.StudentService;


public class StudentActivator implements BundleActivator {

	ServiceReference<?> Reference;
	
	AdminService ExamService;
	StudentService studentService;

	Scanner scanner1=new Scanner(System.in);
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("STUDENT START.....");
		Reference=context.getServiceReference(AdminService.class.getName());
		ExamService=(AdminService)context.getService(Reference);
		this.ChooseAdminService();

		Reference=context.getServiceReference(StudentService.class.getName());
		studentService=(StudentService)context.getService(Reference);
		this.ChooseCustomerService();
	    System.out.println("STUDENT START.....");
		
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("STUDENT STOPPED! ");
		context.ungetService(Reference);
	}


	private void ChooseAdminService() {
		System.out.println("\t=======================================================");
		System.out.println("\tWelcome to the Exam  Administration Service");
		System.out.println("\t=======================================================");
		System.out.println("\t");
		System.out.println("Please select an bellow option to get services");
		System.out.println("\t");
		System.out.println("\t1.Add Exam Details              ");
		System.out.println("\t2.Update Exam Details              ");
		System.out.println("\t3.Delete Exam Details              ");
		System.out.println("\t4.View Exam Details              ");
		System.out.println("\t5.Go To View The Exam           ");
		System.out.println("=======================================================");
		System.out.print("Please select an option (Number) :");
		int choose=scanner1.nextInt();
		
		if(choose==1) {
			boolean i=true;
			System.out.println("\t=======================================================");
			System.out.println("\t==================ADD Exams DETAILS=====================");
	
			while(i) {
		    System.out.println("\t=======================================================");
			System.out.print("Enter the module name:");
			String name=scanner1.next();
			System.out.print("Enter the module number:");
			String number=scanner1.next();
			System.out.print("Enter the "+name+" fees:");
			double fees=scanner1.nextDouble();
			
			
			ExamService.addExam(name,number,fees);
			
			System.out.println("\t==================ADDED SUCCESSFULLY===================");
			System.out.print("Do you need to add another module details ?(yes/no) :");
			String que=scanner1.next();
			
			if("yes".equalsIgnoreCase(que)) {
				i=true;
			}else {
				
				i=false;
			}
			
			}
			this.viewall();
			this.ChooseAdminService();
			
		}
		else if(choose==2) {
			boolean i=true;
			System.out.println("\t=======================================================");
			System.out.println("\t=================UPLOAD Exam DETAILS===================");
			
			
			
			while(i) {
			    System.out.println("\t=======================================================");
			    System.out.print("Enter the  no:");
				int No=scanner1.nextInt();
				System.out.print("Enter the Module name:");
				String name=scanner1.next();
				System.out.print("Enter the "+name+" fees:");
				double fees=scanner1.nextDouble();
				
				ExamService.updateExam(No,name,fees);
			
			System.out.println("\t=================UPDATED SUCCESSFULLY===================");
			System.out.print("Do you want to update another exam detail ?(yes/no)");
			String que=scanner1.next();
			
			if("yes".equalsIgnoreCase(que)) {
				i=true;
			}else {
				this.viewall();
				this.ChooseAdminService();
				i=false;
			}
		}
	}
		else if(choose==3) {
			boolean i=true;
			this.viewall();
			System.out.println("\t=======================================================");
			System.out.println("\t=================DELETE Exam DETAILS===================");
			
	
			while(i) {
		    System.out.println("\t=======================================================");
			System.out.print("Enter the module no:");
			int No=scanner1.nextInt();
			
			
			ExamService.deleteExam(No);
			
			System.out.println("\t=======================================================");
			System.out.println("\t=================DELETED SUCESSFULLY===================");
			System.out.print("Do you want to delete another exam detail ?(yes/no)");
			String que=scanner1.next();
			
			if("yes".equalsIgnoreCase(que)) {
				i=true;
			}else {
				this.viewall();
				this.ChooseAdminService();
				i=false;
			}
			}
		}
		else if(choose==4) {
			this.viewall();
			this.ChooseAdminService();  
			
		}
		else if(choose==5) {
			System.out.println("=======================================================");
			System.out.println("MOVE TO VIEW THE Exams");
			
		}
		else  {
			System.out.println("THIS OPTION IS NOT AVAILABLE");
		}
		
	}
	
	//this function prints List
	private void viewall() {
		List<Exam> tem=ExamService.allExam();
		System.out.println("=======================================================");
		System.out.println("\t====================EXAM Details =======================");
		System.out.println("\t No  \t  ModuleNAME  "+"\t\t"+" FEES   ");
		for(Exam exam : tem) {
		    System.out.println("\t "+exam.getNo()+" \t   "+exam.getName()+"\t\t\t" +exam.getPrice()+"");
		}
		
      
	}
	
	private void ChooseCustomerService() {
		System.out.println("\t=======================================================");
		System.out.println("\t----------WELCOME TO ONLINE EXAM SERVICE----------");
		System.out.println("\t=======================================================");
		
		System.out.print("Enter the student name:");
		String name=scanner1.next();
		System.out.print("Enter the student ITNumber:");
		String ITNO=scanner1.next();
		
		studentService.addStudentDetail(name, ITNO);
		
		double total=0;
		Exam exam;
			
		this.viewall();
		
		
		System.out.println("=======================================================");
		System.out.println("Each Module has different exam papers");
		System.out.println("=======================================================");
		System.out.print("How many modules of exams do you write?");
		int num=scanner1.nextInt();
		
		String[] Name=new String[num];
		Double[] Fees=new Double[num];
		int[] Qty=new int[num];
		
		int start=0;
		while(num>0) {
		
		System.out.print("Enter the  no:");
		int no=scanner1.nextInt();
		exam=ExamService.search(no);
		Name[start]=exam.getName();
		
		Fees[start]=exam.getPrice();
		System.out.print("Enter the  Quantity:");
		int qty=scanner1.nextInt();
		
		total=studentService.calcFees(exam.getPrice(), qty);
		
		Qty[start]=qty;
		start++;
		num--;
		
		
		
		}
		//print ordered details
		System.out.println("\t=======================================================");
		System.out.println("\t-------------------------------------------------------");
		System.out.println("\t=======================================================");
		System.out.println("\t ModuleNAME   \t FEES    \t QTY ");
		for(int i=0;i<Qty.length;i++) {
		
			System.out.println("\t "+Name[i]+" \t \t"+Fees[i]+"  \t \t"+Qty[i]+"   ");
		    
		}
		
		System.out.println("\t====================TOTAL="+total+"======================");
		
		//print the bill as an output
		System.out.println("\t");
		System.out.println("\t=======================================================");
		System.out.println("\t-----------------------Total Bill----------------------");
		System.out.println(" \t STUDENT  "+name);
		System.out.println(" \t ITNO  "+ITNO);
		System.out.println("\t-------------------------------------------------------");
		System.out.println("\t  TOTAL     "+total);
		System.out.println("\t");
		System.out.println("\t=======================================================");
		System.out.println("\tTHANK YOU, WISH YOU SUCCESS IN YOUR EXAMS.......");
		System.out.println("\t=======================================================");
		
		System.out.print("Do you want exit ?(yes/no)");
		String que=scanner1.next();
		
		if("yes".equalsIgnoreCase(que)) {
			System.out.print("Exit");
			
			}else {
			this.ChooseCustomerService();
		}
		
	}
}
