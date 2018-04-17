package sbarrido.courseapp.model;

public class Student extends Person
{
	public Student()
	{
		;
	}
	public Student(int _id, String _pass)
	{
		_id += 10000;
		this.setID(_id);
		this.setPass(_pass);
	}
}
