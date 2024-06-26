package chess;

import boardgame.Position;

public class ChessPosition {
	
	private int row;
	private char column;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.row = row;
		this.column = column;
	}
	
	public char getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}
	
	protected Position toPosition() { // transforma uma posição de xadrez(a1) em uma posição do tipo Position (7, 0)
		return new Position((8 - row), (column - 'a'));
	}
	
	protected static ChessPosition fromPosition(Position position) { // transforma uma posição de tipo Position (7, 0) em uma posição de xadrez (a1)
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
