package 数据库;
import java.sql.*;
public class DataBase {

	String driver = "org.hsqldb.jdbcDriver";
	String url = "jdbc:hsqldb:hsql://localhost";
	String user = "sa";
	String pass = "";
	Connection con;
	private void init() throws Exception{
		if(con != null)
			return;
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}
	private void close() throws Exception{
		if(con == null)
			return;
		con.close();
	}
	public void initTable() throws Exception{
		String sql = "create table ssstudent(id bigint, name varchar(120), math decimal)";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	//zeng
	private void insert(long id, String name, double math) throws Exception {
		//String sql = "insert into ssstudent  values(" + id + ",'" + name + "'," + math + ")";
		String sql = "insert into ssstudent values(123123, 'lidakang', 85)";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	//shan
	private void delete() throws Exception {
		String sql = "delete from ssstudent where id = 12347";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	//gai
	private void update() throws Exception {
		String sql = "update ssstudent set name = 'sunlian' where id =12346";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	//cha
	private void select() throws Exception {
		String sql = "select * from ssstudent";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			double math = rs.getDouble("math");
			System.out.printf("%d,%s,%.2f%n", id, name,math);
		}
		rs.close();
		stmt.close();
	}
	
	//排序
	private void sort() throws Exception {
		String sql = "select * from ssstudent order by name";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			double math = rs.getDouble("math");
			System.out.printf("%d,%s,%.2f%n", id, name,math);
		}
		rs.close();
		stmt.close();

	}
	
	//prepare 创建
	private void PinitTable() throws Exception {
			String sql = "create table teacher(id bigint, name varchar(120), course varchar(120))";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
	}
	
	//prepared 插入
	private void pinsert(long id, String name, String course) throws Exception {
		String sql = "insert into teacher values(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, course);
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	//prepared 删除
	private void Pdelete() throws Exception {
		String sql = "delete from teacher where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, 1001);
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	//Prepared 查找
	private void Psreach() throws Exception {
		String sql = "select * from teacher";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			String course = rs.getString("course");
			System.out.printf("%d,%s,%s%n", id, name, course);
		}
		rs.close();
		pstmt.close();
	}
	
	//prepared 改
	private void Pupdate() throws Exception {
		String sql  = "update teacher set course = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "English");
		pstmt.setLong(2, 10004);
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	//prepared 排序
	private void Porder() throws Exception {
		String sql = "select * from teacher order by id desc";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			long id = rs.getLong("id");
			String name = rs.getString("name");
			String course = rs.getString("course");
			System.out.printf("%d,%s,%s%n", id, name, course);
		}
		rs.close();
		pstmt.close();
	}
	public static void main(String[] args) throws Exception{
		DataBase data = new DataBase();
		data.init();
//		data.initTable();
//		data.insert(12346, "zhang", 90);
//		data.insert(12348, "lisisisi", 100);
//		data.delete();
//		data.update();
//		data.select();
//		data.sort();
//		data.PinitTable();
//		data.pinsert(10004, "sunlian", "os");
//		data.Pdelete();
//		data.Psreach();
//		data.Pupdate();
//		data.Porder();
		data.close();
	}
}
