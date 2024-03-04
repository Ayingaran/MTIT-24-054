package employeemanagementproducer;

public class Employee {
	
	private int empID;
	private String empName;
	private String empDep;
	private double salary;

	
	public Employee(int empID, String empName, String empDep, double salary) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empDep = empDep;
		this.salary = salary;
	}
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDep() {
		return empDep;
	}
	public void setEmpDep(String empDep) {
		this.empDep = empDep;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
