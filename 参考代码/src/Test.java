import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Test {
    /**
     * @param args
     */
    public static void main(String[] args){
        try {
                //加载HSQLDB数据库JDBC驱动
                Class.forName("org.hsqldb.jdbcDriver");
                //在内存中建立临时数据库score，用户名为sa，密码为空
                @SuppressWarnings("unused")
                Connection connect = DriverManager.getConnection("jdbc:hsqldb:mem:score", "sa", "");
                System.out.println("Link is OK！");
                
                Statement state = connect.createStatement(); 
                state.executeUpdate("create table Tb1 (ID INTEGER, Name VARCHAR(20))");
                System.out.println("Create is  OK！");
                
                state.executeUpdate("Insert into Tb1 (ID, Name) Values(1, '潘永刚')");
                state.executeUpdate("Insert into Tb1 (ID, Name) Values(2, '刘德华')");
                System.out.println("Insert is OK！");
                
                PreparedStatement pstmt2   =   connect.prepareStatement("select * from Tb1");   
                ResultSet rs = pstmt2.executeQuery();   
                while(rs.next()){  
                    String x;
                    x = rs.getString(1) + "   " + rs.getString(2);                  
                    System.out.println(x);                      
                }   
                System.out.println("Select is OK！");
                pstmt2.close();
                rs.close();
                
                state.close();
                connect.close();
                
            } catch (SQLException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e){
                  e.printStackTrace();
            }              
    }
}