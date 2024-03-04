package Examreservationadminservice;

import java.util.List;


public class AdminServiceImpl implements AdminService{

	@Override
	public boolean addExam(String moduleName,String ModNo, double Fees) {
		Exam exam=new Exam(moduleName, Fees);
		AdminService.ExamList.add(exam);
		return true;
	}

	@Override
	public boolean updateExam(int No,String moduleName, double Fees) {
		List<Exam> temp=AdminService.ExamList;
		for(Exam exam : temp) {
			   if(exam.getNo()==No) {
				   exam.setName(moduleName); 
				   exam.setPrice(Fees);
				  
			   }
			}	
		return true;
	}

	
	@Override
	public boolean deleteExam(int No) {
		ExamList.remove(No-1);
		return true;
	}

	@Override
	public List<Exam> allExam() {
		
		return ExamList;
	}

	@Override
	public Exam search(int No) {
		List<Exam> tem=AdminService.ExamList;
		for(Exam exam : tem) {
			   if(exam.getNo()==No) {
				   return exam;
			   }
			}	
		 return null;
	}

}
