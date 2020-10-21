package Group3.Chess;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
	public Queen(Board board, Square square, String color) {
		super(board, square, color);
	}
	public Image getImage() {
		return new Image(getColor() == "white" ? "queen_white.png" : "queen_black.png");
	}
	public List<Square> getMoves() {
		List<Square> squares = new ArrayList<Square>();		
		//TODO create queen's move set
		return squares;
	}
}
