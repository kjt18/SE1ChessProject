package Group3.Chess;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Square extends Label {
	private Board board;
	private Piece piece;
	private int x;
	private int y;
	private Piece lastPiece = null;/////////////////
	private Square lastSquare = null;/////////////
	//finds the color of the square based on its x,y position
	private String getPositionColor() {
		return x % 2 == 1 && y % 2 == 1 || x % 2 == 0 && y % 2 == 0 ? "white" : "black";
	}
	public Square(Board board, Piece piece, int x, int y) {
		this.board = board;
		this.piece = piece;
		this.x = x;
		this.y = y;
		setDefaultColor();
		setMinSize(75, 75);
		setMaxSize(75, 75);
		setAlignment(Pos.CENTER);
		setOnMouseClicked(e -> onMouseClicked());	
	}
	//these set the color of the square when there is a piece that can move to the square
	public void setDefaultColor() {
		setStyle(getPositionColor() == "white" ? "-fx-background-color: floralwhite;" : "-fx-background-color: darkgoldenrod;");	
	}
	public void setMoveColor() {
		setStyle(getPositionColor() == "white" ? "-fx-background-color: forestgreen;" : "-fx-background-color: green;");
	}
	public void setCaptureColor() {
		setStyle(getPositionColor() == "white" ? "-fx-background-color: firebrick;" : "-fx-background-color: darkred;");
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
		if (piece != null) {
			setGraphic(new ImageView(piece.getImage()));
		} else {
			setGraphic(null);
		}
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Board getBoard() {
		return board;
	}
	public Piece getPiece() {////////////
		lastPiece = piece;
		//lastSquare = piece.getSquare();
		return piece;
	}
	public Piece getLastPieceMoved(){///////////////////
		return lastPiece;
	}
	public Square getLastSquare() {////////////////////////
		return getLastPieceMoved().getSquare();
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	//handles the movement of pieces
	private void onMouseClicked() {
		Piece previousPiece = board.getSelectedPiece();		
		if (previousPiece != null) {
			previousPiece.getMoves().forEach(Square::setDefaultColor);	
			if (previousPiece.canMoveTo(this) && board.doesMovingPieceReturnCheck(previousPiece, this) == false) {
				previousPiece.moveTo(this);
				//TODO: set all enemy pawn's isEnpassantable to false
				
				board.setSelectedPiece(null);
				if (previousPiece instanceof Pawn){
					if (previousPiece.getSquare().getY() == 0 || previousPiece.getSquare().getY() == 7) {
						PawnPromotion promotor = new PawnPromotion((Pawn)previousPiece);
						promotor.displayPromotionPopup();
					}
				}
				board.setTurnColor(board.getTurnColor().equals("white") ? "black" : "white");
				board.getBoardStatus();
				return;
			}
		}
		//colors the squares that the piece can move to
		if (piece != null && piece.getColor().equals(board.getTurnColor())) {
			board.setSelectedPiece(piece);
			for (Square s : piece.getMoves()) {
				if (s.getPiece() != null) {
					s.setCaptureColor();
				} else {
					s.setMoveColor();
				}
			}	
		} else {
			board.setSelectedPiece(null);
		}
	}
}
