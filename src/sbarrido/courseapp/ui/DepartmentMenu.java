package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Color;


public class DepartmentMenu extends JPanel
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Department> listDepartments = new ArrayList<Department>();
	private ArrayList<JButton> listButtons = new ArrayList<JButton>();
	private ArrayList<ClassMenu> listClassMenus = new ArrayList<ClassMenu>();
	
	public DepartmentMenu()
	{
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(AppFrame.FRAME_WIDTH, AppFrame.FRAME_HEIGHT);
		this.setBackground(Color.ORANGE);
		this.setVisible(true);
	}
	public void createButtons()
	{
		for(Department dept : listDepartments)
		{
			JButton newButton = new JButton(dept.getName());
			
			newButton.setActionCommand(dept.getName());
			newButton.addActionListener( new ActionListener()
					{
						public void actionPerformed(ActionEvent event) 
						{
							JButton button = (JButton) event.getSource();
							JPanel buttonPanel = (JPanel) button.getParent();
							JPanel mainContainer = (JPanel) buttonPanel.getParent();
							CardLayout layout = (CardLayout) mainContainer.getLayout();
							String panelName = button.getActionCommand();
							layout.show(mainContainer, panelName);
						}
					});
			listButtons.add(newButton);
		}
		for(JButton button : listButtons)
		{
			button.setAlignmentX(CENTER_ALIGNMENT);
			this.add(button);
		}
	}
	
	
	public void menuName()
	{
		JLabel name = new JLabel("Select a Department");
		name.setAlignmentX(CENTER_ALIGNMENT);
		this.add(name);
	}
	public void addDepartment(Department dept)
	{
		listDepartments.add(dept);
	}	
	protected void createClassMenus()
	{
		for(Department dept : listDepartments)
		{
			ClassMenu deptClasses = new ClassMenu(dept);
			listClassMenus.add(deptClasses);
		}
	}
	
	public ArrayList<ClassMenu> getClassMenus()
	{
		return this.listClassMenus;
	}
	public ArrayList<Department> getDepartments()
	{
		return this.listDepartments;
	}
	
	public void setDepts(ArrayList<Department> _depts)
	{
		this.listDepartments = _depts;
	}
}
