package Group3.Chess;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
	public Pawn(Board board, Square square, String color) {
		super(board, square, color);
	}
	public Image getImage() {
		return new Image(getColor() == "white" ? "pawn_white.png" : "pawn_black.png");
	}
	public List<Square> getMoves() {
		List<Square> squares = new ArrayList<Square>();		
		//TODO create pawn's move set
		return squares;
	}
}
