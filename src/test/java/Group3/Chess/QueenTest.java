package Group3.Chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QueenTest {
	@BeforeAll
	public static void setUpRuntime() {
		new AppLauncher().start();
	}
	@Test
	void TopSideHasAQueenOnBoard() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(3,0);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a Queen
		assertTrue(testPiece instanceof Queen);
		//Checks if the piece is black
		assertEquals("black", testPiece.getColor());
	}
	@Test
	void BottomSideHasAQueenOnBoard() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		Square testSquare = testBoard.getSquare(3, 7);
		Piece testPiece = testSquare.getPiece();
		//Checks if the piece in the select square is an instance of a Queen
		assertTrue(testPiece instanceof Queen);
		//Checks if the piece is white
		assertEquals("white", testPiece.getColor());
	}
	//Commencement of diagonal movement testing
	@Test
	void QueenCanMoveUpLeftTest() {
		Board testBoard = new Board();
		Square QueensTestSquare = testBoard.getSquare(3, 3);
		Queen testQueen = new Queen(testBoard, QueensTestSquare, "white");
		
		//Two tests that use different coordinates and are in the path of squares the Queen can go to
		//The last test to see if the Queen could go else where that is not part of its move set
		assertTrue(testQueen.getMoves().contains(testBoard.getSquare(1, 1)));
		assertEquals(true, testQueen.canMoveTo(testBoard.getSquare(0,0)));
		assertEquals(false, testQueen.canMoveTo(testBoard.getSquare(0,2)));
	}
	
	@Test
	void QueenCanMoveUpRightTest() {
		Board testBoard = new Board();
		Square QueensTestSquare = testBoard.getSquare(3, 3);
		Queen testQueen = new Queen(testBoard, QueensTestSquare, "white");
	
		assertTrue(testQueen.getMoves().contains(testBoard.getSquare(6,0)));
		assertEquals(true, testQueen.canMoveTo(testBoard.getSquare(5, 1)));
		assertEquals(false, testQueen.canMoveTo(testBoard.getSquare(5, 4)));
	}
	@Test
	void QueenCanMoveDownRightTest() {
		Board testBoard = new Board();
		Square QueensTestSquare = testBoard.getSquare(3, 3);
		Queen testQueen = new Queen(testBoard, QueensTestSquare, "white");
		
		assertTrue(testQueen.getMoves().contains(testBoard.getSquare(4, 4)));
		assertEquals(true, testQueen.canMoveTo(testBoard.getSquare(5,5)));
		assertEquals(false, testQueen.canMoveTo(testBoard.getSquare(4,6)));
	}
	@Test
	void QueenCanMoveDownLeftTest() {
		Board testBoard = new Board();
		Square QueensTestSquare = testBoard.getSquare(3, 3);
		Queen testQueen = new Queen(testBoard, QueensTestSquare, "white");
		
		assertTrue(testQueen.getMoves().contains(testBoard.getSquare(1, 5)));
		assertEquals(true, testQueen.canMoveTo(testBoard.getSquare(2,4)));
		assertEquals(false, testQueen.canMoveTo(testBoard.getSquare(1,7)));
	}
	//Commencement of straight line movement testing
	@Test
	void QueenCanMoveUpTest() {
		Board testBoard = new Board();
		Square QueensTestSquare = testBoard.getSquare(4, 2);
		Queen testQueen = new Queen(testBoard, QueensTestSquare, "white");
		
		//Two tests that use different coordinates and are in the path of squares the Queen can go to
		//The last test to see if the Queen could go else where that is not part of its move set
		assertTrue(testQueen.getMoves().contains(testBoard.getSquare(4, 1)));
		assertEquals(true, testQueen.canMoveTo(testBoard.getSquare(4,0)));
		assertEquals(false, testQueen.canMoveTo(testBoard.getSquare(5,0)));
	}
	
	@Test
	void QueenCanMoveDownTest() {
		Board testBoard = new Board();
		Square QueensTestSquare = testBoard.getSquare(4, 2);
		Queen testQueen = new Queen(testBoard, QueensTestSquare, "white");
	
		assertTrue(testQueen.getMoves().contains(testBoard.getSquare(4, 3)));
		assertEquals(true, testQueen.canMoveTo(testBoard.getSquare(4,5)));
		assertEquals(false, testQueen.canMoveTo(testBoard.getSquare(5,7)));
	}
	@Test
	void QueenCanMoveToTheLeftTest() {
		Board testBoard = new Board();
		Square QueensTestSquare = testBoard.getSquare(4, 2);
		Queen testQueen = new Queen(testBoard, QueensTestSquare, "white");
		
		assertTrue(testQueen.getMoves().contains(testBoard.getSquare(2, 2)));
		assertEquals(true, testQueen.canMoveTo(testBoard.getSquare(3,2)));
		assertEquals(false, testQueen.canMoveTo(testBoard.getSquare(2,3)));
	}
	@Test
	void QueenCanMoveToTheRightTest() {
		Board testBoard = new Board();
		Square QueensTestSquare = testBoard.getSquare(4, 2);
		Queen testQueen = new Queen(testBoard, QueensTestSquare, "white");
		
		assertTrue(testQueen.getMoves().contains(testBoard.getSquare(5, 2)));
		assertEquals(true, testQueen.canMoveTo(testBoard.getSquare(7,2)));
		assertEquals(false, testQueen.canMoveTo(testBoard.getSquare(7,3)));
	}
}
