
package application;

import java.util.LinkedList;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ChampionList
{
	public LinkedList<Champion> championList;

	ChampionList(boolean t) throws FileNotFoundException, IOException, ParseException
	{
		if (t == true)
		{
			championList = readJSON();
		}
		else
		{
			championList = new LinkedList<>();
		}
	}

	public boolean removeChampion(String name)
	{
		boolean response = false;

		for (Champion champion : championList)
		{
			if (champion.name.equalsIgnoreCase(name))
			{
				championList.remove(champion);
				response = true;
				break;
			}
		}

		return response;
	}

	public boolean addChampion(String name) throws FileNotFoundException, IOException, ParseException
	{
		boolean response = false;

		for (Champion champion : championList)
		{
			if (champion.name.equalsIgnoreCase(name))
			{
				return response;
			}
		}

		LinkedList<Champion> temp = readJSON();

		for (Champion champion : temp)
		{
			if (champion.name.equalsIgnoreCase(name))
			{
				championList.add(champion);
				response = true;
				break;
			}
		}

		return response;
	}

	public LinkedList<Champion> readJSON() throws FileNotFoundException, IOException, ParseException
	{
		LinkedList<Champion> tempList = new LinkedList<>();

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

				champion.championClass.add((String) classArray2.get(0));
				champion.championSubclass.add((String) classArray2.get(1));

				LinkedList<String> subclasses = new LinkedList<>();

				if (champion.classes.containsKey((String) classArray2.get(0)))
				{
					for (String subclass : champion.classes.get((String) classArray2.get(0)))
					{
						subclasses.add(subclass);
					}
					subclasses.add((String) classArray2.get(1));
				}
				else
				{
					subclasses.add((String) classArray2.get(1));
				}

				champion.classes.put((String) classArray2.get(0), subclasses);
			}

			JSONArray roleArray = (JSONArray) temp.get("roles");

			for (int ii = 0; ii < roleArray.size(); ii++)
			{
				champion.championRole.add((String) roleArray.get(ii));
			}

			tempList.add(champion);
		}

		return tempList;
	}

	void writeJSON() throws IOException
	{
//		JSONObject obj = new JSONObject();
//		JSONArray championList = new JSONArray();
//
//		JSONObject champion = new JSONObject();
//		champion.put("name", "Aatrox");
//
//		JSONArray classes = new JSONArray();
//		JSONArray class1 = new JSONArray();
//		class1.add("Fighter");
//		class1.add("Diver");
//		classes.add(class1);
//		JSONArray class2 = new JSONArray();
//		class2.add("Fighter");
//		class2.add("Juggernaut");
//		classes.add(class2);
//
//		champion.put("classes", classes);
//
//		JSONArray roles = new JSONArray();
//		roles.add("Top");
//		roles.add("Jungle");
//		champion.put("roles", roles);
//
//		championList.add(champion);
//
//		obj.put("ChampionList", championList);



















		JSONObject obj = new JSONObject();
		JSONArray list = new JSONArray();

		for (Champion champion : championList)
		{
			JSONObject champ = new JSONObject();
			champ.put("name", champion.name);

			JSONArray classes = new JSONArray();

			for (Map.Entry<String, LinkedList<String>> entry : champion.classes.entrySet())
			{
				for (String string : entry.getValue())
				{
					JSONArray class1 = new JSONArray();
					class1.add(entry.getKey());
					class1.add(string);
					classes.add(class1);
				}
			}

			champ.put("classes", classes);

			JSONArray roles = new JSONArray();
			for (String string : champion.championRole)
			{
				roles.add(string);
			}

			champ.put("roles", roles);

			list.add(champ);
		}

		obj.put("ChampionList", list);

		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter("src/application/test.json"))
		{
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}
	}
}
