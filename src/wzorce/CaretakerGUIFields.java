package wzorce;

import java.util.ArrayList;
import java.util.List;

public class CaretakerGUIFields
{

	private List<MementoGUIFields> mementos = new ArrayList<>();
	
	public int mementosAmount()
	{
		return mementos.size();
	}
	
	public void addMemento(MementoGUIFields memento)
	{
		mementos.add(memento);
	}
	
	public MementoGUIFields getMemento(int index)
	{
		return mementos.get(index);
	}
}
