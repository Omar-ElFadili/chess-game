package org.chessGame.pieces;

import org.chessGame.board.Board;
import org.chessGame.board.Square;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece{
        public Rook(int color, Square currentSquare) {
        super(color, currentSquare);
    }

    @Override
    public List<Square> getPossibleMoves(Board sqaureBoard) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();
        Square[][] board = sqaureBoard.getBoard();

        int xCoor = this.getPosition().getxCoordinate();
        int yCoor = this.getPosition().getyCoordinate();

        int[] occups = getLinearOccupiedSquares(board, xCoor, yCoor);
        int lastXright = occups[3];
        int lastXleft = occups[2];
        int lastYup = occups[0];
        int lastYdown = occups[1];
        for (int i = lastYup; i <= lastYdown; i++) {
            if (i != yCoor) {
                legalMoves.add(board[i][xCoor]);
            }
        }

        for (int i = lastXleft; i <= lastXright; i++) {
            if (i != xCoor) legalMoves.add(board[yCoor][i]);
        }

        return legalMoves;
    }

}
