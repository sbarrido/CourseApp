package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginMenu extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JPanel componentContainer;
	public static JTextField userLogin;
	public static JTextField passLogin;
	
	public LoginMenu()
	{		
		super();	
		componentContainer = new JPanel();
		componentContainer.setLayout(new BoxLayout(componentContainer, BoxLayout.Y_AXIS));
		
		JPanel loginContainer = createUserField();
		JPanel passContainer = createPassField();
		JPanel buttonContainer = createLogButton();
		loginContainer.setAlignmentX(CENTER_ALIGNMENT);
		passContainer.setAlignmentX(CENTER_ALIGNMENT);
		buttonContainer.setAlignmentX(CENTER_ALIGNMENT);
		componentContainer.add(loginContainer);
		componentContainer.add(passContainer);
		componentContainer.add(buttonContainer);
		
		JLabel title = new JLabel("Login Authentication");
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.add(title, BorderLayout.PAGE_START);
		this.add(componentContainer, BorderLayout.CENTER);
		this.setSize(300, 200);
		this.setVisible(true);
	}
	private JPanel createUserField()
	{
		JPanel loginContainer = new JPanel();
		JLabel loginLabel = new JLabel("Username");
		userLogin = new JTextField(20);
		userLogin.setName("userLog");
		userLogin.setBounds(5, 5, 150, 20);
		loginContainer.add(loginLabel);
		loginContainer.add(userLogin);
		
		return loginContainer;
	}
	private JPanel createPassField()
	{
		JPanel passContainer = new JPanel();
		JLabel passLabel = new JLabel("Password");
		passLogin = new JTextField(20);
		passLogin.setName("userPass");
		passLogin.setBounds(5, 5, 150, 20);
		passContainer.add(passLabel);
		passContainer.add(passLogin);
		
		return passContainer;
	}
	private JPanel createLogButton()
	{
		JPanel buttonContainer = new JPanel();
		buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setAlignmentX(CENTER_ALIGNMENT);
		
		buttonLogin.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent event) 
					{
						JButton button = (JButton) event.getSource();
						JPanel buttonContainer = (JPanel) button.getParent();
						JPanel compContainer = (JPanel) buttonContainer.getParent();
						LoginMenu logMenu = (LoginMenu) compContainer.getParent();
						JPanel mainContainer = (JPanel) logMenu.getParent();
						CardLayout cardLayout = (CardLayout) mainContainer.getLayout();
						AppFrame appFrame = (AppFrame) SwingUtilities.getWindowAncestor(logMenu);
						
						search:
						for(Person user : appFrame.getUserList())
						{
							int idInput = Integer.parseInt(LoginMenu.userLogin.getText());
							int userID = user.getID();
							String passInput = LoginMenu.passLogin.getText();
							String userPass = user.getPass();
							Boolean correctInfo = (idInput == userID) && (passInput.equals(userPass));
							
							if(!correctInfo)
							{
								System.out.println("Incorrect Username or Password");
								LoginMenu.userLogin.setText("");
								LoginMenu.passLogin.setText("");
							}
							else
							{
								if(user instanceof Student)
								{
									AppFrame.currentUser = user;
									System.out.println(AppFrame.currentUser.getID());
									cardLayout.show(mainContainer, String.valueOf(user.getID()));
									break search;
								}
								else if(user instanceof Admin)
								{
									AppFrame.currentUser = user;
									cardLayout.show(mainContainer, "Admin Menu");
								}
								
								LoginMenu.userLogin.setText("");
								LoginMenu.passLogin.setText("");
								break search;
							}
						}
					}
					
				});
		buttonContainer.add(buttonLogin);
		return buttonContainer;
	}
}
