package program1;

public class PersonApp {
	
	public static void main(String[] args) {
		Person P = new Person("Zhang", 19, 'M');
		Student S = new Student(2015169, "wang", 19, 'M');
		Teacher T = new Teacher("English", "Huang", 35, 'F');
		S.show();
		T.show();
		P.show();
		
	}
}
