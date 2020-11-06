package Group3.Chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestExample {
	@BeforeAll
	public static void setUpRuntime() {
		new AppLauncher().start();
	}
	@Test
	void BoardShouldHave64Squares() {
		Board testBoard = new Board();
		//Checks if the board has 64 squares
		assertEquals(64, testBoard.getSquares().length);
	}
	@Test
	void TopLeftCornerShouldHaveARookAfterPlacingAllPieces() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(0, 0);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a rook
		assertTrue(testPiece instanceof Rook);
		//Checks if the piece is black
		assertEquals("black", testPiece.getColor());
	}
	@Test
	void KingMoveTest() {
		Board testBoard = new Board();
		Square startingSquare = testBoard.getSquare(0, 0);
		King testKing = new King(testBoard, startingSquare, "white");
		
		//Checks if the king can move to the right 1 square
		assertEquals(true, testKing.canMoveTo(testBoard.getSquare(0, 1)));
		//Checks if the king cannot move to the right 2 square
		assertEquals(false, testKing.canMoveTo(testBoard.getSquare(0, 2)));
		//Moves the king to the right 1 square
		testKing.moveTo(testBoard.getSquare(0, 1));
		//Checks if the king is in the new square
		assertTrue(testBoard.getSquare(0, 1).getPiece() == testKing);
		//Checks if the original square still has a piece
		assertEquals(null, startingSquare.getPiece());
	}
}
