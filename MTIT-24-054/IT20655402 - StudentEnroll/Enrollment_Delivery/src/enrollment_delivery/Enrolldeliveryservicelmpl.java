package enrollment_delivery;

public class Enrolldeliveryservicelmpl implements Enrolldeliveryservice {
	EnrollmentDetails student;

	@Override
	public boolean addStudentDetail(String student_name, String student_address) {
		// TODO Auto-generated method stub
		student=new EnrollmentDetails();
		student.setStudent_address(student_name);
		student.setStudent_address(student_address);
		return false;
	}

	

}