package Group3.Chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class KingTest {
	@BeforeAll
	public static void setUpRuntime() {
		new AppLauncher().start();
	}
	@Test
	void MyTestKing() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(4,7);
		Piece testPiece = testSquare.getPiece();
		assertEquals("King", testPiece.getName());
		assertEquals(true, testPiece.isKing("white", 4, 7));
	}
	@Test
	void WhiteSideContainsKing() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(4,7);
		Piece testPiece = testSquare.getPiece();
		assertTrue(testPiece instanceof King);
		assertEquals("white", testPiece.getColor());
	}
	@Test
	void BlackSideContainsKing() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(4,0);
		Piece testPiece = testSquare.getPiece();
		assertTrue(testPiece instanceof King);
		assertEquals("black", testPiece.getColor());
	}
	@Test
	void KingMovesLeft() {
		Board testBoard = new Board();
		Square KingTestSquare = testBoard.getSquare(3, 3);
		King testKing = new King(testBoard, KingTestSquare, "white");
		assertEquals(true, testKing.canMoveTo(testBoard.getSquare(2,3)));
	//	assertEquals(false, testKing.canMoveTo(testBoard.getSquare(1,3)));
	}
	@Test
	void KingMovesRight() {
		Board testBoard = new Board();
		Square KingTestSquare = testBoard.getSquare(3, 3);
		King testKing = new King(testBoard, KingTestSquare, "white");
		assertEquals(true, testKing.canMoveTo(testBoard.getSquare(4,3)));
	//	assertEquals(false, testKing.canMoveTo(testBoard.getSquare(5,3)));
	}
	@Test
	void KingMovesUp() {
		Board testBoard = new Board();
		Square KingTestSquare = testBoard.getSquare(3, 3);
		King testKing = new King(testBoard, KingTestSquare, "white");
		assertEquals(true, testKing.canMoveTo(testBoard.getSquare(3,2)));
		assertEquals(false, testKing.canMoveTo(testBoard.getSquare(3,1)));
	}
	@Test
	void KingMovesDown() {
		Board testBoard = new Board();
		Square KingTestSquare = testBoard.getSquare(3, 3);
		King testKing = new King(testBoard, KingTestSquare, "white");
		assertEquals(true, testKing.canMoveTo(testBoard.getSquare(3,4)));
		assertEquals(false, testKing.canMoveTo(testBoard.getSquare(3,5)));
	}
	@Test
	void KingMovesUpLeft() {
		Board testBoard = new Board();
		Square KingTestSquare = testBoard.getSquare(3, 3);
		King testKing = new King(testBoard, KingTestSquare, "white");
		assertEquals(true, testKing.canMoveTo(testBoard.getSquare(2,2)));
		assertEquals(false, testKing.canMoveTo(testBoard.getSquare(1,1)));
	}
	@Test
	void KingMovesUpRight() {
		Board testBoard = new Board();
		Square KingTestSquare = testBoard.getSquare(3, 3);
		King testKing = new King(testBoard, KingTestSquare, "white");
		assertEquals(true, testKing.canMoveTo(testBoard.getSquare(4,2)));
		assertEquals(false, testKing.canMoveTo(testBoard.getSquare(5,1)));
	}
	@Test
	void KingMovesDownLeft() {
		Board testBoard = new Board();
		Square KingTestSquare = testBoard.getSquare(3, 3);
		King testKing = new King(testBoard, KingTestSquare, "white");
		assertEquals(true, testKing.canMoveTo(testBoard.getSquare(2,4)));
		assertEquals(false, testKing.canMoveTo(testBoard.getSquare(1,5)));
	}
	@Test
	void KingMovesDownRight() {
		Board testBoard = new Board();
		Square KingTestSquare = testBoard.getSquare(3, 3);
		King testKing = new King(testBoard, KingTestSquare, "white");
		assertEquals(true, testKing.canMoveTo(testBoard.getSquare(4,4)));
		assertEquals(false, testKing.canMoveTo(testBoard.getSquare(5,5)));
	}

}
