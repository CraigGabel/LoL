
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
		MainScreen mainScreen = new MainScreen(primaryStage);
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
