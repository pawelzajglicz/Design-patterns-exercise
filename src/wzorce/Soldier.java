package wzorce;

public class Soldier
{

	private String name;
	private Weapon weapon;
	private Armor armor;
	private String troop;
	private int strength;
	private String type;
	// enum type

	private HealthState healthState;

	protected Soldier(String name, Weapon weapon, Armor armor, String troop, int strength, String type)
	{
		super();
		this.name = name;
		this.weapon = weapon;
		this.armor = armor;
		this.troop = troop;
		this.strength = strength;
		this.type = type;
	}

	
	@Override
	public String toString()
	{
		return type + "Soldier <br>[name=" + name + ", <br>weapon=" + weapon.getName() + ", <br>armor=" + armor.getName() + ", <br>troop=" + troop + ", <br>strength="
				+ strength + ", <br>healthState=" + healthState + "]";
	}



	public void heal()
	{
		healthState.healthBetter(this);
	}

	public void hurt()
	{
		healthState.healthWorse(this);
	}

	public void run()
	{
		healthState.run();
	}
	
	public String runDescription()
	{
		return healthState.runDescription();
	}
	
	
	

	public HealthState getHealthState()
	{
		return healthState;
	}

	public void setHealthState(HealthState healthState)
	{
		this.healthState = healthState;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Weapon getWeapon()
	{
		return weapon;
	}

	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}

	public Armor getArmor()
	{
		return armor;
	}

	public void setArmor(Armor armor)
	{
		this.armor = armor;
	}

	public String getTroop()
	{
		return troop;
	}

	public void setTroop(String troop)
	{
		this.troop = troop;
	}
	
	public int getStrength()
	{
		return strength;
	}

	public void setStrength(int strength)
	{
		this.strength = strength;
	}

}
