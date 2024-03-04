
package employeemanagementconsumer;

import employeemanagementproducer.Employee;


import employeemanagementproducer.EmployeeManagementAdminService;
import java.util.List;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	ServiceReference<?> serviceReference;
	EmployeeManagementAdminService serviceProduce;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Employee Management Consumer Start");
		serviceReference = bundleContext.getServiceReference(EmployeeManagementAdminService.class.getName());
		serviceProduce = (EmployeeManagementAdminService) bundleContext.getService(serviceReference);
		System.out.println(serviceProduce.producerWelcome());
		this.AdminInterfaceLoad();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Good Bye Employee Management Consumer");
		bundleContext.ungetService(serviceReference);
	}
	@SuppressWarnings("resource")
	public void AdminInterfaceLoad(){
		
		Scanner input = new Scanner(System.in);
		System.out.println("\n\nPress 1 <<<<<   Add New Employee   >>>>>");
		System.out.println("\nPress 2 <<<<<   Update Existing Employee  >>>>>");
		System.out.println("\nPress 3 <<<<<   Delete a Employee  >>>>>");
		System.out.println("\nPress 4 <<<<<  View All Employee List  >>>>>");
		System.out.println("\nPress 5 <<<<<  Find A Employee   >>>>>");
		System.out.print("\n\n\n<<  Select Your Service  >> ");
		
		int in = input.nextInt();
		
		if(in == 1) {
			
			System.out.print("\n\n<<<<<   Enter New Employee Details >>>>>\n\n");
			System.out.print("<< Enter Employee Name >>");
			String empName = input.next();
			
			System.out.println("\n<<< Computing >>>");
			System.out.println("\n<<< Engineering >>>");
			System.out.println("\n<<< Business >>>");
			System.out.print("\n<< Enter Employee Department >>");
			String empDep = input.next();
			
			System.out.print("\n<< Enter Employee Salary >>");
			double empSalary = input.nextDouble();
			
			serviceProduce.AddEmployee(empName, empDep, empSalary);
			System.out.println("\n\n<< Successfully Employee Added >>");
				
						

			this.Continue();
			
			
		}else if(in == 2) {
			
			this.ListEmployee();
			System.out.print("\n\n<< Update Employee Details >>\n\n");
			
			
			System.out.print("\n<<  Enter Updating Employee ID      >>");
			int empID = input.nextInt();
			System.out.print("<< Enter Updating Employee Name      >>");
			String empName = input.next();
			
			System.out.println("\n<<< Computing>>>");
			System.out.println("<<< Engineering>>>");
			System.out.println("<<< Business >>>");
			System.out.print("<< Enter Updating Employee Department >>");
			String empDep = input.next();
			
			System.out.print("Enter Updating Employee Salary    >>");
			double empSalary = input.nextDouble();
			
			if(serviceProduce.UpdateEmployee(empID, empName, empDep, empSalary) == true) {
				
				System.out.print("\n\n<< Successfully Employee Updated >>");
				
			}else {
				
				System.out.print("\n\n<< Update Unsuccessfull >>");
				
			}
			
			this.Continue();
			
			
		}else if(in == 3) {
			
			this.ListEmployee();
			
			System.out.println("\n\n<< Delete Employee Details >>\n");
			
			System.out.print("\nEnter Deleting Employee ID  >>");
			int empID = input.nextInt();
			
			if(serviceProduce.DeleteEmployee(empID) == true) {
				System.out.print("\n\n<< Successfully Employee Deleted >>");
			}else {
				System.out.print("\n\n<< Delete Unsuccessfull >>");
			}
			
			this.Continue();
			
		}else if(in == 4) {
			
			this.ListEmployee();
			
			this.AdminInterfaceLoad();
			
		}else if(in == 5) {
			
			System.out.print("\n\n<< Find the Employee >>");
			System.out.print("\n\nEnter Employee ID  >>");
			int empID = input.nextInt();
			
			Employee emp = serviceProduce.ViewEmployee(empID);
			
			if(emp == null) {
				
				System.out.println("\n\nEmployee Not Found");
				
			}else {
				
						System.out.print(emp.getEmpID()+"\t");
						System.out.print(emp.getEmpName()+"\t");
						System.out.print(emp.getEmpDep()+"\t");
						System.out.print(emp.getSalary()+"\t");					
					
			}
			
			this.Continue();
			
		}else {
			
			System.out.println("\n\n<< Re-enter Your Function Number >>");
			this.AdminInterfaceLoad();
			
		}
		
	}
	public void ListEmployee() {
		
		List<Employee> list = serviceProduce.ViewAllEmployee();
		
		if(!list.isEmpty()) {
				for(Employee emp : list) {
						
						System.out.print(emp.getEmpID()+"\t");
						System.out.print(emp.getEmpName()+"\t");
						System.out.print(emp.getEmpDep()+"\t");
						System.out.println(emp.getSalary()+"\t");
						
				}
				
		}else {
			
			System.out.println("\n\nEmployee List Empty");
			
		}
		
	}
	
	
	public void Continue() {
		@SuppressWarnings("resource")
		Scanner inp = new Scanner(System.in);
		System.out.print("\n\n<< Do you want to exit ?(yes/no) >>");
		String yn = inp.nextLine();
		
		if(yn == "Yes" || yn == "yes" || yn == "YES") {
			
			System.out.print("\n\n<< Thank You >>");
			
		}else {
			
			this.AdminInterfaceLoad();
		}
	}
}
