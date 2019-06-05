
package application;

import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ChampionList
{
	public static LinkedList<Champion> championList;

	public void readFromJSON() throws FileNotFoundException, IOException, ParseException
	{
		championList = new LinkedList<>();

		// parsing file "JSONExample.json"
		Object obj = new JSONParser().parse(new FileReader("src/application/ChampionList.json"));

		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;

		// getting champions
		JSONArray chArray = (JSONArray) jo.get("ChampionList");

		for (int i = 0; i < chArray.size(); i++)
		{
			Champion champion = new Champion();

			JSONObject temp = (JSONObject) chArray.get(i);

			champion.name = (String) temp.get("name");

			JSONArray classArray = (JSONArray) temp.get("classes");

			for (int ii = 0; ii < classArray.size(); ii++)
			{
				JSONArray classArray2 = (JSONArray) classArray.get(ii);

				for (int iii = 0; iii < classArray2.size(); iii++)
				{
					champion.championClass.add((String) classArray2.get(0));
					champion.championSubclass.add((String) classArray2.get(1));
				}
			}

			JSONArray roleArray = (JSONArray) temp.get("roles");

			for (int ii = 0; ii < roleArray.size(); ii++)
			{
				champion.championRole.add((String) roleArray.get(ii));
			}

			championList.add(champion);
		}
	}

	ChampionList(boolean t)
	{
		championList = new LinkedList<>();
	}

	ChampionList() throws FileNotFoundException, IOException, ParseException
	{
		readFromJSON();

//		championList = new LinkedList<>();
//
//		String chName;
//		LinkedList<String> chClass;
//		LinkedList<String> chSubclass;
//		LinkedList<String> chRole;
//		Champion champion;
//
//		// tanks
//		// vanguards
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Alister";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Amumu";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Gragas";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Leona";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Malphite";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Maokai";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Nautilus";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Rammus";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Sejuani";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Sion";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		chClass = new LinkedList<>();
//		chSubclass = new LinkedList<>();
//		chRole = new LinkedList<>();
//		chName = "Zac";
//		chClass.add("Tank");
//		chSubclass.add("Vanguard");
//		chRole.add("Support");
//		champion = new Champion(chName, chClass, chSubclass, chRole);
//		championList.add(champion);
//
//		// // wardens
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Braum";
//		// chClass.add(ChampionProperties.ChampionClass.Tank);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Warden);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Galio";
//		// chClass.add(ChampionProperties.ChampionClass.Tank);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Warden);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Nunu";
//		// chClass.add(ChampionProperties.ChampionClass.Tank);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Warden);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Poppy";
//		// chClass.add(ChampionProperties.ChampionClass.Tank);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Warden);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Shen";
//		// chClass.add(ChampionProperties.ChampionClass.Tank);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Warden);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Tahm Kench";
//		// chClass.add(ChampionProperties.ChampionClass.Tank);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Warden);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // fighters
//		// // juggernauts
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Darius";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Dr. Mundo";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Garen";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Illaoi";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Mordekaiser";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Nasus";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Shyvana";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Trundle";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Udyr";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Volibear";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Yorick";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Juggernaut);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // divers
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Aatrox";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Camile";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Diana";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Elise";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Hecarim";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Irelia";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Jarvan IV";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Kled";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Lee Sin";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Olaf";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Pantheon";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Rek'Sai";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Renekton";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Rengar";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Skarner";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Vi";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Warwick";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Wukong";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Xin Zhao";
//		// chClass.add(ChampionProperties.ChampionClass.Fighter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Diver);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // slayers
//		// // assassins
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Akali";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Ekko";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Evelynn";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Fizz";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Kassadin";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Katarina";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Kha'Zix";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Nocturne";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Shaco";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Talon";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Zed";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Assassin);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // skirmishers
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Fiora";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Skirmisher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Jax";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Skirmisher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Master Yi";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Skirmisher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Riven";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Skirmisher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Tryndamere";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Skirmisher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Yasuo";
//		// chClass.add(ChampionProperties.ChampionClass.Slayer);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Skirmisher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // mages
//		// // burst mages
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Ahri";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Annie";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Brand";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "LeBlanc";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Lissandra";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Lux";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Artillery);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Orianna";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Syndra";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Twisted Fate";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Veigar";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BurstMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // battle mages
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Anivia";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Aurelion Sol";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Cassiopia";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Karthus";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Malzahar";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Rumble";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Ryze";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Swain";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Taliyah";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Viktor";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Vladimir";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.BattleMage);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // artillery
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Jayce";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Artillery);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Vel'Koz";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Artillery);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Xerath";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Artillery);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Ziggs";
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Artillery);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // controllers
//		// // enchanters
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Janna";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Enchanter);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Karma";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Enchanter);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Lulu";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Enchanter);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Nami";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Enchanter);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Sona";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Enchanter);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Soraka";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Enchanter);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Taric";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chClass.add(ChampionProperties.ChampionClass.Tank);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Enchanter);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Warden);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // catchers
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Bard";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Catcher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Blitzcrank";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Catcher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Ivern";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Catcher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Morgana";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Catcher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Rakan";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Catcher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Thresh";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Catcher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Zyra";
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Catcher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // marksmen
//		// // marksmen
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Ashe";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Caitlyn";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Corki";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Draven";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Ezreal";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Jhin";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chClass.add(ChampionProperties.ChampionClass.Controller);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Catcher);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Jinx";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Kalista";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Kindred";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Kog'Maw";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Lucian";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Miss Fortune";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Sivir";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Tristana";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Twitch";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Varus";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chClass.add(ChampionProperties.ChampionClass.Mage);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Artillery);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Vayne";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Xayah";
//		// chClass.add(ChampionProperties.ChampionClass.Marksmen);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Marksmen);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// // unique
//		// // unique
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Azir";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Cho'Gath";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Fiddlesticks";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Gangplank";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Graves";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Gnar";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chClass.add(ChampionProperties.ChampionClass.Tank);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Vanguard);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Heimerdinger";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Kayle";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Kennen";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Nidalee";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Quinn";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Singed";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Teemo";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Urgot";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
//		//
//		// chClass = new LinkedList<>();
//		// chSubclass = new LinkedList<>();
//		// chRole = new LinkedList<>();
//		// chName = "Zilean";
//		// chClass.add(ChampionProperties.ChampionClass.Unique);
//		// chSubclass.add(ChampionProperties.ChampionSubclass.Unique);
//		// chRole.add(ChampionProperties.ChampionRole.Support);
//		// champion = new Champion(chName, chClass, chSubclass, chRole);
//		// championList.add(champion);
	}
}
