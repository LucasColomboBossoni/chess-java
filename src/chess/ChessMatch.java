package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8); // aqui eu delego a dimensão do tabuleiro na classe da partida de xadrez
		InitialSetup(); // inicia as posicões das peças
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j); //Transformo as peças do tabuleiro(piece) para o tipo de Peças de Xadrez(ChessPiece).
				
			}
		}
		return mat;
	}
	
	private void InitialSetup(){
		board.placePiece( new Rook(board, Color.WHITE), new Position(7, 0));
		board.placePiece( new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece( new King(board, Color.WHITE), new Position(7, 4));
	}
}
