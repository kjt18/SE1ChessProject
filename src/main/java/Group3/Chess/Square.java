package Group3.Chess;

import javafx.scene.control.Label;

public class Square extends Label {
	private Board board;
	private Piece piece;
	private int x;
	private int y;
	private String getPositionColor() {
		return x % 2 == 1 && y % 2 == 1 || x % 2 == 0 && y % 2 == 0 ? "white" : "black";
	}
	public Square(Board board, Piece piece, int x, int y) {
		this.board = board;
		this.piece = piece;
		this.x = x;
		this.y = y;
		setDefaultColor();
		setMinSize(75, 75);
		setMaxSize(75, 75);
	}
	public void setDefaultColor() {
		setStyle(getPositionColor() == "white" ? "-fx-background-color: floralwhite;" : "-fx-background-color: darkgoldenrod;");	
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Board getBoard() {
		return board;
	}
	public Piece getPiece() {
		return piece;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
