package wzorce;

public class Start
{

	public static void main(String[] args)
	{
		SoldierEngine soldierEngine = new SoldierEngine();
		SoldierGUI soldierGUI = new SoldierGUI(soldierEngine);

		soldierGUI.start();
	}

}
