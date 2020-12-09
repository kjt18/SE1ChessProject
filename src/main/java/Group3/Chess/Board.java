package Group3.Chess;

import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class Board extends GridPane {
	private Square[] squares = new Square[64];
	private Piece selectedPiece;
	private String turnColor;
	private King whiteKing;
	private King blackKing;
	private boolean inCheck;
	public Board() {
		turnColor = "white";
		for (int i = 0; i < squares.length; i++) {
			int x = i % 8;
			int y = (i - x) / 8;
			Square s = new Square(this, null, x, y);
			squares[i] = s;
			add(s, x, y);
		}
	}
	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	public void setTurnColor(String turnColor) {
		this.turnColor = turnColor;
	}
	public void setWhiteKing(King whiteKing) {
		this.whiteKing = whiteKing;
	}
	public void setBlackKing(King blackKing) {
		this.blackKing = blackKing;
	}
	public void setInCheck(boolean inCheck) {
		this.inCheck = inCheck;
	}
	public Piece getSelectedPiece() {
		return selectedPiece;
	}
	public String getTurnColor() {
		return turnColor;
	}
	public King getWhiteKing() {
		return whiteKing;
	}
	public King getBlackKing() {
		return blackKing;
	}
	public boolean getInCheck() {
		return inCheck;
	}
	//if the current turns king is in any one of the opposing pieces move lists, it sets inCheck to true
	public void updateKingInCheck() {
		King king = turnColor.equals("white") ? whiteKing : blackKing;
		String opponentColor = king.equals(whiteKing) ? "black" : "white";
		for (int i = 0; i < squares.length; i++) {
			if (squares[i].getPiece() != null && squares[i].getPiece().getColor().equals(opponentColor)) {
				if(squares[i].getPiece().canMoveTo(king.getSquare())) {
					setInCheck(true);
					return;
				}
			}
		}
		setInCheck(false);
	}
	//checks if moving a piece will resolve the check conflict 
	//(the function moves the piece, checks if it resolves conflicts, then moves the pieces to its original position)
	public boolean doesMovingPieceReturnCheck(Piece movingPiece, Square newSquare) {
		Square originalSquare = movingPiece.getSquare();
		Piece capturedPiece = newSquare.getPiece();
		movingPiece.moveTo(newSquare);
		updateKingInCheck();
		movingPiece.moveTo(originalSquare);
		if (capturedPiece != null) {
			capturedPiece.moveTo(newSquare);
		}
		return getInCheck();
	}
	//loops through every piece of the current player and checks if there are any piece moves that will resolve the check, if not, there is checkmate
	public boolean isCheckmate() {
		for (int i = 0; i < squares.length; i++) {
			if (squares[i].getPiece() != null && squares[i].getPiece().getColor().equals(turnColor)) {
				List<Square> movableSquares = squares[i].getPiece().getMoves();
				for (int j = 0; j < movableSquares.size(); j++) {
					if (doesMovingPieceReturnCheck(squares[i].getPiece(), movableSquares.get(j)) == false) {
						return false;
					}
				}	
			}
		}
		return true;
	}
	//first, this function checks if the current player only has a king, if the player has more than a king, no stalemate 
	//second, it checks if there are only two pieces on the board, (can only be the two kings left), if so, there is stalemate
	//last, it checks if there are any moves that the current player's king can make that do not return check, if there are none, there is a stalemate
	public boolean isStalemate() {
		King king = turnColor.equals("white") ? whiteKing : blackKing;
		int numPieces = 0;
		for (int i = 0; i < squares.length; i++) {
			if (squares[i].getPiece() != null) {
				numPieces++;
				if (squares[i].getPiece().getColor().equals(turnColor) && squares[i].getPiece() != king) {
					return false;
				}
			}
		}
		if (numPieces == 2) {
			return true;
		}
		List<Square> movableSquares = king.getMoves();
		for (int i = 0; i < movableSquares.size(); i++) {
			if (doesMovingPieceReturnCheck(king, movableSquares.get(i)) == false) {
				return false;
			}
		}
		return true;
	}
	//prints if any game elements occurred
	public void getBoardStatus() {
		updateKingInCheck();
		Alert alert = new Alert(AlertType.INFORMATION);
		if (getInCheck() == true) {
			if (isCheckmate() == true) {
				alert.setTitle("Game Over");
				alert.setHeaderText("Checkmate!");
				alert.setContentText(turnColor.contentEquals("white") ? "Black wins!" : "White wins!");
				alert.showAndWait();
				resetGame();
				
			} else {
				alert.setTitle("Check");
				alert.setHeaderText(getTurnColor() + " is in check");
				alert.showAndWait();
			}
		} else if (isStalemate() == true) {
			alert.setTitle("Game Over");
			alert.setHeaderText("Stalemate!");
			alert.setContentText("It's a draw!");
			alert.showAndWait();
			
		}
	}
	public Square getSquare(int x, int y) {
		return squares[y * 8 + x];
	}
	public Square[] getSquares() {
		return squares;
	}
	public void placePieces() {
		new Rook(this, getSquare(0, 7), "white");
		new Rook(this, getSquare(7, 7), "white");
		new Knight(this, getSquare(1, 7), "white");
		new Knight(this, getSquare(6, 7), "white");
		new Bishop(this, getSquare(2, 7), "white");
		new Bishop(this, getSquare(5, 7), "white");
		new Queen(this, getSquare(3, 7), "white");
		whiteKing = new King(this, getSquare(4, 7), "white");
		//places 8 pawns (max 8)
		for (int i = 0; i < 8; i++) {
			new Pawn(this, getSquare(i, 6), "white");
		}
		new Rook(this, getSquare(0, 0), "black");
		new Rook(this, getSquare(7, 0), "black");
		new Knight(this, getSquare(1, 0), "black");
		new Knight(this, getSquare(6, 0), "black");
		new Bishop(this, getSquare(2, 0), "black");
		new Bishop(this, getSquare(5, 0), "black");
		new Queen(this, getSquare(3, 0), "black");
		blackKing = new King(this, getSquare(4, 0), "black");		
		//places 8 pawns (max 8)
		for (int i = 0; i < 8; i++) {
			new Pawn(this, getSquare(i, 1), "black");
		}
	}
	public void resetGame() {
		for(int i = 0; i < 64; i++) {
			squares[i].setPiece(null);
		}
		placePieces();
		setTurnColor("white");
	}
}
