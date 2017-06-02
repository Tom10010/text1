package program1;

public class Person {
	
	protected String name;
	protected int age;
	protected char sex;
	
	public Person(String Name, int Age, char Sex)
	{
		this.name = Name;
		this.age = Age;
		this.sex = Sex;
	}
	
	public String show ()
	{
		System.out.print(name + " " + sex + " " + age);
		return name + " " + sex + " " + age;
	}
}
