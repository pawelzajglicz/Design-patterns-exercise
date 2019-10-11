package wzorce;

public class MementoGUIFields
{
	String soldiersName;
	int soldiersWeapon;
	int soldiersArmor;
	String soldiersTroop;
	
	
	public MementoGUIFields(String soldiersName, int soldiersWeapon, int soldiersArmor, String soldiersTroop)
	{
		super();
		this.soldiersName = soldiersName;
		this.soldiersWeapon = soldiersWeapon;
		this.soldiersArmor = soldiersArmor;
		this.soldiersTroop = soldiersTroop;
	}


	public String getSoldiersName()
	{
		return soldiersName;
	}


	public int getSoldiersWeapon()
	{
		return soldiersWeapon;
	}


	public int getSoldiersArmor()
	{
		return soldiersArmor;
	}


	public String getSoldiersTroop()
	{
		return soldiersTroop;
	}
	
	
}
