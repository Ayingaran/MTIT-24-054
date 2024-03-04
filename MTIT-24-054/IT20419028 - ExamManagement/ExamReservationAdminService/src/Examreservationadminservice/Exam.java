package Examreservationadminservice;

public class Exam {
	private static int count=1;
	private String Name;
	private double fees;
	int No;

	
	public Exam(String name, double fees) {
		super();
		No=count++; //No increases when creating a Pizza object
		Name = name;
		this.fees = fees;
		
	}
	
	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public double getPrice() {
		return fees;
	}
	
	public void setPrice(double fees) {
		this.fees = fees;
	}
	
}
