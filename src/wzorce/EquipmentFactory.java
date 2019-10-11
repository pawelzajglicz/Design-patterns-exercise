package wzorce;

import org.w3c.dom.ranges.RangeException;

public class EquipmentFactory
{

	static Pistol givePistol()
	{
		return new Pistol();
	}
	
	static Ak47 giveAk47()
	{
		return new Ak47();
	}
	
	static Helmet giveHelmet()
	{
		return new Helmet();
	}
	
	static Sword giveSword()
	{
		return new Sword();
	}
	
	static String[] giveWeaponNamesList()
	{
		return new String[] {"Ak47", "Pistol", "Sword"};
	}
	
	static String[] giveArmoryNamesList()
	{
		return new String[] {"Helmet", "Chainmail"};
	}
	
	static Weapon giveWeaponByName(String name)
	{
		Weapon weapon;
		if (name.equals("Ak47"))
		{
			weapon = new Ak47();
		} 
		else if (name.equals("Pistol"))
		{
			weapon = new Pistol();
		}
		else if (name.equals("Sword"))
		{
			weapon = new Sword();
		}
		else
		{
			throw new IllegalArgumentException("Cannot create a weapon of that name!");
		}
		
		return weapon;
	}
	
	static Armor giveArmorByName(String name)
	{
		Armor armor;
		
		if (name.equals("Helmet"))
		{
			armor = new Helmet();
		} 
		else if (name.equals("Chainmail"))
		{
			armor = new Chainmail();
		} 
		else
		{
			throw new IllegalArgumentException("Cannot create an armor of that name!");
		}
		
		return armor;
	}
}
