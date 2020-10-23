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
	private int moveValue = 2;
	if (this.getSquare().getY() - 1 > 1){
		moveValue = 1;
	}
	public List<Square> getMoves() {
		List<Square> squares = new ArrayList<Square>();		
		//finds the possible squares downwards
		for (int i = getSquare().getY() - 1; i >= 0 && getSquare().getY() + i < moveValue; i--) {		
			Square square = getBoard().getSquare(getSquare().getX(), i);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		}	
		return squares;
	}
}
