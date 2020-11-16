package Group3.Chess;

import java.util.List;
import javafx.scene.image.Image;

public abstract class Piece {
	private Board board;
	private Square square;
	private String color;
	public Piece(Board board, Square square, String color) {
		this.board = board;
		this.square = square;
		this.color = color;
		square.setPiece(this);
	}
	public boolean canMoveTo(Square square) {
		return getMoves().contains(square);
	}
	public void moveTo(Square square) {
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
	//returns the image of the piece
	public abstract Image getImage();
	//return a list of squares that the piece can move to
	public abstract List<Square> getMoves();
}
