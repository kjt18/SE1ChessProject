package Group3.Chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BishopTest {
	@BeforeAll
	public static void setUpRuntime() {
		new AppLauncher().start();
	}
	@Test
	void ThirdFromTopLeftShouldHaveABishopOnBoard() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(2,0);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a bishop
		assertTrue(testPiece instanceof Bishop);
		//Checks if the piece is black
		assertEquals("black", testPiece.getColor());
	}
	@Test
	void ThirdFromTopRightShouldHaveABishopOnBoard() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(5, 0);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a bishop
		assertTrue(testPiece instanceof Bishop);
		//Checks if the piece is black
		assertEquals("black", testPiece.getColor());
	}
	@Test
	void ThirdFromBottomLeftShouldHaveABishopOnBoard() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(2, 7);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a bishop
		assertTrue(testPiece instanceof Bishop);
		//Checks if the piece is white
		assertEquals("white", testPiece.getColor());
	}
	@Test
	void ThirdFromBottomRightShouldHaveABishopOnBoard() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(5, 7);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a bishop
		assertTrue(testPiece instanceof Bishop);
		//Checks if the piece is white
		assertEquals("white", testPiece.getColor());
	}
	@Test
	void BishopCanMoveUpLeftTest() {
		Board testBoard = new Board();
		Square BishopsTestSquare = testBoard.getSquare(3, 3);
		Bishop testBishop = new Bishop(testBoard, BishopsTestSquare, "white");
		
		//Two tests that use different coordinates and are in the path of squares the Bishop can go to
		//The last test to see if the Bishop could go else where that is not part of its move set
		assertTrue(testBishop.getMoves().contains(testBoard.getSquare(1, 1)));
		assertEquals(true, testBishop.canMoveTo(testBoard.getSquare(0,0)));
		assertEquals(false, testBishop.canMoveTo(testBoard.getSquare(0,2)));
	}
	
	@Test
	void BishopCanMoveUpRightTest() {
		Board testBoard = new Board();
		Square BishopsTestSquare = testBoard.getSquare(3, 3);
		Bishop testBishop = new Bishop(testBoard, BishopsTestSquare, "white");
	
		assertTrue(testBishop.getMoves().contains(testBoard.getSquare(6,0)));
		assertEquals(true, testBishop.canMoveTo(testBoard.getSquare(5, 1)));
		assertEquals(false, testBishop.canMoveTo(testBoard.getSquare(5, 3)));
	}
	@Test
	void BishopCanMoveDownRightTest() {
		Board testBoard = new Board();
		Square BishopsTestSquare = testBoard.getSquare(3, 3);
		Bishop testBishop = new Bishop(testBoard, BishopsTestSquare, "white");
		
		assertTrue(testBishop.getMoves().contains(testBoard.getSquare(4, 4)));
		assertEquals(true, testBishop.canMoveTo(testBoard.getSquare(5,5)));
		assertEquals(false, testBishop.canMoveTo(testBoard.getSquare(4,6)));
	}
	@Test
	void BishopCanMoveDownLeftTest() {
		Board testBoard = new Board();
		Square BishopsTestSquare = testBoard.getSquare(3, 3);
		Bishop testBishop = new Bishop(testBoard, BishopsTestSquare, "white");
		
		assertTrue(testBishop.getMoves().contains(testBoard.getSquare(1, 5)));
		assertEquals(true, testBishop.canMoveTo(testBoard.getSquare(2,4)));
		assertEquals(false, testBishop.canMoveTo(testBoard.getSquare(1,7)));
	}
}
