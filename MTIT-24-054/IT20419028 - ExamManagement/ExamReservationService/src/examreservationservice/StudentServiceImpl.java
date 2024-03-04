package examreservationservice;


public class StudentServiceImpl implements StudentService{

	StudentDetails student;
	
	@Override
	public boolean addStudentDetail(String name, String ITNO) {
		student=new StudentDetails();
		student.setStudentName(name);
		student.setStudentITNO(ITNO);
		return true;
	}

	@Override
	public double calcFees(double fees, int Qty) {
		student.setSubtotal(fees*Qty);
		return student.getSubtotal();
	}

}

