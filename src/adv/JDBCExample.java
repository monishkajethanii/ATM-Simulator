package adv;
import java.sql.*;
class JDBCExample { 
    public static void main(String args[]) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
                 
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?characterEncoding=UTF-8",
                "root", "Hellobitch@14");
        // 
        Statement stm = conn.createStatement();
        // 
        // stm.execute("CREATE TABLE news1 (fname varchar(20), lname varchar(20), age
        // int);");
        // stm.execute("INSERT INTO news1 (fname,lname,age) values
        // ('Monishka','Jethani',18)");
        ResultSet rs=stm.executeQuery("SELECT * FROM news1");
        while(rs.next()){
            String fname=rs.getString("fname");
            String lname=rs.getString("lname");
            int age=rs.getInt("age");
            System.out.println("First name= "+fname+" Last Name= "+lname+" Age = "+age);
        }
        conn.close();
    }
}