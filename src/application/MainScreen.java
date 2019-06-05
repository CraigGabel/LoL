
package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainScreen
{
	TableView<Champion> table;
	LinkedList<CheckBox> classFilters;
	LinkedList<CheckBox> roleFilters;

	MainScreen(Stage mainStage)
	{
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

				for (ChampionProperties.ChampionSubclass csc: ChampionProperties.ChampionSubclass.values())
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

				for (ChampionProperties.ChampionRole role: ChampionProperties.ChampionRole.values())
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
//				MenuItem mItem = (MenuItem) event.getSource();

				ArrayList<Champion> chList = new ArrayList<>();

//				ChampionList tempList = new ChampionList();

				for (CheckBox checkBox : classFilters)
				{
//					for (Champion champion : ChampionList.championList)
//					{
//						if (champion.championRole.getFirst().equals(mItem.getText()))
//						{
//							chList.add(champion);
//						}
//					}
				}

				table.setItems(FXCollections.observableArrayList(chList));
			}
		};
	}

	private BorderPane buildScreen()
	{
		// top pane - menubar
		VBox topPane = new VBox();
		topPane.setPadding(new Insets(0, 0, 0, 0));
		topPane.getChildren().addAll(mainMenu());

		// center pane - champion table
		VBox centerPane = new VBox();
		centerPane.setPadding(new Insets(0, 0, 0, 0));

		ArrayList<Champion> myList = new ArrayList<Champion>(ChampionList.championList);
		centerPane.getChildren().addAll(championTable(FXCollections.observableArrayList(myList)));

		// left pane - filters
		GridPane leftPane = championFilters();

		// main layout
		BorderPane borderPane = new BorderPane();

		borderPane.setTop(topPane);
		borderPane.setCenter(centerPane);
		borderPane.setLeft(leftPane);

		return borderPane;
	}

	private GridPane championFilters()
	{
		GridPane gridPane = new GridPane();

		gridPane.setPadding(new Insets(20,20,20,20));
		gridPane.setVgap(5);
		gridPane.setHgap(5);

		EventHandler<ActionEvent> action = filterChampions();

		int rowIndex = 0;

		CheckBox filterCheckBox = new CheckBox();
		classFilters.add(filterCheckBox);
		filterCheckBox.setText("All");
		filterCheckBox.setOnAction(action);
		GridPane.setConstraints(filterCheckBox, 0, rowIndex++);
		GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 7));
		gridPane.getChildren().add(filterCheckBox);

		for (ChampionProperties.ChampionSubclass subclass: ChampionProperties.ChampionSubclass.values())
		{
			filterCheckBox = new CheckBox();
			classFilters.add(filterCheckBox);
			filterCheckBox.setText(subclass.name());
			filterCheckBox.setOnAction(action);
			GridPane.setConstraints(filterCheckBox, 0, rowIndex++);
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
//		lastNameCol.setSortable(false);

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
