
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
		
		String allChampsFile = "allChamps.json";
		String myChampsFile = "myChamps.json";
		
		File tempFile = new File(allChampsFile);
		if (tempFile.exists() == false)
		{
			FileWriter temp = new FileWriter(allChampsFile);
			temp.write(DefaultChampionList.all);
			temp.close();
		}
		
		tempFile = new File(myChampsFile);
		if (tempFile.exists() == false)
		{
			FileWriter temp = new FileWriter(myChampsFile);
			temp.write(DefaultChampionList.none);
			temp.close();
		}
		

		ChampTable defaultChamps = new ChampTable(allChampsFile, true, true);
		ChampTable myChamps = new ChampTable(myChampsFile, false, false);

		borderPane.setLeft(defaultChamps.getChampionTable());
		borderPane.setRight(myChamps.getChampionTable());

		return borderPane;
	}
}
