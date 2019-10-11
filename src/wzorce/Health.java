package wzorce;

public class Health extends HealthState
{

	@Override
	public void healthBetter(Soldier soldier)
	{
		System.out.println("Soldier cannot be more health");
		
	}

	@Override
	public void healthWorse(Soldier soldier)
	{
		soldier.setHealthState(new LittleInjured());

		System.out.println("Soldier is little injured now");
		
	}

	@Override
	public void run()
	{
		System.out.println("Soldier is health. He is running fast now.");
	}

	@Override
	protected String runDescription()
	{
		return "Soldier is health. He is running fast now.";
	}

}
