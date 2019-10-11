package wzorce;

public class LittleInjured extends HealthState
{

	@Override
	public void healthBetter(Soldier soldier)
	{
		soldier.setHealthState(new Health());
		System.out.println("Soldier is health now");
	}

	@Override
	public void healthWorse(Soldier soldier)
	{
		soldier.setHealthState(new HeavyInjured());
		System.out.println("Soldier is heavy injured now");
		
	}

	@Override
	public void run()
	{
		System.out.println("Soldier is little injured. He is running slow now.");
	}

	@Override
	protected String runDescription()
	{
		return "Soldier is little injured. He is running slow now.";
	}

}
