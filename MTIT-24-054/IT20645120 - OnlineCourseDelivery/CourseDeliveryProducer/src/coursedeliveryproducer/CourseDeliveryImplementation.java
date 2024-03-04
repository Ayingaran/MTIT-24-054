package coursedeliveryproducer;

import java.util.Scanner;

public class CourseDeliveryImplementation implements CourseDelivery_Interface{

	public CourseDeliveryImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	Scanner ac =new Scanner(System.in);
	int total=0;
	
public void displayMenu() {
		
		System.out.println("Welcome!");
		System.out.println("Do you want owhich course?"+"\n" +"if Yes press 1 "+"\n"+ "No press 0");
		int opt =ac.nextInt();
		if(opt==1) {
			
			System.out.println("*********Course Options******");
			System.out.println("***************************");

		}
else {
			
			System.out.print("Thank You for visting us!");
			System.exit(opt);
		}
}

public String selectCourse() {
	
	System.out.println("Enter your needed course");
	String CoursePreference =ac.next();
	
	if(CoursePreference.equalsIgnoreCase("Eng") ){
		System.out.println("******Engineering Courses******");
		System.out.println("");
		
		System.out.println("E1.Electronic Engineering-Rs.300,000");
		System.out.println("E2.Electrical Engineering-Rs.350,000");
		System.out.println("E3.Computer Engineering-Rs.300,000");
		System.out.println("E4.Chemical Engineering-Rs.250 000");
		System.out.println("E5.Mechanical Engineering-Rs.200 000");
		System.out.println("");

	}else {
		System.out.println("******Information Technology*******");
		System.out.println("");
		
		System.out.println("T1.Information Technology-Rs.500 000");
		System.out.println("T2.Data Science-Rs.400 000");
		System.out.println("T3.Computer Networking-Rs.300 000");
		System.out.println("T4.Information Systems Engineering-Rs.250 000");
		System.out.println("T5.Cyber Security-Rs.300 000");
		System.out.println("");
	}
	return CoursePreference;
	
}

public void addMoreCourseelection() {
	
	
	String addMoreCourseSelection="yes";
	while(addMoreCourseSelection.equalsIgnoreCase("Yes")) {
		

		System.out.println("Do you want to add more course?");
		addMoreCourseSelection =ac.next();
	}
	
}
public int addCourseToCartAndCalculateBill() {
	
	
	System.out.println("Enter Course code to add to cart");
	String CourseCode =ac.next();
	if(CourseCode.equalsIgnoreCase("E1")) {
		total=total+(300000);
	}
	else if
	(CourseCode.equalsIgnoreCase("E2")) {
		total=total+(350000);
	}
	
	else if
	(CourseCode.equalsIgnoreCase("E3")) {
		total=total+(300000);
	}

	else if
	(CourseCode.equalsIgnoreCase("E4")) {
		total=total+(250000);
	}

	else if
	(CourseCode.equalsIgnoreCase("E5")) {
		total=total+(200000);
	}
	
	else if
	(CourseCode.equalsIgnoreCase("T1")) {
		total=total+(500000);
	}
	
	else if
	(CourseCode.equalsIgnoreCase("T2")) {
		total=total+(400000);
	}
	
	else if
	(CourseCode.equalsIgnoreCase("T3")) {
		total=total+(300000);
	}
	
	else if
	(CourseCode.equalsIgnoreCase("T4")) {
		total=total+(250000);
	}
	
	else if
	(CourseCode.equalsIgnoreCase("T5")) {
		total=total+(300000);
	}

	else{
        System.out.println("Invalid Input ...!");
    }
	
	

	
	return total;
	
}

@Override
public void addMoreCourseSelection() {
	// TODO Auto-generated method stub
	
}

@Override
public int Course_Duration() {
	// TODO Auto-generated method stub
	return 0;
}


}
