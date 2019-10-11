package wzorce;

public abstract class HealthState
{
	public abstract void healthBetter(Soldier soldier);
	
	public abstract void healthWorse(Soldier soldier);	
	
	public abstract void run();
	
	@Override
	public String toString()
	{
		return "The soldier health state is: " + this.getClass().getSimpleName();
	}

	protected abstract String runDescription();
}
