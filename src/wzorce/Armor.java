package wzorce;

public abstract class Armor {
	String name;

	@Override
	public String toString()
	{
		return "Armor [name=" + name + "]";
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
