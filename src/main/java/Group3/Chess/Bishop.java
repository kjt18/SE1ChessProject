package Group3.Chess;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
	public Bishop(Board board, Square square, String color) {
		super(board, square, color);
	}
	public Image getImage() {
		return new Image(getColor() == "white" ? "bishop_white.png" : "bishop_black.png");
	}
	public List<Square> getMoves() {
		List<Square> squares = new ArrayList<Square>();	
		//finds the possible squares diagonal top right
		for (int i = 1; getSquare().getX() + i < 8 && getSquare().getY() - i >= 0; i++) {
			Square square = getBoard().getSquare(getSquare().getX() + i, getSquare().getY() - i);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		}
		//finds the possible squares diagonal bottom left
		for (int i = 1; getSquare().getX() - i >= 0 && getSquare().getY() + i < 8; i++) {
			Square square = getBoard().getSquare(getSquare().getX() - i, getSquare().getY() + i);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		}
		//finds the possible squares diagonal bottom right
		for (int i = 1; getSquare().getX() + i < 8 && getSquare().getY() + i < 8; i++) {
			Square square = getBoard().getSquare(getSquare().getX() + i, getSquare().getY() + i);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		}
		//finds the possible squares diagonal top left
		for (int i = 1; getSquare().getX() - i >= 0 && getSquare().getY() - i >= 0; i++) {
			Square square = getBoard().getSquare(getSquare().getX() - i, getSquare().getY() - i);
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