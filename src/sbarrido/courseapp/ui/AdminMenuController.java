package sbarrido.courseapp.ui;

import javax.swing.JPanel;

import java.awt.CardLayout;

import java.util.ArrayList;

public class AdminMenuController extends JPanel
{
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout = new CardLayout();
	private AdminMenuController_Depts adminDept;
	private ArrayList<AdminMenuController_Classes> adminClasses = new ArrayList<AdminMenuController_Classes>();
	
	public AdminMenuController()
	{
		adminDept = new AdminMenuController_Depts(AppFrame.deptMenu.getDepartments());
		adminDept.createDepartments();
		adminDept.createClassMenu();
		
		adminClasses = adminDept.getClassList();
		this.setLayout(cardLayout);
		this.add(adminDept, "Admin Department");
		for(AdminMenuController_Classes cMenu : adminClasses)
		{
			this.add(cMenu, cMenu.getDept().getName());
		}
		cardLayout.show(this, "Admin Department");
		this.setSize(AppFrame.FRAME_WIDTH - 200, AppFrame.FRAME_HEIGHT);
		this.setVisible(true);
	}
}
