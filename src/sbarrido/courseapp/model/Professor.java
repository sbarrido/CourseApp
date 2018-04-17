package sbarrido.courseapp.model;
import java.util.ArrayList;

public class Professor extends Person
{
	private ArrayList<int[]> officeHours = new ArrayList<int[]>();
	
	public Professor(int _id)
	{
		this.setID(_id);
	}
	protected ArrayList<Integer> getOfficeHours(ArrayList<ArrayList<Integer>> hours)
	{
		return null;
	}
	
	protected void addOfficeHours(int[] hours)
	{
		officeHours.add(hours);
	}
	protected void removeOfficeHours(int[] hours)
	{
		officeHours.remove(hours); 
	}
}
