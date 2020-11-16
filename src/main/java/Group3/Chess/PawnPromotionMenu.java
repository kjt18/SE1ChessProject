package Group3.Chess;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class PawnPromotionMenu extends MenuButton{
	private static String choice;
	public PawnPromotionMenu() {
		super("Choose Piece");
		MenuItem rook = new MenuItem("Rook");
		rook.setOnAction(e -> choice = "Rook");
		MenuItem bishop = new MenuItem("Bishop");
		bishop.setOnAction(e -> choice = "Bishop");
		MenuItem knight = new MenuItem("Knight");
		knight.setOnAction(e -> choice = "Knight");
		MenuItem queen = new MenuItem("Queen");
		queen.setOnAction(e -> choice = "Queen");
		this.getItems().addAll(rook, bishop, knight, queen);
	}
	
	public static String getChoice() {
		return choice;
	}
}
