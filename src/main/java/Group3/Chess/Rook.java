package Group3.Chess;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
	public Rook(Board board, Square square, String color) {
		super(board, square, color);
	}
	public Image getImage() {
		return new Image(getColor() == "white" ? "rook_white.png" : "rook_black.png");
	}
	public List<Square> getMoves() {
		List<Square> squares = new ArrayList<Square>();		
		for (int i = getSquare().getX() + 1; i <= 7; i++) {	
			Square square = getBoard().getSquare(i, getSquare().getY());
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		}
		for (int i = getSquare().getX() - 1; i >= 0; i--) {
			Square square = getBoard().getSquare(i, getSquare().getY());
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		}
		for (int i = getSquare().getY() + 1; i <= 7; i++) {		
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
		for (int i = getSquare().getY() - 1; i >= 0; i--) {		
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
