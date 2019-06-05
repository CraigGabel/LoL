package application;

import java.util.HashMap;
import java.util.LinkedList;

public class ChampionProperties
{
	public static enum ChampionRole
	{
		Top,
		Jungle,
		Mid,
		Bottom,
		Support
	}

	public static enum ChampionClass
	{
		Tank, Fighter, Slayer, Mage, Controller, Marksmen, Unique
	}

	public static enum ChampionSubclass
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

	public static HashMap<ChampionClass, LinkedList<ChampionSubclass>> classMap;

	ChampionProperties()
	{
		classMap = new HashMap<>();

		LinkedList<ChampionSubclass> championSubclasses;

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Vanguard);
		championSubclasses.add(ChampionSubclass.Warden);
		classMap.put(ChampionClass.Tank, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Juggernaut);
		championSubclasses.add(ChampionSubclass.Diver);
		classMap.put(ChampionClass.Fighter, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Assassin);
		championSubclasses.add(ChampionSubclass.Skirmisher);
		classMap.put(ChampionClass.Slayer, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.BurstMage);
		championSubclasses.add(ChampionSubclass.BattleMage);
		championSubclasses.add(ChampionSubclass.Artillery);
		classMap.put(ChampionClass.Mage, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Enchanter);
		championSubclasses.add(ChampionSubclass.Catcher);
		classMap.put(ChampionClass.Controller, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Marksmen);
		classMap.put(ChampionClass.Marksmen, championSubclasses);

		championSubclasses = new LinkedList<>();
		championSubclasses.add(ChampionSubclass.Specialist);
		classMap.put(ChampionClass.Unique, championSubclasses);
	}
}
