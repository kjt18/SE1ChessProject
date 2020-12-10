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
				Piece enPassantVictim = null;
				if(getBoard().getSquare(this.getSquare().getX()+1, this.getSquare().getY()).getPiece() instanceof Pawn) {
					enPassantVictim = getBoard().getSquare(this.getSquare().getX()+1, this.getSquare().getY()).getPiece();
						if(enPassantVictim.isEnpassantable() == true && enPassantVictim.getColor() != this.getColor()) {
						square = getBoard().getSquare(enPassantVictim.getSquare().getX(), enPassantVictim.getSquare().getY()-1);
						if(square.getPiece() == null) {
								squares.add(square);
						}
					}
					}
				else if(getBoard().getSquare(this.getSquare().getX()-1, this.getSquare().getY()).getPiece() instanceof Pawn) {
				enPassantVictim = getBoard().getSquare(this.getSquare().getX()-1, this.getSquare().getY()).getPiece();
					if(enPassantVictim.isEnpassantable() == true && enPassantVictim.getColor() != this.getColor()) {
					square = getBoard().getSquare(enPassantVictim.getSquare().getX(), enPassantVictim.getSquare().getY()-1);
					if(square.getPiece() == null) {
							squares.add(square);
					}
				}
				}
				if(getBoard().getSquare(this.getSquare().getX(), this.getSquare().getY()+1).getPiece() instanceof Pawn){
				 if(getBoard().getSquare(this.getSquare().getX(), this.getSquare().getY()+1).getPiece().isEnpassantable){
					getBoard().getSquare(this.getSquare().getX(), this.getSquare().getY()+1).setPiece(null);
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
				//TODO: en passant////////
				Piece enPassantVictim = null;
				if(getBoard().getSquare(this.getSquare().getX()+1, this.getSquare().getY()).getPiece() instanceof Pawn) {
				enPassantVictim = getBoard().getSquare(this.getSquare().getX()+1, this.getSquare().getY()).getPiece();
					if(enPassantVictim.isEnpassantable() == true && enPassantVictim.getColor() != this.getColor()) {
					square = getBoard().getSquare(enPassantVictim.getSquare().getX(), enPassantVictim.getSquare().getY()+1);
					if(square.getPiece() == null) {
							squares.add(square);
					}
				}
				}
				else if(getBoard().getSquare(this.getSquare().getX()-1, this.getSquare().getY()).getPiece() instanceof Pawn) {
				enPassantVictim = getBoard().getSquare(this.getSquare().getX()-1, this.getSquare().getY()).getPiece();
					if(enPassantVictim.isEnpassantable() == true && enPassantVictim.getColor() != this.getColor()) {
					square = getBoard().getSquare(enPassantVictim.getSquare().getX(), enPassantVictim.getSquare().getY()+1);
					if(square.getPiece() == null) {
							squares.add(square);
					}
				}
				}
				if(getBoard().getSquare(this.getSquare().getX(), this.getSquare().getY()-1).getPiece() instanceof Pawn){
					 if(getBoard().getSquare(this.getSquare().getX(), this.getSquare().getY()-1).getPiece().isEnpassantable){
						getBoard().getSquare(this.getSquare().getX(), this.getSquare().getY()-1).setPiece(null);
					}
			}
		}
		}
		return squares;
	}
	@Override
	public void moveTo(Square square) {////////////////////////////////////////////////
		//TODO: Set IsEnpassantable
		 /* if((this.getSquare().getY() - getBoard().getSquare(2, 6).getY() == -2) && this.getColor() == "white") {
			setEnpassantable(true);
		  }
		  else if(this.getSquare().getY() == 2 && this.getColor() == "black") {
			  setEnpassantable(true);
		  }
		  if(this.getSquare().getY() != 5 && this.getColor() == "white") {
			  setEnpassantable(false);
		  }
		  else if(this.getSquare().getY() != 2 && this.getColor() == "black") {
			  setEnpassantable(false);
		  }*/
		super.moveTo(square);
	}

	
}