package enroll_admin_service;

import java.util.ArrayList;
import java.util.List;

public interface EnrollAdminService {

	public static List<Enroll> EnrollList=new ArrayList<Enroll>();

	  public boolean addenroll(String course_name,double course_fees);
	  
	  public boolean deleteEnroll(int enroll_no);
	  
	  public Enroll search(int enroll_no);
	  
	  public  List<Enroll> allEnroll();

	boolean updateEnroll(String course_name, double course_fees);

	
}