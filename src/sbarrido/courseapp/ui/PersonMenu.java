package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.util.ArrayList;
public class PersonMenu extends JPanel
{
	private static final long serialVersionUID = 1L;
	public static JTextArea userClasses;
	private static Person user;
	
	
	public PersonMenu(Person _user)
	{
		super();
		user = _user;
		
		JPanel buttonMenu = this.menuButtons();
		JPanel classPerson = this.personClasses();
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.add(buttonMenu, BorderLayout.WEST);
		this.add(classPerson, BorderLayout.CENTER);
		this.setSize(AppFrame.FRAME_WIDTH, AppFrame.FRAME_HEIGHT);
		this.setBackground(Color.ORANGE);
		this.setVisible(true);
	}
	protected Person getUser()
	{
		return this.user;
	}
	private JPanel menuButtons()
	{
		JLabel userName = new JLabel("" + user.getID());
		
		JButton addCourse = new JButton("Add Course");
		addCourse.setName("" + user.getID());
		addCourse.setActionCommand("Department Menu");
		addCourse.addActionListener(new ActionListener()
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
		
		JButton logout = new JButton("Logout");
		logout.setActionCommand("Login Menu");
		logout.addActionListener( new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event) 
					{
						JButton button = (JButton) event.getSource();
						JPanel personMenuButtons = (JPanel) button.getParent();
						JPanel personMenu = (JPanel) personMenuButtons.getParent();
						JPanel mainContainer = (JPanel) personMenu.getParent();
						CardLayout layout = (CardLayout) mainContainer.getLayout();
						
						String panelName = button.getActionCommand();
						layout.show(mainContainer, panelName);
					}
				});
		
		JPanel buttonContainer = new JPanel();
		buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));		
		buttonContainer.add(userName);
		buttonContainer.add(addCourse);
		buttonContainer.add(logout);
		
		return buttonContainer;
	}
	private JPanel personClasses()
	{
		JPanel personClasses = new JPanel();
		personClasses.setLayout(new BoxLayout(personClasses, BoxLayout.Y_AXIS));
		
		JLabel listLabel = new JLabel("List of Registered Classes");
		userClasses = new JTextArea(this.writeClasses());
		userClasses.setEditable(false);
		JScrollPane scroll = new JScrollPane(userClasses);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		personClasses.add(listLabel);
		personClasses.add(scroll);
		personClasses.setBackground(Color.ORANGE);
		personClasses.setSize(AppFrame.FRAME_WIDTH - 200, AppFrame.FRAME_HEIGHT);
		personClasses.setVisible(true);
		
		return personClasses;
	}
	public static String writeClasses()
	{
		ArrayList<Course> userSchedule = user.getSchedule();
		String toPrint = "";
		String newLine = String.format("%n");
		for(Course course : userSchedule)
		{
			toPrint += newLine;
			toPrint += course.getName();
			toPrint += newLine;
			toPrint += course.getStringTime();
			toPrint += newLine;
		}
		
		return toPrint;
	}
}
