package program1;

public class Teacher extends Person{
	
	protected String course;
	
	public Teacher(String course, String name, int age, char sex) {
		super(name, age, sex);
		this.course = course;
	}

	public String show()
	{
		super.show();
		System.out.println(" " + course);
		return "ok";
	}

}
