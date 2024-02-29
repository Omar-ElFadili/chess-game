package org.chessGame.pieces;

import org.chessGame.board.Board;
import org.chessGame.board.Piece;
import org.chessGame.board.Square;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {
        public Rook(int color, Square currentSquare) {
        super(color, currentSquare);
    }

    @Override
    public List<Square> getPossibleMoves(Board sqaureBoard) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();
        Square[][] board = sqaureBoard.getBoard();

        int xCoor = this.getPosition().getxCoordinate();
        int yCoor = this.getPosition().getyCoordinate();
        //occups return les squares proches et ont des pieces de couleur diff si non donne les extrémités
        int[] occups = getLinearOccupiedSquares(board, xCoor, yCoor);
        int lastYup = occups[0];
        int lastYdown = occups[1];
        int lastXleft = occups[2];
        int lastXright = occups[3];
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
