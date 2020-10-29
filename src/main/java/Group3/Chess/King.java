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
			//finds the possible squares to the right
			Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY());
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		
			//finds the possible squares to the left
			Square square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY());
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}

			//finds the possible squares upwards
			Square square = getBoard().getSquare(getSquare().getX(), getSquare().getY() + 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
	
			//finds the possible squares downwards
			Square square = getBoard().getSquare(getSquare().getX(), getSquare().getY() - 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
			
		//finds the possible squares diagonal top right
			Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() - 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
			
		//finds the possible squares diagonal bottom left
			Square square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() + 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
				break;
			} else {
				break;
			}
		
		//finds the possible squares diagonal bottom right
			Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() + 1);
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
			Square square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() - 1);
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