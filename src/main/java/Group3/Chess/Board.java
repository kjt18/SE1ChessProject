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
	public void placeTestPieces() {
		Bishop b1 = new Bishop(this, getSquare(3, 3), "black");
		getSquare(3, 3).setPiece(b1);
		
		Bishop b2 = new Bishop(this, getSquare(6, 6), "white");
		getSquare(6, 6).setPiece(b2);
		
		Rook r1 = new Rook(this, getSquare(1, 3), "black");
		getSquare(1, 3).setPiece(r1);
		
		Rook r2 = new Rook(this, getSquare(2, 6), "white");
		getSquare(2, 6).setPiece(r2);
	}
}
