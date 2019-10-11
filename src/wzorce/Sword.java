package wzorce;

public class Sword extends Weapon implements Medieval
{
	
	
	public Sword()
	{
		super();
		this.name = "Sword";
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
