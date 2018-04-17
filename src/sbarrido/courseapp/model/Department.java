package sbarrido.courseapp.model;
import java.util.ArrayList;

public class Department 
{
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private String name;
	
	public Department(String _name)
	{
		this.name = _name;
	}
	public Department(String _name, ArrayList<Course> courses)
	{
		this.name = _name;
		this.courseList = courses;
	}

	public ArrayList<Course> getList()
	{
		return this.courseList;
	}
	protected void setList(ArrayList<Course> courses)
	{
		this.courseList = courses;
	}
	public String getName()
	{
		return this.name;
	}
}
