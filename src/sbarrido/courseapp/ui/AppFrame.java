package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.CardLayout;

import java.util.ArrayList;
public class AppFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	private CardLayout cardLayout = new CardLayout();
	private JPanel mainContainer = new JPanel(cardLayout);
	public static Person currentUser = new Student(45, "test");
	private ArrayList<Person> listUsers = new ArrayList<Person>();
	public static DepartmentMenu deptMenu = new DepartmentMenu();
	private ArrayList<PersonMenu> personMenus = new ArrayList<PersonMenu>();
	private AdminMenu adminMenu;
	private ArrayList<ClassMenu> classMenus;
	
	
	public AppFrame()
	{
		Person newUser = currentUser;
		Person newAdmin = new Admin(88, "test");
		PersonMenu test1 = new PersonMenu(newUser);
		personMenus.add(test1);
		deptMenu = new DepartmentMenu();
		deptMenu.menuName();
		listUsers.add(newUser);
		listUsers.add(newAdmin);
		
		int[] time = {6, 8};
		int[] time1 = {9, 10};
		Course c211 = new Course(time, "H32", "C211");
		Course c242 = new Course(time, "H53", "c242");
		ArrayList<Course> courses1 = new ArrayList<Course>();
		courses1.add(c211);
		courses1.add(c242);
		Course alg = new Course(time1, "J32", "Algebra");
		Course stat = new Course(time1, "X23", "Statistics");
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(alg);
		courses.add(stat);
		Department computerScience = new Department("Computer Science", courses1);
		Department math = new Department("Math" , courses);
		deptMenu.addDepartment(computerScience);
		deptMenu.addDepartment(math);
		deptMenu.createButtons();
		deptMenu.createClassMenus();
		
		classMenus = deptMenu.getClassMenus();
	
		adminMenu = new AdminMenu(newAdmin);
		// MAIN CODE for MainCONTAINER
		mainContainer.add(deptMenu, "Department Menu");
		mainContainer.add(adminMenu, "Admin Menu");
		for(Person user : listUsers)
		{
			if(user instanceof Student)
			{
				PersonMenu pMenu = new PersonMenu(user);
				personMenus.add(pMenu);
			}
		}
		
		for(ClassMenu cMenu : classMenus)
		{
			mainContainer.add(cMenu, cMenu.getDepartment().getName());
		}
		for(PersonMenu pMenu : personMenus)
		{
			mainContainer.add(pMenu, String.valueOf(pMenu.getUser().getID()));
		}
		LoginMenu test = new LoginMenu();
		mainContainer.add(test, "Login Menu");
		
		//END MAIN CODE FOR MAIN
		
		this.add(mainContainer);
		cardLayout.show(mainContainer, "Login Menu");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	public ArrayList<ClassMenu> getClassMenus()
	{
		return this.classMenus;
	}
	public ArrayList<Person> getUserList()
	{
		return this.listUsers;
	}
	public void addPerson(Person newUser)
	{
		listUsers.add(newUser);
		for(Person user : listUsers)
		{
			if(user instanceof Student)
			{
				PersonMenu pMenu = new PersonMenu(user);
				personMenus.add(pMenu);
			}
		}
		for(PersonMenu pMenu : personMenus)
		{
			mainContainer.add(pMenu, String.valueOf(pMenu.getUser().getID()));
		}
		this.revalidate();
	}
	public void addDepartment(Department _dept)
	{
		deptMenu.addDepartment(_dept);
		deptMenu.createButtons();
		deptMenu.createClassMenus();
		classMenus = deptMenu.getClassMenus();
		
		for(ClassMenu cMenu : classMenus)
		{
			mainContainer.add(cMenu, cMenu.getDepartment().getName());
		}
		this.revalidate();
	}
	public static void main(String[] args)
	{
		AppFrame appFrame = new AppFrame();
	}
	
}
