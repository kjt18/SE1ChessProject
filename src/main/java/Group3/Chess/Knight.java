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
		//finds the possible squares up up right
		{
			Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() - 2);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		//finds the possible squares up right right
		{
			Square square = getBoard().getSquare(getSquare().getX() + 2, getSquare().getY() - 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		//finds the possible squares up up left
		{
			Square square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() - 2);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		//finds the possible squares up left left
		{
			Square square = getBoard().getSquare(getSquare().getX() - 2, getSquare().getY() - 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		
				//finds the possible squares down down right
		{
			Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() + 2);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		//finds the possible squares down right right
		{
			Square square = getBoard().getSquare(getSquare().getX() + 2, getSquare().getY() + 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		//finds the possible squares down down left
		{
			Square square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() + 2);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		//finds the possible squares down left left
		{
			Square square = getBoard().getSquare(getSquare().getX() - 2, getSquare().getY() + 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		
		return squares;
	}
}