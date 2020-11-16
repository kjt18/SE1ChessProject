package Group3.Chess;

import javafx.scene.layout.GridPane;

public class Board extends GridPane {
	private Square[] squares = new Square[64];
	private Piece selectedPiece;
	public Board() {
		for (int i = 0; i < squares.length; i++) {
			int x = i % 8;
			int y = (i - x) / 8;
			Square s = new Square(this, null, x, y);
			squares[i] = s;
			add(s, x, y);
		}
	}
	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	public Piece getSelectedPiece() {
		return selectedPiece;
	}
	public Square getSquare(int x, int y) {
		return squares[y * 8 + x];
	}
	public Square[] getSquares() {
		return squares;
	}
	public void placePieces() {
		new Rook(this, getSquare(0, 7), "white");
		new Rook(this, getSquare(7, 7), "white");
		new Knight(this, getSquare(1, 7), "white");
		new Knight(this, getSquare(6, 7), "white");
		new Bishop(this, getSquare(2, 7), "white");
		new Bishop(this, getSquare(5, 7), "white");
		new Queen(this, getSquare(3, 7), "white");
		new King(this, getSquare(4, 7), "white");
		//places 8 pawns (max 8)
		for (int i = 0; i < 8; i++) {
			new Pawn(this, getSquare(i, 6), "white");
		}
		new Rook(this, getSquare(0, 0), "black");
		new Rook(this, getSquare(7, 0), "black");
		new Knight(this, getSquare(1, 0), "black");
		new Knight(this, getSquare(6, 0), "black");
		new Bishop(this, getSquare(2, 0), "black");
		new Bishop(this, getSquare(5, 0), "black");
		new Queen(this, getSquare(3, 0), "black");
		new King(this, getSquare(4, 0), "black");		
		//places 8 pawns (max 8)
		for (int i = 0; i < 8; i++) {
			new Pawn(this, getSquare(i, 1), "black");
		}
	}
}
