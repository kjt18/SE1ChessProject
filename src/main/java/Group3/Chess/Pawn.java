package Group3.Chess;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
	private int numSquares = 2;
	private boolean isInitialMove = true;
	public Pawn(Board board, Square square, String color) {
		super(board, square, color);
	}
	public Image getImage() {
		return new Image(getColor() == "white" ? "pawn_white.png" : "pawn_black.png");
	}
	public List<Square> getMoves() {
		if (!isInitialMove) {
			numSquares = 1;
		}
		List<Square> squares = new ArrayList<Square>();		
		//finds the possible squares upwards, first move can be 2 squares, subsequent only 1
		for (int i = getSquare().getY() + 1; i <= numSquares; i++) {
			Square square = getBoard().getSquare(getSquare().getX(), i);
			if (square.getPiece() == null) {
				squares.add(square);
			} else {
				break;
			}
		}
		//finds the possible squares diagonal top right if opponent piece is there
		for (int i = 1; getSquare().getX() + i < 2 && getSquare().getY() - i >= 0; i++) {
			Square square = getBoard().getSquare(getSquare().getX() + i, getSquare().getY() - i);
			if (square.getPiece() == null) {
				break;
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		}
		//finds the possible squares diagonal top left if opponent piece is there
		for (int i = 1; getSquare().getX() - i >= 0 && getSquare().getY() - i >= 0; i++) {
			Square square = getBoard().getSquare(getSquare().getX() - i, getSquare().getY() - i);
			if (square.getPiece() == null) {
				break;
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		}
		//TODO: promoting a pawn
		return squares;
	}
}