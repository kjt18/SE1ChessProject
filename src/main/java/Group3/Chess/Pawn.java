package Group3.Chess;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
	private int numSquares = 3;
	private boolean isInitialMove = true;
	public Pawn(Board board, Square square, String color) {
		super(board, square, color);
	}
	public Image getImage() {
		return new Image(getColor() == "white" ? "pawn_white.png" : "pawn_black.png");
	}
		public List<Square> getMoves() {
			if (!isInitialMove) {
				numSquares = 2;
			}
			if (this.getColor() == "white") {
				List<Square> squares = new ArrayList<Square>();		
				//finds the possible squares upwards, first move can be 2 squares, subsequent only 1
				for (int i = getSquare().getY() - 1; i >= 7 - numSquares; i--) {
					Square square = getBoard().getSquare(getSquare().getX(), i);
					if (square.getPiece() == null) {
						squares.add(square);
					} else {
						break;
					}
				}
				//finds the possible squares diagonal top right
				Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() - 1);
				if (square.getPiece() != null) {
					if (square.getPiece().getColor().compareTo(getColor()) != 0) {
						squares.add(square);
					}
				}
				//finds the possible squares diagonal top left
				square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() - 1);
				if (square.getPiece() != null) {
					if (square.getPiece().getColor().compareTo(getColor()) != 0) {
						squares.add(square);
					}
				}
				//TODO: promoting a pawn
				//if(this.getY() == 0) {
				//		
				//}
				//TODO: en passant
				return squares;
			}
	 		else { //if piece is black
			List<Square> squares = new ArrayList<Square>();		
			//finds the possible squares downwards, first move can be 2 squares, subsequent only 1
			for (int i = getSquare().getY() + 1; i <= numSquares; i++) {
				Square square = getBoard().getSquare(getSquare().getX(), i);
				if (square.getPiece() == null) {
					squares.add(square);
				} else {
					break;
				}
			}
			//finds the possible squares diagonal top right
				Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() + 1);
				if (square.getPiece() != null) {
					if (square.getPiece().getColor().compareTo(getColor()) != 0) {
						squares.add(square);
					}
				}
				//finds the possible squares diagonal top left
				square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() + 1);
				if (square.getPiece() != null) {
					if (square.getPiece().getColor().compareTo(getColor()) != 0) {
						squares.add(square);
					}
				}
			//TODO: promoting a pawn
			//if(this.getY() == 7) {
			//		
			//}
			//TODO: en passant
			return squares;
		}
	
	}
}