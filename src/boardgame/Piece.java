package boardgame;

public class Piece {

	protected Position position;
	private Board board; // Ligação com a classe Board.
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() { // Este tabuleiro é de uso interno da camada de tabuleiro e não da camada de ChessMatch(regras)
		return board;
	}
	
	
	
}
