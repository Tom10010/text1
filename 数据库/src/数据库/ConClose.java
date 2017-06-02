package Êý¾Ý¿â;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConClose {
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
	public void insert() throws Exception{
		String sql = "insert into student values(?,?,32,65,98)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, 3);
		pstmt.setString(2, "zhang");
		//pstmt.setDouble(3, 91);
		//pstmt.setDouble(4, 99);
		//pstmt.setDouble(5, 65);
		pstmt.executeUpdate();
		pstmt.close();
	}
	public String[] returnStudent() throws Exception{
		String sql = "select * from student";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.last();
		int row = rs.getRow();
		String[] Student = new String[row];
		rs.beforeFirst();
		for(int i = 0; i < row; i++){
			Student[i] = String.valueOf(rs.getLong("ID")) + rs.getString("name") 
			+ String.valueOf(rs.getDouble("math")) + String.valueOf(rs.getDouble("os"))
			+ String.valueOf(rs.getDouble("java"));
		}
		return Student;
		
	}
	public static void main(String[] args) throws Exception {
		ConClose demo = new ConClose();
		//demo.init();
		try{
			//demo.initTable();
			demo.insert();
		}finally{
			demo.close();
		}
	}

}