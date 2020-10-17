package Group3.Chess;

import javafx.scene.layout.GridPane;

public class Board extends GridPane {
	private Square[] squares = new Square[64];
	public Board() {
		for (int i = 0; i < squares.length; i++) {
			int x = i % 8;
			int y = (i - x) / 8;
			Square s = new Square(this, null, x, y);
			squares[i] = s;
			add(s, x, y);
		}
	}
	public Square getSquare(int x, int y) {
		return squares[y * 8 + x];
	}
}
