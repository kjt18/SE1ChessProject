package Group3.Chess;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class PawnPromotionMenu extends MenuButton{
	public PawnPromotionMenu() {
		super("Choose Piece");
		MenuItem rook = new MenuItem("Rook");
		MenuItem bishop = new MenuItem("Bishop");
		MenuItem knight = new MenuItem("Knight");
		MenuItem queen = new MenuItem("Queen");
		MenuItem king = new MenuItem("King");
		this.getItems().addAll(rook, bishop, knight, queen, king);
	}
}
