package org.chessGame.pieces;

import org.chessGame.board.Board;
import org.chessGame.board.Piece;
import org.chessGame.board.Square;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(int color, Square currentSquare) {
        super(color, currentSquare);
    }

    @Override
    public List<Square> getPossibleMoves(Board b) {
        Square[][] board = b.getBoard();
        int x = this.getPosition().getxCoordinate();
        int y = this.getPosition().getyCoordinate();

        return getDiagonalOccupations(board, x, y);
    }
}
