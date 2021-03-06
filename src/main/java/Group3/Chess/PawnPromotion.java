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

public class PawnPromotion {
	private Piece pawn;
	public PawnPromotion(Piece pawn) {
		this.pawn = pawn;
	}
	public void displayPromotionPopup(){
		Stage pawnPromotionWindow = new Stage();
		pawnPromotionWindow.initModality(Modality.APPLICATION_MODAL);
	
		//creates the window
		pawnPromotionWindow.setTitle("Pawn Promotion");
		pawnPromotionWindow.setResizable(false);
		
		//Promotion Scene setting title
		Label title = new Label("Pawn Promotion");
		title.setStyle("-fx-font-family: verdana; -fx-font-size: 20pt; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: white");
		
		//button to select piece you have chosen from list
		Button select = new Button("Select");
		select.setOnAction(e -> {
			switch(PawnPromotionMenu.getChoice()) {
			case "Rook":
				new Rook(pawn.getBoard(), pawn.getSquare(), pawn.getColor());
				break;
			case "Bishop":
				new Bishop(pawn.getBoard(), pawn.getSquare(), pawn.getColor());
				break;
			case "Knight":
				new Knight(pawn.getBoard(), pawn.getSquare(), pawn.getColor());
				break;
			case "Queen":
				new Queen(pawn.getBoard(), pawn.getSquare(), pawn.getColor());
				break;
			default:
				//Should never occur
				System.exit(1);
			}
			pawnPromotionWindow.close();
		});
		
		//generates the menu
		PawnPromotionMenu menu = new PawnPromotionMenu();
		HBox settings = new HBox(20);
		settings.getChildren().addAll(menu);
		
		//drawing the window to the screen
		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(20, 20, 90, 20));
		vbox.getChildren().addAll(title, select, settings);
		
		Scene scene = new Scene(vbox);
		
		pawnPromotionWindow.setScene(scene);
		pawnPromotionWindow.showAndWait();
	}
}
