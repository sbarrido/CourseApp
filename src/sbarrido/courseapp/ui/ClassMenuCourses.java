package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ClassMenuCourses extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Department dept;
	
	public ClassMenuCourses(Department _dept)
	{
		super();
		this.dept = _dept;
		
		deptName();
		createCourses();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(AppFrame.FRAME_WIDTH, AppFrame.FRAME_HEIGHT);
		this.setBackground(Color.ORANGE);
		this.setVisible(true);
		
	}
	private void createCourses()
	{
		for(Course course : this.dept.getList())
		{
			JCheckBox courseBox = new JCheckBox(course.getName());
			courseBox.setName(course.getName());
			courseBox.setAlignmentX(CENTER_ALIGNMENT);
			courseBox.addItemListener(new ItemListener()
					{
				@Override
				public void itemStateChanged(ItemEvent event) 
				{
					JCheckBox checkBox = (JCheckBox) event.getSource();
					if(checkBox.isSelected())
					{
						ClassMenu.checkBoxes.add(checkBox);
						System.out.print("I got selected");
					}
					if(!checkBox.isSelected())
					{
						ClassMenu.checkBoxes.remove(checkBox);
						System.out.println("I removed a checkbox");
					}
				}
					});
			this.add(courseBox);
		}
	}
	private void deptName()
	{
		JLabel name = new JLabel(this.dept.getName());
		name.setAlignmentX(CENTER_ALIGNMENT);
		this.add(name);
	}
}
