package adv;
import java.sql.*;
public class JDBCTableRead {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?characterEncoding=UTF-8",  "root", "Hellobitch@14");
            Statement stm = conn.createStatement();
            //  stm.execute("ALTER TABLE student2 add percentage int");
            //  stm.execute("INSERT INTO student2(rollno,name,percentage) values ('55','Monishka Jethani',89)");
            //  stm.execute("INSERT INTO student2(rollno,name,percentage) values ('60','Pooja Shetty',59)");
            //  stm.execute("INSERT INTO student2(rollno,name,percentage) values ('62','Priyaa',76)");
            //  stm.execute("INSERT INTO student2(rollno,name,percentage) values ('01','Laxmii',72)");
            ResultSet rs = stm.executeQuery("SELECT * FROM student2 WHERE percentage > 70");
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






