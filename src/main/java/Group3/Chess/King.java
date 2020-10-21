package Group3.Chess;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(Board board, Square square, String color) {
		super(board, square, color);
	}
	public Image getImage() {
		return new Image(getColor() == "white" ? "king_white.png" : "king_black.png");
	}
	public List<Square> getMoves() {
		List<Square> squares = new ArrayList<Square>();		
		//TODO create king's move set
		return squares;
	}
}
