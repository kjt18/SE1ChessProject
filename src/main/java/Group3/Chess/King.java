package Group3.Chess;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(Board board, Square square, String color) {
		super(board, square, color);
		setName("King");
	}
	public Image getImage() {
		return new Image(getColor() == "white" ? "king_white.png" : "king_black.png");
	}
	private boolean checkSquare(int x, int y) {
		Square checkSquares = getBoard().getSquare(x, y);
		if (checkSquares.getPiece() == null)
			return true;
		else return false;	
	}
	public List<Square> getMoves() {
		List<Square> squares = new ArrayList<Square>();		
		//finds the possible squares to the right
		if (getSquare().getX() != 7) 
		{	
			Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY());
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		
			//finds the possible squares to the left
		if (getSquare().getX() != 0) 
		{
			Square square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY());
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}

			//finds the possible squares upwards
		
		if (getSquare().getY() != 0) 
		{ 
			Square square = getBoard().getSquare(getSquare().getX(), getSquare().getY() - 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
			//finds the possible squares downwards
		if (getSquare().getY() != 7) 
		{
			Square square = getBoard().getSquare(getSquare().getX(), getSquare().getY() + 1); 
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
			
		//finds the possible squares diagonal top right
		if (getSquare().getY() != 0 && getSquare().getX() != 7) 
		{
			Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() - 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		//finds the possible squares diagonal bottom left
		if (getSquare().getY() != 7 && getSquare().getX() != 0) 
		{
			Square square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() + 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		
		//finds the possible squares diagonal bottom right
		if (getSquare().getY() != 7 && getSquare().getX() != 7) 
		{
			Square square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() + 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		//finds the possible squares diagonal top left
		if (getSquare().getY() != 0 && getSquare().getX() != 0)
		{
			Square square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() - 1);
			if (square.getPiece() == null) {
				squares.add(square);
			} else if (square.getPiece().getColor().compareTo(getColor()) != 0) {
				squares.add(square);
			}
		}
		//finds castling possibilities-white right side of king
		if (getSquare().getX() == 4 && getSquare().getY() == 7 && getColor() == "white" && getSquare().getPiece().getName().compareTo("King")==0) {
		Square rookTestSquare = getBoard().getSquare(7, 7);
			if (!(getBoard().getSquare(4, 7).getPiece().hasKingCastled())) {	
				if (rookTestSquare.getPiece().isRook(getColor(), 7, 7) && checkSquare(5,7) && checkSquare(6,7))  
					squares.add(getBoard().getSquare(6, 7));
			}
		}
		//finds castling possibilities-white left side of king
		if (getSquare().getX() == 4 && getSquare().getY() == 7 && getColor() == "white"  && getSquare().getPiece().getName().compareTo("King")==0) {
		Square rookTestSquare = getBoard().getSquare(0, 7);
			if (!(getBoard().getSquare(4, 7).getPiece().hasKingCastled())) {	
				if (rookTestSquare.getPiece().isRook(getColor(), 0, 7) && checkSquare(1,7) && checkSquare(2,7) && checkSquare(3,7)) 
					squares.add(getBoard().getSquare(2, 7));
			}
		}
		//finds castling possibilities-black right side of king
		if (getSquare().getX() == 4 && getSquare().getY() == 0 && getColor().compareTo("black")==0 && getSquare().getPiece().getName().compareTo("King")==0) {
		Square rookTestSquare = getBoard().getSquare(7, 0);
			if (!(getBoard().getSquare(4, 0).getPiece().hasKingCastled())) {	
				if (rookTestSquare.getPiece().isRook(getColor(), 7, 0) && checkSquare(5,0) && checkSquare(6,0))  
					squares.add(getBoard().getSquare(6, 0));
			}
		}
		//finds castling possibilities-black left side of king
		if (getSquare().getX() == 4 && getSquare().getY() == 0 && getColor() == "black"  && getSquare().getPiece().getName().compareTo("King")==0) {
		Square rookTestSquare = getBoard().getSquare(0, 0);
			if (!(getBoard().getSquare(4, 0).getPiece().hasKingCastled())){	
				if (rookTestSquare.getPiece().isRook(getColor(), 0, 0) && checkSquare(1,0) && checkSquare(2,0) && checkSquare(3,0))  
					squares.add(getBoard().getSquare(2, 0));
			}
		}
		return squares;
	}
}  