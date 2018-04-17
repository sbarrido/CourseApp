package sbarrido.courseapp;
import sbarrido.courseapp.ui.*;
import sbarrido.courseapp.model.*;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.util.ArrayList;
public class Application 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
				{

					@Override
					public void run() 
					{
						new Application().createAndShowUI();
						
					}
			
				});
	}
	
	private void createAndShowUI()
	{
		//TODO
	}
	private void addComponents(final JFrame frame)
	{
		
	}
}