package examreservationservice;

public class StudentDetails {

	private static int count=1;
	private String StudentName;
	private String ITNO;
	private double subtotal;
	int ModuleNum;
	
	public StudentDetails() {
		super();
		ModuleNum =count++;
		subtotal=0;
	}
	
	public String getStudentName() {
		return StudentName;
	}
	
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	public String getStudentAddress() {
		return ITNO;
	}
	
	public void setStudentITNO(String studentITNO) {
		ITNO = studentITNO;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal =this.subtotal+ subtotal;
	}
	
	public int getNo() {
		return ModuleNum;
	}
	
	public void setNo(int no) {
		ModuleNum = no;
	}
	
		
}
