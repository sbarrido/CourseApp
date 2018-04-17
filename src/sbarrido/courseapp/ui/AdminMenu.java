package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;
import javax.swing.JPanel;

import java.awt.BorderLayout;
public class AdminMenu extends JPanel
{

	private static final long serialVersionUID = 1L;
	private BorderLayout borderLayout = new BorderLayout();
	private AdminMenuController controller;
	private AdminMenuPerson personBar;
	
	public AdminMenu(Person user)
	{
		controller = new AdminMenuController();
		personBar = new AdminMenuPerson(user);
		this.setLayout(borderLayout);
		
		this.add(personBar, BorderLayout.WEST);
		this.add(controller, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
