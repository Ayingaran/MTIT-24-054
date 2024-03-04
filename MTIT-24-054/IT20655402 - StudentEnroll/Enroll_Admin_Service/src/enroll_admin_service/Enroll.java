package enroll_admin_service;

public class Enroll {
	
	private static int enroll_id=1;
	private String course_name;
	private double course_fees;
	int enroll_no;

	public Enroll(String course_name, double course_fees) {
		// TODO Auto-generated constructor stub
		super();
		//No increases when creating a Pizza object
		//enroll_no=count++;
	course_name = course_name;
		this.course_fees = course_fees;
	}

	public static int getEnroll_id() {
		return enroll_id;
	}

	public static void setEnroll_id(int enroll_id) {
		Enroll.enroll_id = enroll_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public double getCourse_fees() {
		return course_fees;
	}

	public void setCourse_fees(double course_fees) {
		this.course_fees = course_fees;
	}

	public int getEnroll_no() {
		return enroll_no;
	}

	public void setEnroll_no(int enroll_no) {
		this.enroll_no = enroll_no;
	}

	
}
