package Group3.Chess;

import java.util.List;
import javafx.scene.image.Image;

public abstract class Piece {
	private Board board;
	private Square lastSquare;
	private Square square;
	private String color;
	boolean isEnpassantable = false;
	private boolean hasCastled;
	private String name = "";
	public Piece() {};

	public Piece(Board board, Square square, String color) {
		this.board = board;
		this.square = square;
		this.color = color;
		square.setPiece(this);
		hasCastled = false;
	}
	public boolean isRook(String color, int x, int y) {
		Square checkSquares = getBoard().getSquare(x, y);
		if (checkSquares.getPiece().getName().compareTo("Rook") == 0 && checkSquares.getPiece().getColor() == color)
			return true;
		else
				return false;
	}
	public boolean isKing(String color, int x, int y) {
		Square checkSquares = getBoard().getSquare(x, y);
		if (checkSquares.getPiece().getName().compareTo("King") == 0 && checkSquares.getPiece().getColor() == color)
			return true;
		else
				return false;
	}
	public boolean canMoveTo(Square square) {
		return getMoves().contains(square);
	}
	public void moveTo(Square square) {
		lastSquare = this.square;
		this.square.setPiece(null);
		square.setPiece(this);
		setSquare(square);
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public void setSquare(Square square) {
		this.square = square;
	}
	public Square getLastSquare() {return lastSquare;}
	public void setColor(String color) {
		this.color = color;
	}
	public Board getBoard() {
		return board;
	}
	public Square getSquare() {
		return square;
	}
	public String getColor() {
		return color;
	}

	public boolean isEnpassantable() {
		return isEnpassantable;
	}
	public void setEnpassantable(boolean isEnpassantable) {
		this.isEnpassantable = isEnpassantable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCastle(boolean hasCastled) { 
		this.hasCastled = hasCastled;
	}
	public boolean hasKingCastled() {return hasCastled;}

	//returns the image of the piece
	public abstract Image getImage();
	//return a list of squares that the piece can move to
	public abstract List<Square> getMoves();
}
