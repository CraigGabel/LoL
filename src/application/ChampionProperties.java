package application;

import java.util.HashMap;
import java.util.LinkedList;

public class ChampionProperties
{	
	public enum ChampionRole
	{
		Top,
		Jungle,
		Mid,
		Bottom,
		Support
	}
	
	public enum ChampionTier
	{
		Staple,
		Solid,
		Kinda,
		Testing
	}

	public enum ChampionClass
	{
		Tank, Fighter, Slayer, Mage, Controller, Marksmen, Unique
	}

	public enum ChampionSubclass
	{
		// tanks
		Vanguard, Warden,

		// fighters
		Juggernaut, Diver,

		// slayers
		Assassin, Skirmisher,

		// mages
		BurstMage, BattleMage, Artillery,

		// controllers
		Enchanter, Catcher,

		// marksmen
		Marksmen,

		// unique playstyle
		Specialist
	}

	ChampionClass championClass;
	ChampionSubclass subclass;
	ChampionRole role;

	public static HashMap<ChampionClass, LinkedList<ChampionSubclass>> classMap;

	public HashMap<ChampionClass, LinkedList<ChampionSubclass>> makeHashMap()
	{
		HashMap<ChampionClass, LinkedList<ChampionSubclass>> tempMap = new HashMap<>();

		LinkedList<ChampionSubclass> championSubclasses;

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Vanguard);
		championSubclasses.add(ChampionSubclass.Warden);
		tempMap.put(ChampionClass.Tank, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Juggernaut);
		championSubclasses.add(ChampionSubclass.Diver);
		tempMap.put(ChampionClass.Fighter, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Assassin);
		championSubclasses.add(ChampionSubclass.Skirmisher);
		tempMap.put(ChampionClass.Slayer, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.BurstMage);
		championSubclasses.add(ChampionSubclass.BattleMage);
		championSubclasses.add(ChampionSubclass.Artillery);
		tempMap.put(ChampionClass.Mage, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Enchanter);
		championSubclasses.add(ChampionSubclass.Catcher);
		tempMap.put(ChampionClass.Controller, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Marksmen);
		tempMap.put(ChampionClass.Marksmen, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Specialist);
		tempMap.put(ChampionClass.Unique, championSubclasses);

		return tempMap;
	}

	ChampionProperties()
	{
		classMap = makeHashMap();
	}
}
