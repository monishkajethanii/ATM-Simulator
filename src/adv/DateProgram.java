package adv;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import javax.swing.*;
public class DateProgram{
	
	DateProgram(){
	JDateChooser dateChooser = new JDateChooser();
	JFrame frame = new JFrame("My App");
	frame.setLayout(new FlowLayout());

	// Add JDateChooser to the frame
	frame.add(dateChooser);

	// Set frame properties and make it visible
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String args[]){
		new DateProgram();
	}
}