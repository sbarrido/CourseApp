package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuPerson extends JPanel
{

	private static final long serialVersionUID = 1L;
	private Person user;
	private BorderLayout borderLayout = new BorderLayout();
	public AdminMenuPerson(Person _user)
	{
		user = _user;
		
		JLabel name = new JLabel("Admin " + user.getID());
		JButton logout = new JButton("Logout");
		logout.setActionCommand("Login Menu");
		logout.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event) 
					{
						JButton button = (JButton) event.getSource();
						JPanel adminMenuPerson = (JPanel) button.getParent();
						JPanel adminMenu = (JPanel) adminMenuPerson.getParent();
						JPanel mainContainer = (JPanel) adminMenu.getParent();
						CardLayout layout = (CardLayout) mainContainer.getLayout();
						
						String panelName = button.getActionCommand();
						layout.show(mainContainer, panelName);
					}
					
				});
		this.setLayout(borderLayout);
		this.add(name, BorderLayout.PAGE_START);
		this.add(logout, BorderLayout.PAGE_END);
		this.setBackground(Color.GRAY);
		this.setVisible(true);
	}
}
