package experimentseven;

import java.sql.*;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

class Student{
	private long id;
	private String name;
	private double math;
	private double os;
	private double java;
	public Student(long ID, String Name, double Math, double Os, double Java){
		this.id = ID;
		this.name = Name;
		this.math = Math;
		this.os = Os;
		this.java = Java;				
	}
	public long getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	public double getMath(){
		return math;
	}
	public double getOs(){
		return os;
	}

	public double getJava(){
		return java;
	}

}

public class ManagerStudent {
	String driver = "org.hsqldb.jdbcDriver";
	String url = "jdbc:hsqldb:hsql://localhost";
	String user = "sa";
	String pass = "";
	private Connection con;
	public void init() throws Exception{
		if(con != null) return;
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}
	
	public void close() throws Exception{
		if(con != null)
			con.close();
	}
	public void initTable() throws SQLException{
		String sql = "create table student(id bigint,name varchar(120),";
		sql += "os decimal,math decimal,java decimal)";
		Statement stmt = con.createStatement();
		stmt.executeQuery(sql);
		stmt.close();
	}

	//向数据库里添加学生
	public void add(Student stu) throws SQLException{
		String sql = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, stu.getID());
		pstmt.setString(2, stu.getName());
		pstmt.setDouble(3, stu.getMath());
		pstmt.setDouble(4, stu.getOs());
		pstmt.setDouble(5, stu.getJava());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	//显示所有的学生
	public void dispAll() throws SQLException{
		String sql = "select * from student";
		Statement stmt = con.createStatement( );
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			double math = rs.getDouble("math");
			double os = rs.getDouble("os");
			double java = rs.getDouble("java");
			System.out.printf("%d,%s,%.1f,%.1f,%.1f%n",id, name, math, os, java);
		}
		
		rs.close();
		stmt.close();
	}
	
	//按学号查询
	public void findID(long ID) throws SQLException{
		String sql = "select * from student where id=" + ID;
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(sql);
		rs.beforeFirst();
		rs.last();
		int total = rs.getRow();
		if(total == 0){
			System.out.println("数据库里没有学号为" + ID + "的学生");
		}
		else{
			rs.beforeFirst();
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			double math = rs.getDouble("math");
			double os = rs.getDouble("os");
			double java = rs.getDouble("java");
			System.out.printf("%d,%s,%.1f,%.1f,%.1f%n",id, name, math, os, java);
		}
		}
		rs.close();
		stmt.close();
	}
	
	//按姓名查询
	public void findName(String Name) throws SQLException{
		String sql = "select * from student where name='" + Name + "'";
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(sql);
		rs.beforeFirst();
		rs.last();
		int total = rs.getRow();
		if(total == 0){
			System.out.println("数据库里没有姓名为" + Name + "的学生");
		}
		else{
			rs.beforeFirst();
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			double math = rs.getDouble("math");
			double os = rs.getDouble("os");
			double java = rs.getDouble("java");
			System.out.printf("%d,%s,%.1f,%.1f,%.1f%n",id, name, math, os, java);

		}
		}
		rs.close();
		stmt.close();
	}
	
	//按学号删除
	public void delByID(long ID) throws SQLException{
		String sql = "delete from student where id =" + ID;
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("删除成功！");
	}
	
	//按成绩排序
	private void orderByGrade(String project) throws SQLException {
		String sql = "select ID,NAME,OS,MATH,JAVA from student order BY " + project + " desc ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			double math = rs.getDouble("math");
			double os = rs.getDouble("os");
			double java = rs.getDouble("java");
			System.out.printf("%d,%s,%.1f,%.1f,%.1f%n",id, name, math, os, java);

		}
		stmt.close();	
	}
	
	//按成绩排序
	public static void showMenu() throws Exception{
		ManagerStudent mana = new ManagerStudent();
		mana.init();
		System.out.println("1.显示所有学生信息\n2.按学号查找\n3.按姓名查找\n4.按学号删除\n5.按成绩排序\n6.退出");
		System.out.println("请输入指令：");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		
		while(true){
			switch(num){
			case 1:
				mana.dispAll();
				break;
			case 2:
				mana.findID(222);
				mana.findID(123);
				break;
			case 3:
				mana.findName("zhanghongtao");
				mana.findName("zhang");
				break;
			case 4:
				mana.delByID(111);
				break;
			case 5:
				mana.orderByGrade("os");
				break;
			case 6:
				return;
			default:
				showMenu();
			}
			num = in.nextInt();
		}
	}


	public static void main(String[] args) throws Exception {
		ManagerStudent mana = new ManagerStudent();
		mana.init();
		Student stu = new Student(123, "zhang", 32, 65, 98);
		//mana.add(stu);
		showMenu();	
		
	}

}
