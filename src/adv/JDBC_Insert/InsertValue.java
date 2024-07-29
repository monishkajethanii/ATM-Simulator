package adv.JDBC_Insert;

/*this program will create student database and store records table insert into query 
will be used to create student records*/
import java.sql.*;
public class InsertValue {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?characterEncoding=UTF-8",
                    "root", "Hellobitch@14");
            Statement stm = conn.createStatement();
            int i=stm.executeUpdate("INSERT INTO login1(username,password) values ('user_name','pass_word')");
            System.out.println(i);
            stm.execute("INSERT INTO login1(username,password) values ('abc12','pas123')");
            conn.close();
        } 
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
