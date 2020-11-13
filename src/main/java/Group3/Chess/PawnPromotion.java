package Group3.Chess;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PawnPromotion extends Application {
	private Scene pawnPromotion;
	@Override
	public void start(Stage primaryStage) {
		//creates the window
		primaryStage.setTitle("Pawn Promotion");
		primaryStage.setResizable(false);
		
		//Intro Scene
		Label title = new Label("Pawn Promotion");
		title.setStyle("-fx-font-family: verdana; -fx-font-size: 20pt; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: white");
		
		Button select = new Button("Select");
		//start.setOnAction(e -> primaryStage.setScene(game));
		
		PawnPromotionMenu menu = new PawnPromotionMenu();
		HBox settings = new HBox(20);
		settings.getChildren().addAll(menu);
		
		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(20, 20, 90, 20));
		vbox.getChildren().addAll(title, select, settings);
		
		pawnPromotion = new Scene(vbox);
		
		
		primaryStage.setScene(pawnPromotion);
		primaryStage.show();
	}
}
