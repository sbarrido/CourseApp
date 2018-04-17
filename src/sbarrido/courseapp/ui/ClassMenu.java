package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClassMenu extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Department dept;
	public static ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
	
	public ClassMenu(Department _dept)
	{
		super();
		this.dept =  _dept;
		ClassMenuButtons courseButtons = new ClassMenuButtons();
		ClassMenuCourses courses = new ClassMenuCourses(this.dept);
		this.add(courses);
		this.add(courseButtons);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(AppFrame.FRAME_WIDTH, AppFrame.FRAME_HEIGHT);
		this.setBackground(Color.ORANGE);
		this.setVisible(true);
		
	}
	public Department getDepartment()
	{
		return this.dept;
	}
	/*
	private JPanel menuButtons(Person _user)
	{
		JButton register = new JButton("Register");
		register.setActionCommand(String.valueOf(_user.getID()));
		register.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event)
					{
						JButton button = (JButton) event.getSource();
						JPanel buttonMenu = (JPanel) button.getParent();
						ClassMenu classMenu = (ClassMenu) buttonMenu.getParent();
						JPanel mainContainer = (JPanel) classMenu.getParent();
						
						Department dept = classMenu.getDepartment();
						
						for(JCheckBox box : checkBoxes)
						{
							String selectedCourse = box.getName();
							for(Course course : dept.getList())
							{
								if(selectedCourse.equals(course.getName()))
								{
									if((_user.isTimeAvail(course)) && (course.getSpace() > 0))
									{
										course.addPerson(_user);
										course.setSpace(course.getSpace() - 1);
										
										_user.addCourse(course);
									}
									else
									{
										_user.rmvCourse(course);
									}
								}
							}
						}
					}
				});
		
	}
	*/
}
