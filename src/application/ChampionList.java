
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
	String defaultList = "src/application/ChampionList2.json";
	String listFile;
	public LinkedList<Champion> championList;

	ChampionList(boolean t, String customFile) throws FileNotFoundException, IOException, ParseException
	{
		listFile = customFile;
		
		if (t == true)
		{
			championList = readJSON(listFile);
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

		LinkedList<Champion> temp = readJSON(defaultList);

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

	public LinkedList<Champion> readJSON(String file) throws FileNotFoundException, IOException, ParseException
	{
		LinkedList<Champion> tempList = new LinkedList<>();

		// parsing file "JSONExample.json"
		Object obj = new JSONParser().parse(new FileReader(file));

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

//			JSONArray roleArray = (JSONArray) temp.get("roles");
//
//			for (int ii = 0; ii < roleArray.size(); ii++)
//			{
//				champion.championRole.add((String) roleArray.get(ii));
//			}
			
			champion.championRole = (String) temp.get("roles");

			tempList.add(champion);
		}

		return tempList;
	}

	void writeJSON() throws IOException
	{
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

//			JSONArray roles = new JSONArray();
//			for (String string : champion.championRole)
//			{
//				roles.add(string);
//			}
//
//			champ.put("roles", roles);
			
			champ.put("roles", champion.championRole);

			list.add(champ);
		}

		obj.put("ChampionList", list);

		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter(listFile))
		{
			file.write(obj.toJSONString());
//			System.out.println("Successfully Copied JSON Object to File...");
//			System.out.println("\nJSON Object: " + obj);
		}
	}
}
