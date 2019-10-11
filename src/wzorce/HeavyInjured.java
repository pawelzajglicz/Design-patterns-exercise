package wzorce;

public class HeavyInjured extends HealthState
{

	@Override
	public void healthBetter(Soldier soldier)
	{
		soldier.setHealthState(new LittleInjured());
		System.out.println("Soldier is little injured now");
	}

	@Override
	public void healthWorse(Soldier soldier)
	{
		soldier.setHealthState(new Dead());
		System.out.println("Soldier is dead now");
		
	}

	@Override
	public void run()
	{
		System.out.println("Soldier is heavy injured. He can only slowly walk.");
	}

	@Override
	protected String runDescription()
	{
		return "Soldier is heavy injured. He can only slowly walk";
	}

}
