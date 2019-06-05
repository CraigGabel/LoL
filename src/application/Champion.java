package application;

import java.util.LinkedList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Champion
{
	String name;
	LinkedList<String> championClass;
	LinkedList<String> championSubclass;
	LinkedList<String> championRole;

	Champion()
	{
		championClass = new LinkedList<>();
		championSubclass = new LinkedList<>();
		championRole = new LinkedList<>();
	}

	Champion(String n, LinkedList<String> cc, LinkedList<String> csc, LinkedList<String> cr)
	{
		name = n;
		championClass = cc;
		championSubclass = csc;
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
		return new SimpleStringProperty((String) championRole.getFirst());
	}
}
