package adv;
import java.sql.*;

public class JDBC_Table {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?characterEncoding=UTF-8",  "root", "Hellobitch@14");
            Statement stm = conn.createStatement();
             stm.execute("INSERT INTO student2(rollno,name,percentage) values ('46','Hiren Talreja',99)");
             //stm.execute("INSERT INTO student2(rollno,name,percentage) values ('12','Ruchika Dingria',89)");
            ResultSet rs = stm.executeQuery("SELECT * FROM student2 WHERE percentage >= 90");

            // Iterate through the result set and print the results
            while (rs.next()) {
                int rollno = rs.getInt("rollno");
                String name = rs.getString("name");
                int percentage = rs.getInt("percentage");
                System.out.println("Roll No: " + rollno + ", Name: " + name + ", Percentage: " + percentage);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

