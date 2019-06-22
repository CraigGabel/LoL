
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

		ChampTable defaultChamps = new ChampTable("src/application/ChampionList2 - new.json", true, true);
		ChampTable myChamps = new ChampTable("src/application/test.json", false, false);

		borderPane.setLeft(defaultChamps.getChampionTable());
		borderPane.setRight(myChamps.getChampionTable());

		return borderPane;
	}
}
