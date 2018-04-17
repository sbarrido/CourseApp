import sbarrido.courseapp.model.*;
import sbarrido.courseapp.ui.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.CardLayout;
public class Test 
{
	public static void main(String[] args)
	{
		int[] time = {2, 5};
		Course c211 = new Course(time, "H32", "C211");
		Course c242 = new Course(time, "H53", "C242");
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(c211);
		courses.add(c242);
		
		Department computerScience = new Department("Computer Science", courses);
		
		DepartmentMenu menu = new DepartmentMenu();
		menu.addDepartment(computerScience);
		menu.menuName();
		menu.createButtons();
		
		
	}
}
