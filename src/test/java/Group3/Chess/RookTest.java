package Group3.Chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RookTest {
	@BeforeAll
	public static void setUpRuntime() {
		new AppLauncher().start();
	}
	@Test
	void nameCheck() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(0, 0);
		Piece testPiece = testSquare.getPiece();
		assertEquals("Rook", testPiece.getName());
	}
	@Test
	void pieceCheckCheck() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(0, 0);
		Piece testPiece = testSquare.getPiece();
		assertEquals(true, testPiece.isRook("white", 7, 7));
	}
	@Test
	void TopLeftCornerShouldHaveARookOnBoard() {
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
	void TopRightCornerShouldHaveARookOnBoard() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(7, 0);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a rook
		assertTrue(testPiece instanceof Rook);
		//Checks if the piece is black
		assertEquals("black", testPiece.getColor());
	}
	@Test
	void BottomLeftCornerShouldHaveARookOnBoard() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(0, 7);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a rook
		assertTrue(testPiece instanceof Rook);
		//Checks if the piece is white
		assertEquals("white", testPiece.getColor());
	}
	@Test
	void BottomRightCornerShouldHaveARookOnBoard() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(7, 7);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a rook
		assertTrue(testPiece instanceof Rook);
		//Checks if the piece is white
		assertEquals("white", testPiece.getColor());
	}
	@Test
	void RookCanMoveUpTest() {
		Board testBoard = new Board();
		Square RooksTestSquare = testBoard.getSquare(4, 2);
		Rook testRook = new Rook(testBoard, RooksTestSquare, "white");
		
		//Two tests that use different coordinates and are in the path of squares the rook can go to
		//The last test to see if the rook could go else where that is not part of its move set
		assertTrue(testRook.getMoves().contains(testBoard.getSquare(4, 1)));
		assertEquals(true, testRook.canMoveTo(testBoard.getSquare(4,0)));
		assertEquals(false, testRook.canMoveTo(testBoard.getSquare(5,0)));
	}
	
	@Test
	void RookCanMoveDownTest() {
		Board testBoard = new Board();
		Square RooksTestSquare = testBoard.getSquare(4, 2);
		Rook testRook = new Rook(testBoard, RooksTestSquare, "white");
	
		assertTrue(testRook.getMoves().contains(testBoard.getSquare(4, 3)));
		assertEquals(true, testRook.canMoveTo(testBoard.getSquare(4,5)));
		assertEquals(false, testRook.canMoveTo(testBoard.getSquare(5,7)));
	}
	@Test
	void RookCanMoveToTheLeftTest() {
		Board testBoard = new Board();
		Square RooksTestSquare = testBoard.getSquare(4, 2);
		Rook testRook = new Rook(testBoard, RooksTestSquare, "white");
		
		assertTrue(testRook.getMoves().contains(testBoard.getSquare(2, 2)));
		assertEquals(true, testRook.canMoveTo(testBoard.getSquare(3,2)));
		assertEquals(false, testRook.canMoveTo(testBoard.getSquare(3,3)));
	}
	@Test
	void RookCanMoveToTheRightTest() {
		Board testBoard = new Board();
		Square RooksTestSquare = testBoard.getSquare(4, 2);
		Rook testRook = new Rook(testBoard, RooksTestSquare, "white");
		
		assertTrue(testRook.getMoves().contains(testBoard.getSquare(5, 2)));
		assertEquals(true, testRook.canMoveTo(testBoard.getSquare(7,2)));
		assertEquals(false, testRook.canMoveTo(testBoard.getSquare(7,3)));
	}
}
