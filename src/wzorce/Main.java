package wzorce;

public class Main
{

	public static void main(String[] args)
	{
		Soldier soldier1 = new ModernSoldierBuilder()
				.setName("John")
				.setTroop("Army 100")
				.setWeapon(new Pistol())
				.setArmor(new Helmet())
				.createSoldier();
		
		Soldier soldier2;
		
		try 
		{

			soldier2 = new MedievalSoldierBuilder()
					.setName("Rocky")
					.setWeapon(new Ak47())
					.createSoldier();
			
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			
			soldier2 = new MedievalSoldierBuilder()
					.setName("Rocky")
					.setWeapon(new Sword())
					.createSoldier();
		}
		
		System.out.println();
		System.out.println(soldier1);
		System.out.println(soldier2);
		System.out.println();
		
		soldier1.heal();
		soldier1.run();
		soldier1.hurt();
		System.out.println();
		
		soldier1.run();
		soldier1.hurt();
		soldier1.hurt();
		System.out.println();
		
		soldier1.heal();
		soldier1.run();
	}

}
