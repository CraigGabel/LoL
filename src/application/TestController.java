
package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TestController
{
	@FXML
    private Label label1;
	@FXML
    private Label label2;

//	TestController()
//	{
//
//	}

	public void initialize()
	{
		label1.setText("Foo");
		label2.setText("Bar");
	}
}
