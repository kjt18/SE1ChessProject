package Group3.Chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class KnightTest {
	@BeforeAll
	public static void setUpRuntime() {
		new AppLauncher().start();
	}
	@Test
	void WhiteSideContainsKnight1() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(1,7);
		Piece testPiece = testSquare.getPiece();
		assertTrue(testPiece instanceof Knight);
		assertEquals("white", testPiece.getColor());
	}
	@Test
	void BlackSideContainsKnight1() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(1,0);
		Piece testPiece = testSquare.getPiece();
		assertTrue(testPiece instanceof Knight);
		assertEquals("black", testPiece.getColor());
	}
	@Test
	void WhiteSideContainsKnight2() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(6,7);
		Piece testPiece = testSquare.getPiece();
		assertTrue(testPiece instanceof Knight);
		assertEquals("white", testPiece.getColor());
	}
	@Test
	void BlackSideContainsKnight2() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(6,0);
		Piece testPiece = testSquare.getPiece();
		assertTrue(testPiece instanceof Knight);
		assertEquals("black", testPiece.getColor());
	}
	@Test
	void KnightMovesUpUpLeft() {
		Board testBoard = new Board();
		Square KnightTestSquare = testBoard.getSquare(3, 3);
		Knight testKnight = new Knight(testBoard, KnightTestSquare, "white");
		assertEquals(true, testKnight.canMoveTo(testBoard.getSquare(2,1)));
		assertEquals(false, testKnight.canMoveTo(testBoard.getSquare(1,1)));
	}
	@Test
	void KnightMovesUpLeftLeft() {
		Board testBoard = new Board();
		Square KnightTestSquare = testBoard.getSquare(3, 3);
		Knight testKnight = new Knight(testBoard, KnightTestSquare, "white");
		assertEquals(true, testKnight.canMoveTo(testBoard.getSquare(1,2)));
		assertEquals(false, testKnight.canMoveTo(testBoard.getSquare(2,2)));
	}
	@Test
	void KnightMovesUpUpRight() {
		Board testBoard = new Board();
		Square KnightTestSquare = testBoard.getSquare(3, 3);
		Knight testKnight = new Knight(testBoard, KnightTestSquare, "white");
		assertEquals(true, testKnight.canMoveTo(testBoard.getSquare(4,1)));
		assertEquals(false, testKnight.canMoveTo(testBoard.getSquare(4,2)));
	}
	@Test
	void KnightMovesUpRightRight() {
		Board testBoard = new Board();
		Square KnightTestSquare = testBoard.getSquare(3, 3);
		Knight testKnight = new Knight(testBoard, KnightTestSquare, "white");
		assertEquals(true, testKnight.canMoveTo(testBoard.getSquare(5,2)));
		assertEquals(false, testKnight.canMoveTo(testBoard.getSquare(5,1)));
	}
	@Test
	void KnightMovesDownLeftLeft() {
		Board testBoard = new Board();
		Square KnightTestSquare = testBoard.getSquare(3, 3);
		Knight testKnight = new Knight(testBoard, KnightTestSquare, "white");
		assertEquals(true, testKnight.canMoveTo(testBoard.getSquare(1,4)));
		assertEquals(false, testKnight.canMoveTo(testBoard.getSquare(1,3)));
	}
	@Test
	void KnightMovesDownDownLeft() {
		Board testBoard = new Board();
		Square KnightTestSquare = testBoard.getSquare(3, 3);
		Knight testKnight = new Knight(testBoard, KnightTestSquare, "white");
		assertEquals(true, testKnight.canMoveTo(testBoard.getSquare(2,5)));
		assertEquals(false, testKnight.canMoveTo(testBoard.getSquare(2,2)));
	}
	@Test
	void KnightMovesDownRightRight() {
		Board testBoard = new Board();
		Square KnightTestSquare = testBoard.getSquare(3, 3);
		Knight testKnight = new Knight(testBoard, KnightTestSquare, "white");
		assertEquals(true, testKnight.canMoveTo(testBoard.getSquare(5,4)));
		assertEquals(false, testKnight.canMoveTo(testBoard.getSquare(5,5)));
	}
	@Test
	void KnightMovesDownDownRight() {
		Board testBoard = new Board();
		Square KnightTestSquare = testBoard.getSquare(3, 3);
		Knight testKnight = new Knight(testBoard, KnightTestSquare, "white");
		assertEquals(true, testKnight.canMoveTo(testBoard.getSquare(4,5)));
		assertEquals(false, testKnight.canMoveTo(testBoard.getSquare(4,4)));
	}
}
