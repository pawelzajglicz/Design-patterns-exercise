package wzorce;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SoldierGUI extends JFrame
{
	Map<String, Soldier> soldiersMap = new HashMap<>();
	JPanel listPanel;
	JLabel actionsDescription;
//	JScrollPane soldiersActionsPanel;
	JPanel soldiersActionsPanel;
	
	CaretakerGUIFields caretaker = new CaretakerGUIFields();
	int mementoIndex;
	
	JTextField soldierInputName = new JTextField();
	JComboBox soldierInputWeapon = new JComboBox(EquipmentFactory.giveWeaponNamesList());
	JComboBox soldierInputArmor = new JComboBox(EquipmentFactory.giveArmoryNamesList());
	JTextField soldierInputTroop = new JTextField();
	JLabel mementoIndexLabel = new JLabel("Current memento index: " + mementoIndex);
	
	public SoldierGUI(SoldierEngine soldierEngine)
	{
		// TODO Auto-generated constructor stub
	}

	public void start()
	{
		setTitle("Soldiers");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));
		
		JPanel constructPanel = new JPanel();
		constructPanel.setLayout(new GridLayout(6, 2));
		
		String[] fieldsNames = {"name", "weapon", "armor", "troop"};
		
		JButton saveState = new JButton("Save GUI State");
		saveState.addActionListener(e -> 
		{
			MementoGUIFields memento = save();
			caretaker.addMemento(memento);
		});
		constructPanel.add(saveState);
		
		JPanel undoRedo = new JPanel();
		undoRedo.setLayout(new GridLayout(3, 1));
		
		JButton undoButton = new JButton("Load previous saved state");
		undoButton.addActionListener(e -> 
		{
			if (mementoIndex > 0)
			{
				MementoGUIFields memento = caretaker.getMemento(--mementoIndex);
				restore(memento);
				mementoIndexLabel.setText("Current memento index: " + mementoIndex);
			}
		});
		undoRedo.add(undoButton);
		
		JButton redoButton = new JButton("Load next saved state");	
		redoButton.addActionListener(e -> 
		{
			if (mementoIndex < caretaker.mementosAmount() - 1)
			{
				MementoGUIFields memento = caretaker.getMemento(++mementoIndex);
				restore(memento);
				mementoIndexLabel.setText("Current memento index: " + mementoIndex);
			}
		});
		undoRedo.add(redoButton);
		mementoIndexLabel.setHorizontalAlignment(JLabel.CENTER);
		undoRedo.add(mementoIndexLabel);
		
		constructPanel.add(undoRedo);
		
		JLabel soldierLabelName = new JLabel("Soldier's name");
		constructPanel.add(soldierLabelName);
		soldierInputName = new JTextField();
		constructPanel.add(soldierInputName);
		
		JLabel soldierLabelWeapon= new JLabel("Soldier's weapon");
		constructPanel.add(soldierLabelWeapon);
		soldierInputWeapon = new JComboBox(EquipmentFactory.giveWeaponNamesList());
		constructPanel.add(soldierInputWeapon);	
		
		JLabel soldierLabelArmor= new JLabel("Soldier's armor");
		constructPanel.add(soldierLabelArmor);
		soldierInputArmor = new JComboBox(EquipmentFactory.giveArmoryNamesList());
		constructPanel.add(soldierInputArmor);
		
		JLabel soldierLabelTroop = new JLabel("Soldier's troop");
		constructPanel.add(soldierLabelTroop);
		soldierInputTroop = new JTextField();
		constructPanel.add(soldierInputTroop);

		JButton createMedevialSoldier = new JButton("Create a medieval soldier");
		createMedevialSoldier.addActionListener( e -> 
		{
			try 
			{
				Soldier soldier = new MedievalSoldierBuilder()
					.setName(soldierInputName.getText())
					.setWeapon(EquipmentFactory.giveWeaponByName((String)soldierInputWeapon.getSelectedItem()))
					.setArmor(EquipmentFactory.giveArmorByName((String)soldierInputArmor.getSelectedItem()))
					.setTroop(soldierInputTroop.getText())
					.createSoldier();
				
				soldiersMap.put(soldier.getName(), soldier);
				
				JLabel soldierDescription = new JLabel("<html>" + soldier.toString() + "</html>");
				listPanel.add(soldierDescription);
				
				JButton healthBetter = new JButton("Cure");
				healthBetter.addActionListener(event ->
				{
					soldier.heal();
					soldierDescription.setText("<html>" + soldier.toString() + "</html>");

					setVisible(false);
					setVisible(true);
				});
				listPanel.add(healthBetter);
				
				JButton healthWorse = new JButton("Hurt");
				healthWorse.addActionListener(event ->
				{
					soldier.hurt();
					soldierDescription.setText("<html>" + soldier.toString() + "</html>");

					setVisible(false);
					setVisible(true);
				});
				listPanel.add(healthWorse);
				
				JButton soldierRun = new JButton("Run");
				soldierRun.addActionListener(event ->
				{
					//soldier.run();
					//soldierDescription.setText("<html>" + soldier.toString() + "</html>");
					soldiersActionsPanel.add(new JLabel(soldier.runDescription()));

					setVisible(false);
					setVisible(true);
				});
				listPanel.add(soldierRun);
				
				setVisible(false);
				setVisible(true);
						
			} catch (Exception exc)
			{
				System.out.println(exc.getMessage());
				JOptionPane.showMessageDialog(this, exc.getMessage());
			}
		});
		constructPanel.add(createMedevialSoldier);
		
		JButton createModernSoldier = new JButton("Create a modern soldier");
		createModernSoldier.addActionListener( e -> 
		{
			try 
			{
				Soldier soldier = new ModernSoldierBuilder()
					.setName(soldierInputName.getText())
					.setWeapon(EquipmentFactory.giveWeaponByName((String)soldierInputWeapon.getSelectedItem()))
					.setArmor(EquipmentFactory.giveArmorByName((String)soldierInputArmor.getSelectedItem()))
					.setTroop(soldierInputTroop.getText())
					.createSoldier();
				
				soldiersMap.put(soldier.getName(), soldier);
				
				JLabel soldierDescription = new JLabel("<html>" + soldier.toString() + "</html>");
				listPanel.add(soldierDescription);
				
				JButton healthBetter = new JButton("Cure");
				healthBetter.addActionListener(event ->
				{
					soldier.heal();
					soldierDescription.setText("<html>" + soldier.toString() + "</html>");

					setVisible(false);
					setVisible(true);
				});
				listPanel.add(healthBetter);
				
				JButton healthWorse = new JButton("Hurt");
				healthWorse.addActionListener(event ->
				{
					soldier.hurt();
					soldierDescription.setText("<html>" + soldier.toString() + "</html>");

					setVisible(false);
					setVisible(true);
				});
				listPanel.add(healthWorse);
				
				JButton soldierRun = new JButton("Run");
				soldierRun.addActionListener(event ->
				{
					//soldier.run();
					//soldierDescription.setText("<html>" + soldier.toString() + "</html>");
					System.out.println("run" + soldier.runDescription());
					soldiersActionsPanel.add(new JLabel(soldier.runDescription()));

					setVisible(false);
					setVisible(true);
				});
				listPanel.add(soldierRun);
				
				setVisible(false);
				setVisible(true);
						
			} catch (Exception exc)
			{
				System.out.println(exc.getMessage());
				JOptionPane.showMessageDialog(this, exc.getMessage());
			}
		});
		constructPanel.add(createModernSoldier);
		
		mainPanel.add(constructPanel);
		
		
		JPanel solderViewPanel = new JPanel();
		solderViewPanel.setLayout(new GridLayout(2, 1));
		
		//JPanel soldiersListPanel = new JPanel();
		listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(0, 4));
		solderViewPanel.add(listPanel);
		
		//soldiersActionsPanel = new JScrollPane();
		soldiersActionsPanel = new JPanel();
		soldiersActionsPanel.setLayout(new GridLayout(0, 1));
		//JLabel soldiersActionsLabel = new JLabel();
		//actionsDescription = new JLabel();
		//soldiersActionsPanel.add(actionsDescription);
		solderViewPanel.add(soldiersActionsPanel);
		
		mainPanel.add(solderViewPanel);
		
		setContentPane(mainPanel);
		setPreferredSize(new Dimension(1300, 850));
		setLocation(300, 50);
		pack();
		setVisible(true);
	}

	
	private void restore(MementoGUIFields memento)
	{
		soldierInputName.setText(memento.getSoldiersName());
		soldierInputWeapon.setSelectedIndex(memento.getSoldiersWeapon());
		soldierInputArmor.setSelectedIndex(memento.getSoldiersArmor());
		soldierInputTroop.setText(memento.getSoldiersTroop());
	}

	public MementoGUIFields save()
	{
		return new MementoGUIFields(soldierInputName.getText(), soldierInputWeapon.getSelectedIndex(), soldierInputArmor.getSelectedIndex(), soldierInputTroop.getText());
	}
}
