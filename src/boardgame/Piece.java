package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board; // Ligação com a classe Board.
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() { // Este tabuleiro é de uso interno da camada de tabuleiro e não da camada de ChessMatch(regras)
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
					
				}
			}
		}
		return false;
	}
	
}
