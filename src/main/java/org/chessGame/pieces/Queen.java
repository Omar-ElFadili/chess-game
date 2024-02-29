package org.chessGame.pieces;

import org.chessGame.board.Board;
import org.chessGame.board.Piece;
import org.chessGame.board.Square;

import java.util.LinkedList;
import java.util.List;

public class Queen extends Piece {
    public Queen(int color, Square currentSquare) {
        super(color, currentSquare);
    }

    @Override
    public List<Square> getPossibleMoves(Board b) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();
        Square[][] board = b.getBoard();

        int x = this.getPosition().getxCoordinate();
        int y = this.getPosition().getyCoordinate();

        int[] occups = getLinearOccupiedSquares(board, x, y);

        for (int i = occups[0]; i <= occups[1]; i++) {
            if (i != y) legalMoves.add(board[i][x]);
        }

        for (int i = occups[2]; i <= occups[3]; i++) {
            if (i != x) legalMoves.add(board[y][i]);
        }

        List<Square> bMoves = getDiagonalOccupations(board, x, y);

        legalMoves.addAll(bMoves);

        return legalMoves;
    }

}
