package wzorce;

public class Dead extends HealthState
{

	@Override
	public void healthBetter(Soldier soldier)
	{
		soldier.setHealthState(new HeavyInjured());
		System.out.println("Soldier was ressurected. He is heavy injured now");
	}

	@Override
	public void healthWorse(Soldier soldier)
	{
		System.out.println("Soldier cannot be more dead");	
	}

	@Override
	public void run()
	{
		System.out.println("The dead soldier cannot run");
	}

	@Override
	protected String runDescription()
	{
		return "The dead soldier cannot run";
	}

}
