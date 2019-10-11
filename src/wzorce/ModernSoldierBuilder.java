package wzorce;

public class ModernSoldierBuilder extends AbstractSoldierBuilder
{

	private String name;
	private Weapon weapon;
	private Armor armor;
	private String troop;
	
	private static int defaultStrength = 80;

	public ModernSoldierBuilder setName(String name)
	{
		this.name = name;
		return this;
	}

	public ModernSoldierBuilder setWeapon(Weapon weapon)
	{
		this.weapon = weapon;
		return this;
	}

	public ModernSoldierBuilder setArmor(Armor armor)
	{
		this.armor = armor;
		return this;
	}

	public ModernSoldierBuilder setTroop(String troop)
	{
		this.troop = troop;
		return this;
	}

	public Soldier createSoldier()
	{
		Soldier newSoldier = new Soldier(name, weapon, armor, troop, defaultStrength, "Modern");
		newSoldier.setHealthState(new Health());
		return newSoldier;
	}

}
