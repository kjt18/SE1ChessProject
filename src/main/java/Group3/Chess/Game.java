package Group3.Chess;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends Application {
	private Scene intro, game;
	@Override
	public void start(Stage primaryStage) {
		//creates the window
		primaryStage.setTitle("Group3 : Chess");
		primaryStage.setResizable(false);
		
		//Intro Scene
		Label title = new Label("Chess");
		title.setStyle("-fx-font-family: verdana; -fx-font-size: 20pt; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: white");
		
		Button start = new Button("Start");
		start.setOnAction(e -> primaryStage.setScene(game));
		
		CheckBox timer = new CheckBox("Timer ");
		timer.setIndeterminate(false);
		timer.setStyle("-fx-font-family: verdana; -fx-text-fill: black; -fx-background-color: white");
		
		OpponentMenu m1 = new OpponentMenu();
		ColorMenu m2 = new ColorMenu();
		HBox settings = new HBox(20);
		settings.getChildren().addAll(timer, m1, m2);
		
		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(20, 20, 90, 20));
		vbox.getChildren().addAll(title, start, settings);
		
		intro = new Scene(vbox);
		intro.getStylesheets().add("/IntroBackground.css");
		
		//Game Scene
		Board board = new Board();
		GridPane gp = new GridPane();
		//creates the coordinate labels
		for (int i = 0; i < 8; i++) {
			gp.add(getRankLabel(i), 0, i + 1, 1, 1);
			gp.add(getRankLabel(i), 9, i + 1, 1, 1);
			gp.add(getFileLabel(i), i + 1, 0, 1, 1);
			gp.add(getFileLabel(i), i + 1, 9, 1, 1);
		}
		gp.add(board, 1, 1, 8, 8);
		gp.setAlignment(Pos.CENTER);
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(gp);
		game = new Scene(borderPane, 750, 750);
		primaryStage.setScene(intro);
		primaryStage.show();
		//places pieces on the board
		board.placePieces();
	}
	private Label getRankLabel(int i) {
		Label l = new Label(Integer.toString(8 - i));
		l.setStyle("-fx-font-family: verdana; -fx-font-size: 20pt; -fx-font-weight: bold;");
		l.setAlignment(Pos.CENTER);
		l.setMinSize(30, 75);	
		return l;
	}
	private Label getFileLabel(int i) {
		Label l = new Label(Character.toString(i + 65));
		l.setStyle("-fx-font-family: verdana; -fx-font-size: 20pt; -fx-font-weight: bold;");
		l.setAlignment(Pos.CENTER);
		l.setMinSize(75, 30);	
		return l;
	}
}
