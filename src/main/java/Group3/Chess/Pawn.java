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
	public List<Square> getMoves() {
		List<Square> squares = new ArrayList<Square>();
		if (this.getColor() == "white") {
			if(getSquare().getY() > 0){ //ensures that the pawn is not at the opponents first row
			
				//finds the possible squares upwards, first move can be 2 squares, subsequent only 1
				Square square = getBoard().getSquare(getSquare().getX(), getSquare().getY() - 1);
				if (square.getPiece() == null) {
					squares.add(square);
				}
				if(getSquare().getY() == 6){ //if the pawn is in it's starting position
					square = getBoard().getSquare(getSquare().getX(), getSquare().getY() - 2);
				}
				if (square.getPiece() == null && getBoard().getSquare(getSquare().getX(), getSquare().getY() - 1).getPiece() == null) { // cannot jump a piece on initial move
					squares.add(square);
				}
				//finds the possible squares diagonal top right
				if(getSquare().getX() < 7){ // ensures pawn is not looking beyond the edge of the board
					square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() - 1);
					if (square.getPiece() != null) {
						if (square.getPiece().getColor().compareTo(getColor()) != 0) {
							squares.add(square);
						}
					}
				}
				//finds the possible squares diagonal top left
				if(getSquare().getX() > 0){ // ensures pawn is not looking beyond the edge of the board
					square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() - 1);
					if (square.getPiece() != null) {
						if (square.getPiece().getColor().compareTo(getColor()) != 0) {
							squares.add(square);
						}
					}
				}
				////////////////////////////////////////////////////////////////////
				Piece currentPiece = getSquare().getPiece();
				Piece target = null;
				if(currentPiece instanceof Pawn) {
					if((getSquare().getLastPieceMoved() instanceof Pawn) && (getSquare().getLastPieceMoved().getColor() != (currentPiece.getColor())))
					{
						target = getSquare().getLastPieceMoved();
						if((getSquare().getLastSquare().getY() - target.getSquare().getY()) == 2)//might be subtracting same number here
							{
							if((target.getSquare().getX() - currentPiece.getSquare().getX()) == 1)
							{
								square = getBoard().getSquare(target.getSquare().getX(), target.getSquare().getY() + 1);
								squares.add(square);
							}
							if((target.getSquare().getX() - currentPiece.getSquare().getX()) == -1 ){
								square = getBoard().getSquare(target.getSquare().getX(), target.getSquare().getY() + 1);
								squares.add(square);
							}
						}
					}
				}
				//TODO: en passant
				////////////////////////////////////////////////////////////////////
			}
		} else { //if piece is black
			if(getSquare().getY() < 7){
				//finds the possible squares downwards, first move can be 2 squares, subsequent only 1
				Square square = getBoard().getSquare(getSquare().getX(), getSquare().getY() + 1);
				if (square.getPiece() == null) {
					squares.add(square);
				}
				if(getSquare().getY() == 1){ //if the pawn is in it's starting position
					square = getBoard().getSquare(getSquare().getX(), getSquare().getY() + 2);
				}
				if (square.getPiece() == null && getBoard().getSquare(getSquare().getX(), getSquare().getY() + 1).getPiece() == null) { // cannot jump a piece on initial move
					squares.add(square);
				}
				//finds the possible squares diagonal top right
				if(getSquare().getX() < 7){ // ensures pawn is not looking beyond the edge of the board
					square = getBoard().getSquare(getSquare().getX() + 1, getSquare().getY() + 1);
					if (square.getPiece() != null) {
						if (square.getPiece().getColor().compareTo(getColor()) != 0) {
							squares.add(square);
						}
					}
				}	
				//finds the possible squares diagonal top left
				if(getSquare().getX() > 0){ // ensures pawn is not looking beyond the edge of the board
					square = getBoard().getSquare(getSquare().getX() - 1, getSquare().getY() + 1);
					if (square.getPiece() != null) {
						if (square.getPiece().getColor().compareTo(getColor()) != 0) {
							squares.add(square);
						}
					}
				}	
				//TODO: en passant
			}
		}
		return squares;
	}
}