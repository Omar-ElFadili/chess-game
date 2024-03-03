package org.chessGame.pieces;

import org.chessGame.board.Board;
import org.chessGame.board.Piece;
import org.chessGame.board.Square;

import java.util.LinkedList;
import java.util.List;

public class King extends Piece {

    public King(int color, Square currentSquare) {
        super(color, currentSquare);
    }

    @Override
    public List<Square> getPossibleMoves(Board b) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();

        Square[][] board = b.getBoard();

        int x = this.getPosition().getxCoordinate();
        int y = this.getPosition().getyCoordinate();

        for (int i = 1; i >= -1; i--) {
            for (int k = 1; k >= -1; k--) {
                if(i != 0 || k != 0) {
                    try {
                        Square potentialMove = board[y + k][x + i];
                        if (!potentialMove.isSquareOccupied() || potentialMove.getPieceOccupied().getColor() != this.getColor()) {
                            legalMoves.add(potentialMove);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // Ignore invalid positions
                    }
                }
            }
        }

        return legalMoves;    }
}
