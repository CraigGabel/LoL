
package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.ParseException;
import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainScreen
{
	TableView<Champion>		table;
	LinkedList<CheckBox>	classFilters;
	LinkedList<CheckBox>	roleFilters;

	MainScreen(Stage mainStage)
	{
		table = new TableView<Champion>();
		classFilters = new LinkedList<>();
		roleFilters = new LinkedList<>();

		mainStage.setScene(new Scene(buildScreen()));
		mainStage.show();
	}

	private EventHandler<ActionEvent> showChampionList_byClass()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

				for (ChampionProperties.ChampionSubclass csc : ChampionProperties.ChampionSubclass.values())
				{
					if (csc.name().equals(mItem.getText()))
					{
						ArrayList<Champion> chList = new ArrayList<>();
						for (Champion champion : ChampionList.championList)
						{
							if (champion.championSubclass.getFirst().equals(mItem.getText()))
							{
								chList.add(champion);
							}
						}

						table.setItems(FXCollections.observableArrayList(chList));
					}
				}
			}
		};
	}

	private EventHandler<ActionEvent> showChampionList_byRole()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

				for (ChampionProperties.ChampionRole role : ChampionProperties.ChampionRole.values())
				{
					if (role.name().equals(mItem.getText()))
					{
						ArrayList<Champion> chList = new ArrayList<>();
						for (Champion champion : ChampionList.championList)
						{
							if (champion.championRole.getFirst().equals(mItem.getText()))
							{
								chList.add(champion);
							}
						}

						table.setItems(FXCollections.observableArrayList(chList));
					}
				}
			}
		};
	}

	private EventHandler<ActionEvent> filterChampions()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				CheckBox checkBox = (CheckBox) event.getSource();

				ArrayList<Champion> chList = new ArrayList<>();
				ArrayList<Champion> chList2 = new ArrayList<>();
				ArrayList<Champion> chListTot = new ArrayList<>();

				try
				{
					ChampionList tempList = new ChampionList();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				for (CheckBox chb : classFilters)
				{
					if (checkBox.equals(chb))
					{
						if (chb.getText().equalsIgnoreCase("All"))
						{
							if (checkBox.isSelected() == true)
							{
								for (CheckBox chb2 : classFilters)
								{
									if (chb2.getText().equalsIgnoreCase("All") == false)
										chb2.setSelected(false);
								}
							}
							else
							{
								checkBox.setSelected(true);
							}
						}
						else
						{
							classFilters.get(0).setSelected(false);
						}
					}
				}
				
				for (CheckBox chb : roleFilters)
				{
					if (checkBox.equals(chb))
					{
						if (chb.getText().equalsIgnoreCase("All"))
						{
							if (checkBox.isSelected() == true)
							{
								for (CheckBox chb2 : roleFilters)
								{
									if (chb2.getText().equalsIgnoreCase("All") == false)
										chb2.setSelected(false);
								}
							}
							else
							{
								checkBox.setSelected(true);
							}
						}
						else
						{
							roleFilters.get(0).setSelected(false);
						}
					}
				}

				if (classFilters.get(0).isSelected() == true)
				{
					// start with a full list
					for (Champion champion : ChampionList.championList)
					{
						if (true)
						{
							chList.add(champion);
						}
					}
				}
				else
				{
					for (Champion champion : ChampionList.championList)
					{
						for (CheckBox chb : classFilters)
						{
							if (chb.isSelected() == true)
							{
								for (String scs : champion.championSubclass)
								{
									if (scs.equalsIgnoreCase(chb.getText()))
									{
										if (chList.contains(champion) == false)
										{
											chList.add(champion);
										}
									}
								}
							}
						}
					}
				}
				
				if (roleFilters.get(0).isSelected() == true)
				{
					// start with a full list
					for (Champion champion : ChampionList.championList)
					{
						if (true)
						{
							chList2.add(champion);
						}
					}
				}
				else
				{
					for (Champion champion : ChampionList.championList)
					{
						for (CheckBox chb : roleFilters)
						{
							if (chb.isSelected() == true)
							{
								for (String scs : champion.championRole)
								{
									if (scs.equalsIgnoreCase(chb.getText()))
									{
										if (chList2.contains(champion) == false)
										{
											chList2.add(champion);
										}
									}
								}
							}
						}
					}
				}
				
				for (Champion champion : chList)
				{
					if (chList2.contains(champion))
					{
						chListTot.add(champion);
					}
				}

				table.setItems(FXCollections.observableArrayList(chListTot));
			}
		};
	}

	private HBox buildScreen()
	{
		// top pane - menubar
		VBox menuPane = new VBox();
		menuPane.setPadding(new Insets(0, 0, 0, 0));
		menuPane.getChildren().addAll(mainMenu());

		// center pane - champion table
		VBox champTable = new VBox();
		champTable.setPadding(new Insets(0, 0, 0, 0));
		VBox champTable2 = new VBox();
		champTable2.setPadding(new Insets(0, 0, 0, 0));

		ArrayList<Champion> myList = new ArrayList<Champion>(ChampionList.championList);
		champTable.getChildren().addAll(championTable(FXCollections.observableArrayList(myList)));
		champTable2.getChildren().addAll(championTable(FXCollections.observableArrayList(myList)));

		// left pane - filters
		// GridPane leftPane = new GridPane();
		GridPane champFilters = championFilters();
		GridPane champFilters2 = championFilters();

//		// main layout
//		BorderPane borderPane = new BorderPane();
//
//		borderPane.setTop(topPane);
//		borderPane.setCenter(centerPane);
//		borderPane.setLeft(leftPane);
//
//		return borderPane;
		
		HBox mainLayout = new HBox();
		
		mainLayout.getChildren().addAll(champFilters, champTable, champTable2, champFilters2);
		
		return mainLayout;
	}

	private GridPane championFilters()
	{
		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setVgap(5);
		gridPane.setHgap(5);

		EventHandler<ActionEvent> action = filterChampions();

		int rowIndex = 0;

		CheckBox filterCheckBox = new CheckBox();
		classFilters.add(filterCheckBox);
		filterCheckBox.setSelected(true);
		filterCheckBox.setText("All");
		filterCheckBox.setOnAction(action);
		GridPane.setConstraints(filterCheckBox, 0, rowIndex++);
		GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 7));
		gridPane.getChildren().add(filterCheckBox);

		for (ChampionProperties.ChampionSubclass subclass : ChampionProperties.ChampionSubclass.values())
		{
			filterCheckBox = new CheckBox();
			classFilters.add(filterCheckBox);
			filterCheckBox.setText(subclass.name());
			filterCheckBox.setOnAction(action);
			GridPane.setConstraints(filterCheckBox, 0, rowIndex++);
			GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 7));
			gridPane.getChildren().add(filterCheckBox);
		}
		
		rowIndex = 0;

		filterCheckBox = new CheckBox();
		roleFilters.add(filterCheckBox);
		filterCheckBox.setSelected(true);
		filterCheckBox.setText("All");
		filterCheckBox.setOnAction(action);
		GridPane.setConstraints(filterCheckBox, 1, rowIndex++);
		GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 7));
		gridPane.getChildren().add(filterCheckBox);

		for (ChampionProperties.ChampionRole role : ChampionProperties.ChampionRole.values())
		{
			filterCheckBox = new CheckBox();
			roleFilters.add(filterCheckBox);
			filterCheckBox.setText(role.name());
			filterCheckBox.setOnAction(action);
			GridPane.setConstraints(filterCheckBox, 1, rowIndex++);
			GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 7));
			gridPane.getChildren().add(filterCheckBox);
		}

		return gridPane;
	}

	private VBox championTable(ObservableList<Champion> chList)
	{
		table = new TableView<>();

		TableColumn<Champion, String> chName = new TableColumn<Champion, String>("Champion");
		TableColumn<Champion, String> chClass = new TableColumn<Champion, String>("Class");
		TableColumn<Champion, String> chSubclass = new TableColumn<Champion, String>("Subclass");
		TableColumn<Champion, String> chRole = new TableColumn<Champion, String>("Role");

		// Defines how to fill data for each cell.
		// Get value from property of UserAccount. .
		chName.setCellValueFactory(new PropertyValueFactory<>("name"));
		chClass.setCellValueFactory(new PropertyValueFactory<>("championClass"));
		chSubclass.setCellValueFactory(new PropertyValueFactory<>("championSubclass"));
		chRole.setCellValueFactory(new PropertyValueFactory<>("championRole"));

		// Set Sort type for userName column
		chName.setSortType(TableColumn.SortType.DESCENDING);
		// lastNameCol.setSortable(false);

		// Display row data
		table.setItems(chList);

		table.getColumns().addAll(chName, chClass, chSubclass, chRole);

		VBox vBox = new VBox(table);

		return vBox;
	}

	private MenuBar mainMenu()
	{
		Menu menu1 = new Menu("Classes/Subclasses");

		EventHandler<ActionEvent> action1 = showChampionList_byClass();

		for (Map.Entry<ChampionProperties.ChampionClass, LinkedList<ChampionProperties.ChampionSubclass>> entry : ChampionProperties.classMap.entrySet())
		{
			ChampionProperties.ChampionClass key = entry.getKey();
			LinkedList<ChampionProperties.ChampionSubclass> value = entry.getValue();

			Menu subMenu = new Menu(key.name());
			for (ChampionProperties.ChampionSubclass subclass : value)
			{
				MenuItem menuItem = new MenuItem(subclass.name());
				menuItem.setOnAction(action1);
				subMenu.getItems().add(menuItem);
			}
			menu1.getItems().add(subMenu);
		}

		Menu menu2 = new Menu("Roles");

		EventHandler<ActionEvent> action2 = showChampionList_byRole();

		for (ChampionProperties.ChampionRole role : ChampionProperties.ChampionRole.values())
		{
			MenuItem menuItem = new MenuItem(role.name());
			menuItem.setOnAction(action2);
			menu2.getItems().add(menuItem);
		}

		MenuBar menuBar = new MenuBar();

		// menuBar.getMenus().addAll(menu1, menu2, menu3, menu4, menu5);
		menuBar.getMenus().addAll(menu1, menu2);

		return menuBar;
	}
}
