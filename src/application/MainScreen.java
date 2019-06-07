
package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainScreen
{
	MainScreen(Stage mainStage) throws FileNotFoundException, IOException, ParseException
	{
		mainStage.setScene(new Scene(buildScreen()));
		mainStage.show();
	}

	private BorderPane buildScreen() throws FileNotFoundException, IOException, ParseException
	{
		BorderPane borderPane = new BorderPane();

		ChampTable champTable = new ChampTable();
		champTable.championList.writeJSON();

		borderPane.setCenter(champTable.getChampionTable());

		return borderPane;
	}
}
