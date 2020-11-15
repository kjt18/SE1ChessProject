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
	void PawnMoveTest() {
		Board testBoard = new Board();
		Square startingSquare = testBoard.getSquare(1, 1);
		Pawn testPawn = new Pawn(testBoard, startingSquare, "black");
		
		//Checks if the pawn can move down 1 square
		assertEquals(true, testPawn.canMoveTo(testBoard.getSquare(2, 1)));
		
		//Checks if the pawn can move down 2 square
		//assertEquals(true, testPawn.canMoveTo(testBoard.getSquare(3, 1)));
		
		//Moves the king down 1 square
		testPawn.moveTo(testBoard.getSquare(2, 1));
		
		//Checks if the pawn is in the new square
		assertTrue(testBoard.getSquare(2, 1).getPiece() == testPawn);
		
		//Checks if the original square still has a piece
		assertEquals(null, startingSquare.getPiece());
	}
}