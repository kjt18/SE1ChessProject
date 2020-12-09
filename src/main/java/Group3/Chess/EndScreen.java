package Group3.Chess;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;

public class EndScreen {
	public boolean displayEndScreenPopup(){
		boolean selectedYes = false;
		Stage endScreenWindow = new Stage();
		endScreenWindow.initModality(Modality.APPLICATION_MODAL);
	
		//creates the window
		endScreenWindow.setTitle("Would you like to play again?");
		endScreenWindow.setResizable(false);
		
		//Promotion Scene setting title
		Label title = new Label("Make your choice and click 'OK'");
		title.setStyle("-fx-font-family: verdana; -fx-font-size: 20pt; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: white");
		
		//button to select piece you have chosen from list
		Button select = new Button("OK");
		select.setOnAction(e -> {
			switch(EndScreenMenu.getChoice()) {
			case "yes":
				break;
			case "no":
				System.exit(1);
				break;
			default:
				//Should never occur
				System.exit(1);
			}
			endScreenWindow.close();
		});
		
		//generates the menu
		EndScreenMenu menu = new EndScreenMenu();
		HBox settings = new HBox(20);
		settings.getChildren().addAll(menu);
		
		//drawing the window to the screen
		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(20, 20, 90, 20));
		vbox.getChildren().addAll(title, select, settings);
		
		Scene scene = new Scene(vbox);
		
		endScreenWindow.setScene(scene);
		endScreenWindow.showAndWait();
		
		return selectedYes;
	}
}
