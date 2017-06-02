package page154_9_28;

import java.io.*;

class Student implements Serializable{
	private String name;
	public Student(String _name){
		this.name = _name;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}

public class ObjectStreamDemo {
	public  void read() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ObjIn = new ObjectInputStream(new FileInputStream("E:/stus.data"));
		int num = ObjIn.readInt();
		Student[] stus = new Student[num];
		for(int i = 0; i < num; i++){
			stus[i] = (Student)ObjIn.readObject();
		}
		ObjIn.close();
		disp(stus);
		}
	public void disp(Student[] stus){
		for(Student stu : stus){
			System.out.println(stu);
		}
	}
	public void save(Student[] stus) throws  IOException
	{
		ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("E:/suts.data"));
		objout.writeInt(stus.length);
		for(Student stu : stus){
			objout.writeObject(stu);
		}
		disp(stus);
		objout.close();
	}
	public static void main(String[] args) throws Exception{
		ObjectStreamDemo demo = new ObjectStreamDemo();
		Student[] stus = {new Student ("zhang"), new Student ("wang"), new Student ("li")};
		demo.save(stus);
		demo.read();
	}
}
