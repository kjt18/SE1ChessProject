package Group3.Chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestPawn {
	@BeforeAll
	public static void setUpRuntime() {
		new AppLauncher().start();
	}	
	@Test
	void secondRowFromTopShouldHavePawnsTest() {
		Board testBoard = new Board();
		testBoard.placePieces();
		
		//test that there is a pawn in each square in row 2
		for(int i = 0; i <= 7; i++){
			Square testSquare = testBoard.getSquare(i, 1);
			Piece testPiece = testSquare.getPiece();
			//Checks if the piece in the select square is an instance of a pawn
			assertTrue(testPiece instanceof Pawn);
			//Checks if the piece is black
			assertEquals("black", testPiece.getColor());
		}	
	}
	@Test
	void secondRowFromBottomShouldHavePawnsTest() {
		Board testBoard = new Board();
		testBoard.placePieces();
		
		//test that there is a pawn in each square in row 6
		for(int i = 0; i <= 7; i++){
			Square testSquare = testBoard.getSquare(i, 6);
			Piece testPiece = testSquare.getPiece();
			//Checks if the piece in the select square is an instance of a pawn
			assertTrue(testPiece instanceof Pawn);
			//Checks if the piece is white
			assertEquals("white", testPiece.getColor());
		}	
	}
	@Test
	void BlackPawnCanMoveDownOneOrTwoOnFirstMoveTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 1);
		Piece testPawn = testSquare.getPiece();
		assertTrue(testPawn.getColor() == "black");
		
		//Two tests that use different coordinates and are in the path of squares the pawn can go to on the first move
		assertTrue(testPawn.getMoves().contains(testBoard.getSquare(1, 2)));
		assertTrue(testPawn.canMoveTo(testBoard.getSquare(1, 3)));
		//test to show the pawn cannot move three squares on first move
		assertFalse(testPawn.canMoveTo(testBoard.getSquare(1, 4)));
	}
	@Test
	void BlackPawnCannotMoveDiagonallyDownTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 1);
		Piece testPawn = testSquare.getPiece();
		assertTrue(testPawn.getColor() == "black");
		
		//test to show the pawn cannot move diagonally down and right one square
		assertFalse(testPawn.canMoveTo(testBoard.getSquare(2, 2)));
		//test to show the pawn cannot move diagonally down and left one square
		assertFalse(testPawn.canMoveTo(testBoard.getSquare(0, 2)));
	}
	@Test
	void WhitePawnCanMoveUpOneOrTwoOnFirstMoveTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 6);
		Piece testPawn = testSquare.getPiece();
		assertTrue(testPawn.getColor() == "white");
		
		//Two tests that use different coordinates and are in the path of squares the pawn can go to on the first move
		assertTrue(testPawn.getMoves().contains(testBoard.getSquare(1, 5)));
		assertTrue(testPawn.canMoveTo(testBoard.getSquare(1, 4)));
		//test to show the pawn cannot move three squares on first move
		assertFalse(testPawn.canMoveTo(testBoard.getSquare(1, 3)));
	}
	@Test
	void WhitePawnCanMoveDiagonallyUpTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 6);
		Piece testPawn = testSquare.getPiece();
		assertTrue(testPawn.getColor() == "white");
		
		//test to show the pawn cannot move diagonally up and right one square
		assertFalse(testPawn.canMoveTo(testBoard.getSquare(2, 5)));
		//test to show the pawn cannot move diagonally up and left one square
		assertFalse(testPawn.canMoveTo(testBoard.getSquare(0, 5)));
	}
	@Test
	void BlackPawnCanMoveOnlyOneSquareAfterFirstMoveTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 1);
		Piece testPawn = testSquare.getPiece();
		testSquare = testBoard.getSquare(1, 2);
		testPawn.moveTo(testSquare);
		
		//test to see if pawn can move down one square but not two
		assertTrue(testPawn.getMoves().contains(testBoard.getSquare(1, 3)));
		assertFalse(testPawn.getMoves().contains(testBoard.getSquare(1, 4)));
	}
	@Test
	void WhitePawnCanMoveOnlyOneSquareAfterFirstMoveTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 6);
		Piece testPawn = testSquare.getPiece();
		testSquare = testBoard.getSquare(1, 5);
		testPawn.moveTo(testSquare);
		
		//test to see if pawn can move up one square but not two
		assertTrue(testPawn.getMoves().contains(testBoard.getSquare(1, 4)));
		assertFalse(testPawn.getMoves().contains(testBoard.getSquare(1, 3)));
	}
	@Test
	void BlackPawnCannotMoveUpTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 1);
		Piece testPawn = testSquare.getPiece();
		testSquare = testBoard.getSquare(1, 2);
		testPawn.moveTo(testSquare);
		
		//test to see if pawn can move up
		assertFalse(testPawn.getMoves().contains(testBoard.getSquare(1, 1)));
	}
	@Test
	void WhitePawnCannotMoveDownTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 6);
		Piece testPawn = testSquare.getPiece();
		testSquare = testBoard.getSquare(1, 5);
		testPawn.moveTo(testSquare);
		
		//test to see if pawn can move down
		assertFalse(testPawn.getMoves().contains(testBoard.getSquare(1, 6)));
	}
	@Test
	void BlackPawnCanCapturTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square playerSquare = testBoard.getSquare(1, 1);
		Piece playerPawn = playerSquare.getPiece();
		Square opponentSquare = testBoard.getSquare(2, 6);
		Piece opponentPawn = opponentSquare.getPiece();
		opponentSquare = testBoard.getSquare(2, 2);
		opponentPawn.moveTo(opponentSquare);
		
		//playerPawn can move to (capture) piece diagonally down and to the right
		assertTrue(playerPawn.getMoves().contains(testBoard.getSquare(2, 2)));
		
		//move opponent piece
		opponentSquare = testBoard.getSquare(0, 2);
		opponentPawn.moveTo(opponentSquare);
		
		//show playerPawn can move to (capture) piece diagonally down and to the left
		assertTrue(playerPawn.getMoves().contains(testBoard.getSquare(0, 2)));
	}
	@Test
	void WhitePawnCanCapturTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square playerSquare = testBoard.getSquare(1, 6);
		Piece playerPawn = playerSquare.getPiece();
		Square opponentSquare = testBoard.getSquare(2, 1);
		Piece opponentPawn = opponentSquare.getPiece();
		opponentSquare = testBoard.getSquare(2, 5);
		opponentPawn.moveTo(opponentSquare);
		
		//playerPawn can move to (capture) piece diagonally up and to the right
		assertTrue(playerPawn.getMoves().contains(testBoard.getSquare(2, 5)));
		
		//move opponent piece
		opponentSquare = testBoard.getSquare(0, 5);
		opponentPawn.moveTo(opponentSquare);
		
		//show playerPawn can move to (capture) piece diagonally up and to the left
		assertTrue(playerPawn.getMoves().contains(testBoard.getSquare(0, 5)));
	}
	@Test
	void WhitePawnPromotionTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 1);
		Pawn testPawn = new Pawn(testBoard, testSquare, "white");
		
		testSquare = testBoard.getSquare(1, 0);
		testPawn.moveTo(testSquare);
		//TODO: test the pawn promotion menu
		//TODO: test the piece selection
		//TODO: test that the selected piece is in the square
	}
	@Test
	void BlackPawnPromotionTest() {
		Board testBoard = new Board();
		testBoard.placePieces();	
		Square testSquare = testBoard.getSquare(1, 6);
		Pawn testPawn = new Pawn(testBoard, testSquare, "black");
		
		testSquare = testBoard.getSquare(1, 7);
		testPawn.moveTo(testSquare);
		//TODO: test the pawn promotion menu
		//TODO: test the piece selection
		//TODO: test that the selected piece is in the square
	}
}