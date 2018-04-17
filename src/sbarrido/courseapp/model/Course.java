package sbarrido.courseapp.model;
import java.util.ArrayList;
public class Course 
{
	private int[] time = new int[2];
	private String location;
	private String name;
	private ArrayList<Person> people = new ArrayList<Person>();
	private int spaceAvailable;
	
	public Course(int[] _time, String _location, String _name)
	{
		this.time = _time;
		this.location = _location;
		this.spaceAvailable = 50;
		this.name = _name;
	}
	
	protected int[] getTime()
	{
		return this.time;
	}
	protected String getLocation()
	{
		return this.location;
	}
	public int getSpace()
	{
		return spaceAvailable;
	}
	public String getName()
	{
		return this.name;
	}
	
	protected void setTime(int[] newTime)
	{
		this.time = newTime;
	}
	protected void setLocation(String newLocation)
	{
		this.location = newLocation;
	}
	public void setSpace(int vacant)
	{
		this.spaceAvailable = vacant;
	}
	public void addPerson(Person individual)
	{
		people.add(individual);
	}
	protected void removePerson(Person individual)
	{
		people.remove(individual);
	}
	protected void setName(String _name)
	{
		this.name = _name;
	}
	public String getStringTime()
	{
		String toReturn = "";
		for(int i = 1; i < time.length; i++)
		{
			toReturn += time[i-1] + ":00 -" + time[i] + ":00";
		}
		return toReturn;
	}
}
