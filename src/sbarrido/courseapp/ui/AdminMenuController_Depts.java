package sbarrido.courseapp.ui;
import sbarrido.courseapp.model.*;


import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class AdminMenuController_Depts extends JPanel
{

	private static final long serialVersionUID = 1L;
	private BorderLayout borderLayout = new BorderLayout();
	private ArrayList<Department> listDepartments = new ArrayList<Department>();
	private ArrayList<AdminMenuController_Classes> listClassMenus = new ArrayList<AdminMenuController_Classes>();
	
	public AdminMenuController_Depts(ArrayList<Department> departments)
	{
		super();
		
		listDepartments = departments;
		
		this.setLayout(borderLayout);
		this.setSize(AppFrame.FRAME_WIDTH - 200, AppFrame.FRAME_HEIGHT);
		this.setVisible(true);
	}
	public void createDepartments()
	{
		JPanel buttonContainer = new JPanel();
		buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));
		
		for(Department dept : listDepartments)
		{
			JPanel deptContainer = new JPanel();
			JButton deptButton = new JButton(dept.getName());
			deptButton.setName(dept.getName());
			deptButton.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent event)
						{
							JButton button = (JButton) event.getSource();
							JPanel buttonContainer = (JPanel) button.getParent();
							JPanel allButtsContainer = (JPanel) buttonContainer.getParent();
							JPanel adminMenuController_Depts = (JPanel) allButtsContainer.getParent();
							JPanel adminController = (JPanel) adminMenuController_Depts.getParent();
							CardLayout layout = (CardLayout) adminController.getLayout();
							
							String panelName = button.getName();
							layout.show(adminController, panelName);	
						}
					});
			
			JButton deptDelete = new JButton ("Delete");
			deptDelete.setName(dept.getName());
			deptDelete.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent event) 
						{
							JButton button = (JButton) event.getSource();
							String selectedDept = button.getName();
							removeDept(selectedDept);
							
							createDepartments();	
						}
						private void removeDept(String deptName)
						{
							for(Department dept : listDepartments)
							{
								if(dept.getName().equals(deptName))
								{
									listDepartments.remove(dept);
								}
							}
						}
						
					});
			
			deptContainer.add(deptButton);
			deptContainer.add(deptDelete);
			
			deptContainer.setVisible(true);
			deptContainer.setAlignmentX(CENTER_ALIGNMENT);
			buttonContainer.add(deptContainer);
		}
		
		this.add(buttonContainer, BorderLayout.CENTER);
	}

	public void createClassMenu()
	{
		for(Department dept : listDepartments)
		{
			AdminMenuController_Classes deptClasses = new AdminMenuController_Classes(dept);
			listClassMenus.add(deptClasses);
		}
	}
	public ArrayList<AdminMenuController_Classes> getClassList()
	{
		return this.listClassMenus;
	}

}
