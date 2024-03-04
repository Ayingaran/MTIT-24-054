package employeemanagementproducer;

import java.util.List;
public class EmployeeManagementAdminServiceImpl implements EmployeeManagementAdminService {
	
	public int empCount = 0;

	@Override
	public boolean AddEmployee(String empName, String empDep, double empSalary) {
		empCount++;
		Employee emp = new Employee(empCount,empName,empDep,empSalary);
		EmployeeManagementAdminService.EmployeeList.add(emp);
		return true;
	}
	@Override
	public boolean UpdateEmployee(int empID, String empName, String empDep, double empSalary) {
				
		List<Employee> list = EmployeeManagementAdminService.EmployeeList;
		
		for(Employee emp : list) {
			if(emp.getEmpID() == empID) {
				emp.setEmpName(empName);
				emp.setEmpDep(empDep);
				emp.setSalary(empSalary);
				return true;
			}
		}
		return false;
		
	}

	@Override
	public boolean DeleteEmployee(int empID) {
		
		List<Employee> list = EmployeeManagementAdminService.EmployeeList;
		
		for(Employee emp : list) {
			if(emp.getEmpID() == empID) {
				EmployeeManagementAdminService.EmployeeList.remove(emp);
				return true;
			}
		}
		return false;
	}
		
	
	@Override
	public Employee ViewEmployee(int empID) {
		
		List<Employee> list = EmployeeManagementAdminService.EmployeeList;
		for(Employee emp : list) {
			if(emp.getEmpID() == empID) {				
				return emp;				
			}		
		}
		
		return null;
		
	}

	@Override
	public List<Employee> ViewAllEmployee() {
		
		if(!EmployeeManagementAdminService.EmployeeList.isEmpty()) {
			return EmployeeList;
		}else {			
			return null;
		}
		
	}

	@Override
	public String producerWelcome() {
		
		return " << Welcome Manager >>";
	}
	
}
