package employeemanagementproducer;

import java.util.List;
public interface EmployeeManagementAdminService {

	public String producerWelcome();
	public static final List<Employee> EmployeeList = null;
	public boolean AddEmployee(String empName, String empDep, double empSalary);
	public boolean UpdateEmployee(int empID, String empName, String empDep, double empSalary);
	public boolean DeleteEmployee(int empID);
	public Employee ViewEmployee(int empID);
	public List<Employee> ViewAllEmployee();
}
