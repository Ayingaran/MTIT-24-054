package enrollment_delivery;

public class EnrollmentDetails {
	
	private static int count=1;
	private String student_name;
	private String student_address;
	int enroll_no;

	public EnrollmentDetails() {
		// TODO Auto-generated constructor stub
		super();
		enroll_no=count++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		EnrollmentDetails.count = count;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public int getEnroll_no() {
		return enroll_no;
	}

	public void setEnroll_no(int enroll_no) {
		this.enroll_no = enroll_no;
	}
	
	

}
