
package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;
import application.ChampionProperties.ChampionRole;
import application.ChampionProperties.ChampionSubclass;
import application.ChampionProperties.ChampionTier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ChampTable
{
	TableView<Champion>		table;
	LinkedList<CheckBox>	classFilters;
	LinkedList<CheckBox>	roleFilters;
	LinkedList<CheckBox>	tierFilters;
	ChampionList			championList;
	ChampionProperties		championProperties;
	TextField				addChampTextField;
	Button					addChampButton;
	TextField				removeChampTextField;
	Button					removeChampButton;
	boolean					hideControls;
	boolean					hideExtraTableColumns;

	public ChampTable(String file, boolean hideC, boolean hideColumns) throws FileNotFoundException, IOException, ParseException
	{
		table = new TableView<>();
		classFilters = new LinkedList<>();
		roleFilters = new LinkedList<>();
		tierFilters = new LinkedList<>();
		championList = new ChampionList(true, file);
		championProperties = new ChampionProperties();
		hideControls = hideC;
		hideExtraTableColumns = hideColumns;
	}
	
	public void updateTable()
	{
		ArrayList<Champion> classList = new ArrayList<>();
		ArrayList<Champion> roleList = new ArrayList<>();
		ArrayList<Champion> tierList = new ArrayList<>();
		ArrayList<Champion> chListTot = new ArrayList<>();

		if (classFilters.get(0).isSelected() == true)
		{
			// start with a full list
			for (Champion champion : championList.championList)
			{
				if (true)
				{
					classList.add(champion);
				}
			}
		}
		else
		{
			for (Champion champion : championList.championList)
			{
				for (CheckBox chb : classFilters)
				{
					if (chb.isSelected() == true)
					{
						for (String scs : champion.championSubclass)
						{
							if (scs.equalsIgnoreCase(chb.getText()))
							{
								if (classList.contains(champion) == false)
								{
									classList.add(champion);
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
			for (Champion champion : championList.championList)
			{
				if (true)
				{
					roleList.add(champion);
				}
			}
		}
		else
		{
			for (Champion champion : championList.championList)
			{
				for (CheckBox chb : roleFilters)
				{
					if (chb.isSelected() == true)
					{
						if (champion.championRole.contains(chb.getText()))
						{
							if (roleList.contains(champion) == false)
							{
								roleList.add(champion);
							}
						}
					}
				}
			}
		}
		
		
		if ((hideExtraTableColumns == true) || (tierFilters.get(0).isSelected() == true))
		{
			// start with a full list
			for (Champion champion : championList.championList)
			{
				if (true)
				{
					tierList.add(champion);
				}
			}
		}
		else
		{
			for (Champion champion : championList.championList)
			{
				for (CheckBox chb : tierFilters)
				{
					if (chb.isSelected() == true)
					{
						if (champion.tier.contains(chb.getText()))
						{
							if (tierList.contains(champion) == false)
							{
								tierList.add(champion);
							}
						}
					}
				}
			}
		}

		for (Champion champion : classList)
		{
			if ((roleList.contains(champion)) && (tierList.contains(champion)))
			{
				chListTot.add(champion);
			}
		}

		table.setItems(FXCollections.observableArrayList(chListTot));
	}

	private EventHandler<ActionEvent> filterChampions()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				CheckBox checkBox = (CheckBox) event.getSource();

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
				
				for (CheckBox chb : tierFilters)
				{
					if (checkBox.equals(chb))
					{
						if (chb.getText().equalsIgnoreCase("All"))
						{
							if (checkBox.isSelected() == true)
							{
								for (CheckBox chb2 : tierFilters)
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
							tierFilters.get(0).setSelected(false);
						}
					}
				}

				updateTable();
			}
		};
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
		GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 0));
		gridPane.getChildren().add(filterCheckBox);

		for (ChampionProperties.ChampionSubclass subclass : ChampionSubclass.values())
		{
			filterCheckBox = new CheckBox();
			classFilters.add(filterCheckBox);
			filterCheckBox.setText(subclass.name());
			filterCheckBox.setOnAction(action);
			GridPane.setConstraints(filterCheckBox, 0, rowIndex++);
			GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 0));
			gridPane.getChildren().add(filterCheckBox);
		}

		rowIndex = 0;

		filterCheckBox = new CheckBox();
		roleFilters.add(filterCheckBox);
		filterCheckBox.setSelected(true);
		filterCheckBox.setText("All");
		filterCheckBox.setOnAction(action);
		GridPane.setConstraints(filterCheckBox, 1, rowIndex++);
		GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 0));
		gridPane.getChildren().add(filterCheckBox);

		for (ChampionProperties.ChampionRole role : ChampionRole.values())
		{
			filterCheckBox = new CheckBox();
			roleFilters.add(filterCheckBox);
			filterCheckBox.setText(role.name());
			filterCheckBox.setOnAction(action);
			GridPane.setConstraints(filterCheckBox, 1, rowIndex++);
			GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 0));
			gridPane.getChildren().add(filterCheckBox);
		}
		
		if (hideExtraTableColumns == false)
		{
			rowIndex = 0;
	
			filterCheckBox = new CheckBox();
			tierFilters.add(filterCheckBox);
			filterCheckBox.setSelected(true);
			filterCheckBox.setText("All");
			filterCheckBox.setOnAction(action);
			GridPane.setConstraints(filterCheckBox, 2, rowIndex++);
			GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 0));
			gridPane.getChildren().add(filterCheckBox);
	
			for (ChampionProperties.ChampionTier tier : ChampionTier.values())
			{
				filterCheckBox = new CheckBox();
				tierFilters.add(filterCheckBox);
				filterCheckBox.setText(tier.name());
				filterCheckBox.setOnAction(action);
				GridPane.setConstraints(filterCheckBox, 2, rowIndex++);
				GridPane.setMargin(filterCheckBox, new Insets(0, 0, 0, 0));
				gridPane.getChildren().add(filterCheckBox);
			}
		}

		return gridPane;
	}

	@SuppressWarnings("unchecked")
	private VBox championTable(ObservableList<Champion> chList)
	{
		table = new TableView<>();

		TableColumn<Champion, String> chName = new TableColumn<Champion, String>("Champion");
		TableColumn<Champion, String> chClass = new TableColumn<Champion, String>("Class");
		TableColumn<Champion, String> chSubclass = new TableColumn<Champion, String>("Subclass");
		TableColumn<Champion, String> chRole = new TableColumn<Champion, String>("Role");
		TableColumn<Champion, String> chTier = new TableColumn<Champion, String>("Tier");
		TableColumn<Champion, String> chComments = new TableColumn<Champion, String>("Comments");

		// Defines how to fill data for each cell.
		// Get value from property of UserAccount. .
		chName.setCellValueFactory(new PropertyValueFactory<>("name"));
		chClass.setCellValueFactory(new PropertyValueFactory<>("championClass"));
		chSubclass.setCellValueFactory(new PropertyValueFactory<>("championSubclass"));
//		chRole.setCellValueFactory(new PropertyValueFactory<>("championRole"));

		chRole.setCellValueFactory(new PropertyValueFactory<>("championRole"));
		chRole.setCellFactory(TextFieldTableCell.forTableColumn());
		chRole.setOnEditCommit(new EventHandler<CellEditEvent<Champion, String>>()
		{
			@Override
			public void handle(CellEditEvent<Champion, String> t)
			{
//				((Champion) t.getTableView().getItems().get(t.getTablePosition().getRow())).championRole.set(0, t.getNewValue());
				((Champion) t.getTableView().getItems().get(t.getTablePosition().getRow())).championRole = t.getNewValue();
				try
				{
					championList.writeJSON();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		if (hideExtraTableColumns == false)
		{
			chTier.setCellValueFactory(new PropertyValueFactory<>("tier"));
			chTier.setCellFactory(TextFieldTableCell.forTableColumn());
			chTier.setOnEditCommit(new EventHandler<CellEditEvent<Champion, String>>()
			{
				@Override
				public void handle(CellEditEvent<Champion, String> t)
				{
					((Champion) t.getTableView().getItems().get(t.getTablePosition().getRow())).tier = t.getNewValue();
					try
					{
						championList.writeJSON();
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			chComments.setCellValueFactory(new PropertyValueFactory<>("comments"));
			chComments.setCellFactory(TextFieldTableCell.forTableColumn());
			chComments.setOnEditCommit(new EventHandler<CellEditEvent<Champion, String>>()
			{
				@Override
				public void handle(CellEditEvent<Champion, String> t)
				{
					((Champion) t.getTableView().getItems().get(t.getTablePosition().getRow())).comments = t.getNewValue();
					try
					{
						championList.writeJSON();
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		// Set Sort type for userName column
		chName.setSortType(TableColumn.SortType.DESCENDING);

//		chName.setResizable(true);
//		chClass.setResizable(true);
//		chSubclass.setResizable(true);
//		chRole.setResizable(true);

		// Display row data
		table.setItems(chList);
		
		table.setEditable(true);

		if (hideExtraTableColumns == false)
			table.getColumns().addAll(chName, chClass, chSubclass, chRole, chTier, chComments);
		else 
			table.getColumns().addAll(chName, chClass, chSubclass, chRole);
		
//		System.out.println(table.getPrefWidth());
//		table.setPrefWidth(chName.getWidth() + chClass.getWidth() + chSubclass.getWidth() + chRole.getWidth());
//		table.autosize();
//		System.out.println(table.getPrefWidth());
		
		VBox vBox = new VBox(table);

		return vBox;
	}
	
	private EventHandler<ActionEvent> modifyChampList()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				Button button = (Button) event.getSource();

				if (button.getText().equalsIgnoreCase("add"))
				{
					try
					{
						championList.addChampion(addChampTextField.getText());
						updateTable();
						championList.writeJSON();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					addChampTextField.setText("");
				}
				else if (button.getText().equalsIgnoreCase("remove"))
				{
					try
					{
						championList.removeChampion(removeChampTextField.getText());
						updateTable();
						championList.writeJSON();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					removeChampTextField.setText("");
				}
			}
		};
	}
	
	public GridPane getControls()
	{
		GridPane gridPane = new GridPane();
		
		EventHandler<ActionEvent> action = modifyChampList();
		
		addChampTextField = new TextField();
		addChampButton = new Button("add");
		addChampButton.setOnAction(action);
		
		GridPane.setConstraints(addChampTextField, 0, 0);
		GridPane.setMargin(addChampTextField, new Insets(0, 0, 0, 0));
		gridPane.getChildren().add(addChampTextField);
		
		GridPane.setConstraints(addChampButton, 1, 0);
		GridPane.setMargin(addChampButton, new Insets(0, 0, 0, 0));
		gridPane.getChildren().add(addChampButton);
		
		removeChampTextField = new TextField();
		removeChampButton = new Button("remove");
		removeChampButton.setOnAction(action);
		
		GridPane.setConstraints(removeChampTextField, 0, 1);
		GridPane.setMargin(removeChampTextField, new Insets(0, 0, 0, 0));
		gridPane.getChildren().add(removeChampTextField);
		
		GridPane.setConstraints(removeChampButton, 1, 1);
		GridPane.setMargin(removeChampButton, new Insets(0, 0, 0, 0));
		gridPane.getChildren().add(removeChampButton);
		
		
		
		return gridPane;
	}

	public GridPane getChampionTable()
	{
		GridPane gridPane = new GridPane();

		GridPane filters = championFilters();
		GridPane.setConstraints(filters, 0, 0);
		GridPane.setMargin(filters, new Insets(0, 0, 0, 0));
		gridPane.getChildren().add(filters);

		ArrayList<Champion> myList = new ArrayList<Champion>(championList.championList);

		VBox champs = championTable(FXCollections.observableArrayList(myList));
		GridPane.setConstraints(champs, 1, 0);
		GridPane.setMargin(champs, new Insets(0, 0, 0, 0));
		gridPane.getChildren().add(champs);
		
		if (hideControls == false)
		{
			GridPane controls = getControls();
			GridPane.setConstraints(controls, 1, 1);
			GridPane.setMargin(controls, new Insets(0, 0, 0, 0));
			gridPane.getChildren().add(controls);
		}

		return gridPane;
	}

}
