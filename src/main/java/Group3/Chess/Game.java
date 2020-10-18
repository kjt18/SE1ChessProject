package Group3.Chess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Game extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Group3 : Chess");
		primaryStage.setResizable(false);
		Board board = new Board();
		GridPane gp = new GridPane();
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
		Scene scene = new Scene(borderPane, 750, 750);
		primaryStage.setScene(scene);
		primaryStage.show();
		board.placeTestPieces();
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
