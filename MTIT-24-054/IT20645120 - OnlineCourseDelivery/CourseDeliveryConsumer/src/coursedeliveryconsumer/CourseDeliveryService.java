package coursedeliveryconsumer;
import java.util.Scanner;

public class CourseDeliveryService implements CourseDelivery_Interface {

	@Override
	public Object Course_Id() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void CourseDeliveryService(CourseDelivery_Interface the_int, CourseDelivery_Interface ref) {
		// TODO Auto-generated method stub
		Scanner myobj = new Scanner(System.in);
		int Course_Duration, Number_of_Course=0;
		String Course_Type;
		Course_Duration= ((CourseDelivery_Interface) ref).Course_Duration();
		char op2,end;
		String Course_Name;
		
		while(Course_Duration != -1) {
			System.out.println("Welcome Student C - Continue T - Terminate");
			System.out.println("Available Course delivery for this time: " + Course_Duration);
			op2 = myobj.next().charAt(0);
			if(op2 == 'C' || op2 == 'c') {
				if(Course_Duration == 0) {
					System.out.println("*************Sorry Course Not Available*************");
					break;
					
				}
				while(true) {
					System.out.println("Number of Course");
					System.out.println("Student Name : ");
					Course_Name = myobj.next();
						System.out.println("What is your Course Type?");
						Course_Type = myobj.next();
						System.out.println("Enter number of course enrolled?");
						Number_of_Course = myobj.nextInt();
						break;
					}
				
				System.out.println("Hi " + Course_Name + " You Have selected " + Course_Type + " Courses");
				
				Course_Duration = Course_Duration - (Number_of_Course);
				
			}
			else if(op2 == 'T' || op2 == 't') {
				System.out.println("Thank You !!");
				break;
				
			}
			else {
				System.out.println("Enter a valid character");
			}
		}
		System.out.println("Press Any Key to ShutDown");
		end = myobj.next().charAt(0);
		
	}

	
}
