package Group3.Chess;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	public Knight(Board board, Square square, String color) {
		super(board, square, color);
	}
	public Image getImage() {
		return new Image(getColor() == "white" ? "knight_white.png" : "knight_black.png");
	}
	public List<Square> getMoves() {
		List<Square> squares = new ArrayList<Square>();		
		//TODO create knight's move set
		return squares;
	}
}
