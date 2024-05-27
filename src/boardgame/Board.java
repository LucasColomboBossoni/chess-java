package boardgame;

import chess.ChessPiece;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces; //matriz de peças
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) { // joga uma exception se não existe a posiçao
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) { // joga uma exception se não existe a posiçao
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) { // joga uma exception se ja existe uma peça nesta posição
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		
		return aux;
	}
	
	private boolean positionExists(int row, int column) { // verifica se a posição existe com base nos atributos linhas e colunas
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) { // verifica se a posição existe com base em uma variavel do tipo Position
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) { // verifica se ja tem uma peça nesta posição
		if (!positionExists(position)) { // joga uma exception se não existe a posiçao
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
