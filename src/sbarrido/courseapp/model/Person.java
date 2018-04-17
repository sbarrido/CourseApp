package sbarrido.courseapp.model;
import java.util.ArrayList;
public abstract class Person 
{
	private ArrayList<Course> schedule = new ArrayList<Course>();
	private int ID;
	private String password;
	public int getID()
	{
		return this.ID;
	}
	public String getPass()
	{
		return this.password;
	}
	public ArrayList<Course> getSchedule()
	{
		return schedule;
	}
	public Boolean isTimeAvail(Course newCourse)
	{
		Boolean available = false;
		if(!(schedule.size() > 0))
		{
			available = true;
		}
		else
		{
			System.out.println("I entereed for-loop");
			outerloop:
			for(int i = 0; i < schedule.size(); i++)
			{
				int[] currentDuration = schedule.get(i).getTime();
				int[] checkDuration = newCourse.getTime();
				for(int j = 0; j < checkDuration.length; j++)
				{
					boolean conflict = (checkDuration[j] >= currentDuration[0]) && (checkDuration[j] <= currentDuration[1]);
					if(!conflict)
					{
						available = true;
					}
					else
					{
						available = false;
						break outerloop;
					}
				}
			}
		}
		
		return available;
	}
	
	protected void setSchedule(ArrayList<Course> _schedule)
	{
		this.schedule = _schedule;
	}
	public void addCourse(Course newCourse)
	{
		schedule.add(newCourse);
	}
	public void rmvCourse(Course newCourse)
	{
		schedule.remove(newCourse);
	}
	protected void setID(int num)
	{
		this.ID = num;
	}
	protected void setPass(String _pass)
	{
		this.password = _pass;
	}
	
}


