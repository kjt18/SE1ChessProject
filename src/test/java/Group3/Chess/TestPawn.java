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
	void secondRowFromTopShouldHavePawns() {
		Board testBoard = new Board();
		testBoard.placePieces();
		for(int i = 0; i <= 7; i++){
			Square testSquare = testBoard.getSquare(0, 1);
			Piece testPiece = testSquare.getPiece();
			//Checks if the piece in the select square is an instance of a pawn
			assertTrue(testPiece instanceof Pawn);
			//Checks if the piece is black
			assertEquals("black", testPiece.getColor());
		}	
	}
	@Test
	void secondRowFromBottomShouldHavePawns() {
		Board testBoard = new Board();
		testBoard.placePieces();		
		for(int i = 0; i <= 7; i++){
			Square testSquare = testBoard.getSquare(0, 6);
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
		
		assertTrue(testPawn.getMoves().contains(testBoard.getSquare(1, 4)));
		assertFalse(testPawn.getMoves().contains(testBoard.getSquare(1, 3)));
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
}