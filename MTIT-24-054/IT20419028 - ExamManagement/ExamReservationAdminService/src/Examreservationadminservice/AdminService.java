package Examreservationadminservice;

import java.util.ArrayList;
import java.util.List;


public interface AdminService {

	  public static List<Exam> ExamList=new ArrayList<Exam>();

	  public boolean addExam(String ModuleName,String ModNo,double fees);
	 
	  public boolean updateExam(int No,String ModuleName,double fees);
	  
	  public boolean deleteExam(int No);
	  
	  public Exam search(int No);
	  
	  public  List<Exam> allExam();
		
}
