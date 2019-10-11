package wzorce;

public class MedievalSoldierBuilder extends AbstractSoldierBuilder
{

	private String name;
	private Weapon weapon;
	private Armor armor;
	private String troop;
	
	private static int defaultStrength = 100;

	public MedievalSoldierBuilder setName(String name)
	{
		this.name = name;
		return this;
	}

	public MedievalSoldierBuilder setWeapon(Weapon weapon)
	{
		if (!(weapon instanceof Medieval))
			throw new RuntimeException("Medieval soldier can only have the medieval equipment!!!");

		this.weapon = weapon;
		return this;
	}
	
	

	public MedievalSoldierBuilder setArmor(Armor armor)
	{
		this.armor = armor;
		return this;
	}

	public MedievalSoldierBuilder setTroop(String troop)
	{
		this.troop = troop;
		return this;
	}

	public static void setDefaultStrength(int defaultStrength)
	{
		MedievalSoldierBuilder.defaultStrength = defaultStrength;
	}

	public Soldier createSoldier()
	{
		Soldier newSoldier = new Soldier(name, weapon, armor, troop, defaultStrength, "Medieval");
		newSoldier.setHealthState(new LittleInjured());
		return newSoldier;
	}
}
