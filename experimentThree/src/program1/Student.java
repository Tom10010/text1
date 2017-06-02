package program1;

public class Student extends Person{
	
	private int id;
	
	public Student(int id, String name, int age, char sex) {
		super(name, age, sex);
		this.id = id;
	}

	public String show()
	{
		super.show();
		System.out.println(" " + id);
		return "ok";
	}
}
