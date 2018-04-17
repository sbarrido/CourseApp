package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class ClassMenuButtons extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public ClassMenuButtons()
	{
		super();
		
		JButton register = new JButton("Register");
		JButton details = new JButton("More Details");
		register.setActionCommand(String.valueOf(AppFrame.currentUser.getID()));
		register.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event) 
					{
						JButton button = (JButton) event.getSource();
						JPanel buttonPanel = (JPanel) button.getParent();
						ClassMenu classMenu = (ClassMenu) buttonPanel.getParent();
						
						Department dept = classMenu.getDepartment();
						Person user = AppFrame.currentUser;
						//TESTING PURPSOSE
						System.out.println("I got clicked");
						if(user instanceof Student)
						{
							user = (Student) user;
						}
						if(user instanceof Professor)
						{
							user = (Professor) user;
						}
						
						ArrayList<JCheckBox> checkBoxes = ClassMenu.checkBoxes;
						
						if(!(checkBoxes.size() > 0))
						{
							PersonMenu.userClasses.setText("");
							for(Course course : dept.getList())
							{
								user.rmvCourse(course);
							}
						}
						else
						{
							for(JCheckBox checkbox : checkBoxes)
							{
								String selectedCourse = checkbox.getName();
								for(Course course : dept.getList())
								{
									if(selectedCourse.equals(course.getName()))
									{
										if((user.isTimeAvail(course)) && (course.getSpace() > 0))
										{
											course.addPerson(user);
											course.setSpace(course.getSpace() - 1);
											
											user.addCourse(course);
										}
										else
										{
											user.rmvCourse(course);
										}
									}
								}
							}
						}
						PersonMenu.userClasses.setText(PersonMenu.writeClasses());
					}
				});
		register.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent event) 
					{
						JButton button = (JButton) event.getSource();
						JPanel buttonPanel = (JPanel) button.getParent();
						JPanel personMenu = (JPanel) buttonPanel.getParent();
						JPanel mainContainer = (JPanel) personMenu.getParent();
						CardLayout layout = (CardLayout) mainContainer.getLayout();
						String panelName = button.getActionCommand();
						layout.show(mainContainer, panelName);
						
					}
					
				});
		this.add(register);
		this.add(details);
		this.setSize(AppFrame.FRAME_WIDTH, AppFrame.FRAME_WIDTH);
		this.setBackground(Color.GRAY);
		this.setVisible(true);
	}
}
