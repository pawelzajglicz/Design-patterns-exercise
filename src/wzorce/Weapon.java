package wzorce;

public abstract class Weapon {

	String name;
	
	@Override
	public String toString()
	{
		return "Weapon [name=" + name + "]";
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
}
