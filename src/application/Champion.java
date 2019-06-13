package application;

import java.util.HashMap;
import java.util.LinkedList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Champion
{
	String name;
	LinkedList<String> championClass;
	LinkedList<String> championSubclass;
	HashMap<String, LinkedList<String>> classes;
//	LinkedList<String> championRole;
	String championRole;

	Champion()
	{
		championClass = new LinkedList<>();
		championSubclass = new LinkedList<>();
		classes = new HashMap<>();
		championRole = new String();
	}

	Champion(String n, LinkedList<String> cc, LinkedList<String> csc, String cr)
	{
		name = n;
		championClass = cc;
		championSubclass = csc;
		championRole = cr;
	}

	Champion(String n, HashMap<String, LinkedList<String>> cc, String cr)
	{
		name = n;
		classes = cc;
		championRole = cr;
	}

	public StringProperty nameProperty()
	{
		return new SimpleStringProperty((String) name);
	}

	public StringProperty championClassProperty()
	{
		return new SimpleStringProperty((String) championClass.getFirst());
	}

	public StringProperty championSubclassProperty()
	{
		return new SimpleStringProperty((String) championSubclass.getFirst());
	}

	public StringProperty championRoleProperty()
	{
		return new SimpleStringProperty((String) championRole);
	}
}
