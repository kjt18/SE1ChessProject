package Group3.Chess;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class PawnPromotionMenu extends MenuButton{
	public PawnPromotionMenu() {
		super("Choose Piece");
		MenuItem pawn = new MenuItem("Pawn");
		MenuItem rook = new MenuItem("Rook");
		MenuItem bishop = new MenuItem("Bishop");
		MenuItem knight = new MenuItem("Knight");
		MenuItem queen = new MenuItem("Queen");
		this.getItems().addAll(pawn, rook, bishop, knight, queen);
	}
}
