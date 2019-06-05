
package application;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage) throws IOException, ParseException
	{
//		Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
//        primaryStage.setTitle("test");
//        primaryStage.setScene(new Scene(root, 800, 500));
//        primaryStage.show();

		ChampionProperties championProperties = new ChampionProperties();
		ChampionList championList = new ChampionList();

//		championList.readFromJSON();

		MainScreen mainScreen = new MainScreen(primaryStage);
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
