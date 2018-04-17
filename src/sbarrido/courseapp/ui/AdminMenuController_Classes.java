package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
public class AdminMenuController_Classes extends JPanel
{

	private static final long serialVersionUID = 1L;
	private BorderLayout borderLayout = new BorderLayout();
	private Department dept;
	private Course selectedCourse;
	public AdminMenuController_Classes(Department _dept)
	{
		super();
		dept = _dept;
		
		deptName();
		createCourses();
		createButtons();
		this.setLayout(borderLayout);
		this.setSize(AppFrame.FRAME_WIDTH - 200, AppFrame.FRAME_HEIGHT);
		this.setBackground(Color.YELLOW);
		this.setVisible(true);
	}
	
	private void createCourses()
	{
		ArrayList<Course> currentCourses = dept.getList();
		JPanel radioContainer = new JPanel();
		radioContainer.setLayout(new BoxLayout(radioContainer, BoxLayout.Y_AXIS));
		ButtonGroup buttGroup = new ButtonGroup();
		
		for(Course course : currentCourses)
		{
			JRadioButton radioButton = new JRadioButton(course.getName());
			radioButton.setName(course.getName());
			radioButton.setAlignmentX(CENTER_ALIGNMENT);
			radioButton.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent event) 
						{
							JRadioButton radioButton = (JRadioButton) event.getSource();
							String courseName = radioButton.getName();
							
							searchCourse(courseName);
						}
						private void searchCourse(String _courseName)
						{
							ArrayList<Course> searchCourses = dept.getList();
							for(Course item : searchCourses)
							{
								if(item.getName().equals(_courseName))
								{
									selectedCourse = item;
								}
							}
						}
					});
		buttGroup.add(radioButton);
		radioButton.setAlignmentX(CENTER_ALIGNMENT);
		radioContainer.add(radioButton);
		}
		radioContainer.setVisible(true);
		this.setLayout(borderLayout);
		this.add(radioContainer, BorderLayout.CENTER);
	}
	private void createButtons()
	{
		JPanel buttonContainer = new JPanel();
		JButton removeCourse = new JButton("Remove Course");
		removeCourse.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event) 
					{
						dept.getList().remove(selectedCourse);
						createCourses();
					}
				});
		buttonContainer.add(removeCourse);
		this.add(buttonContainer, BorderLayout.PAGE_END);
	}
	private void deptName()
	{
		JLabel name = new JLabel(this.dept.getName());
		this.setLayout(borderLayout);
		this.add(name, BorderLayout.PAGE_START);
	}
	public Department getDept()
	{
		return this.dept;
	}
}
