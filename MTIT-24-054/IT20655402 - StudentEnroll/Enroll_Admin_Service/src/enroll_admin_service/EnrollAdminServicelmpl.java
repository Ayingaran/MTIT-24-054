package enroll_admin_service;

import java.util.List;

public class EnrollAdminServicelmpl implements EnrollAdminService {

	@Override
	public boolean addenroll(String course_name, double course_fees) {
		// TODO Auto-generated method stub
		Enroll enroll=new Enroll(course_name, course_fees);
		EnrollAdminService.EnrollList.add(enroll);
		return false;
	}

	@Override
	public boolean updateEnroll(String course_name, double course_fees) {
		// TODO Auto-generated method stub
		List<Enroll> temp=EnrollAdminService.EnrollList;
		for(Enroll enroll : temp) {
			int enroll_no = 1;
			if(enroll.getEnroll_no()==enroll_no) {
				   enroll.setCourse_name(course_name); 
				   enroll.setCourse_fees(course_fees);
				  
			   }
			}	
		return false;
	}

	@Override
	public boolean deleteEnroll(int enroll_no) {
		// TODO Auto-generated method stub
		EnrollList.remove(enroll_no-1);
		return false;
	}

	@Override
	public Enroll search(int enroll_no) {
		// TODO Auto-generated method stub
		List<Enroll> tem=EnrollAdminService.EnrollList;
		for(Enroll enroll : tem) {
			   if(enroll.getEnroll_no()==enroll_no) {
				   return enroll;
			   }
			}	
		return null;
	}

	@Override
	public List<Enroll> allEnroll() {
		// TODO Auto-generated method stub
		return EnrollList;
	}

}
