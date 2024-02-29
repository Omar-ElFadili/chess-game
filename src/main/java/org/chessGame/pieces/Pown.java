package org.chessGame.pieces;

import org.chessGame.board.Board;
import org.chessGame.board.Piece;
import org.chessGame.board.Square;

import java.util.LinkedList;
import java.util.List;

public class Pown extends Piece {
    private boolean wasMoved;
    public Pown(int color, Square currentSquare) {
        super(color, currentSquare);
    }
    @Override
    public boolean canMovePiece(Square newSquare){
        wasMoved = true;
        return super.canMovePiece(newSquare);
    }

    @Override
    public List<Square> getPossibleMoves(Board board) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();

        Square[][] squareBoard = board.getBoard();

        int xCoordinate = this.getPosition().getxCoordinate();
        int yCoordinate = this.getPosition().getyCoordinate();
        int color = this.getColor();
        if (color == 0) {
            //if the first move did not
            if (!wasMoved) {
                //we can move two square
                if (!squareBoard[yCoordinate+2][xCoordinate].isSquareOccupied()) {
                    legalMoves.add(squareBoard[yCoordinate+2][xCoordinate]);
                }
            }

            if (yCoordinate+1 < 8) {
                if (!squareBoard[yCoordinate+1][xCoordinate].isSquareOccupied()) {
                    legalMoves.add(squareBoard[yCoordinate+1][xCoordinate]);
                }
            }

            if (xCoordinate+1 < 8 && yCoordinate+1 < 8) {
                if (squareBoard[yCoordinate+1][xCoordinate+1].isSquareOccupied()) {
                    legalMoves.add(squareBoard[yCoordinate+1][xCoordinate+1]);
                }
            }

            if (xCoordinate-1 >= 0 && yCoordinate+1 < 8) {
                if (squareBoard[yCoordinate+1][xCoordinate-1].isSquareOccupied()) {
                    legalMoves.add(squareBoard[yCoordinate+1][xCoordinate-1]);
                }
            }
        }

        if (color == 1) {
            if (!wasMoved) {
                if (!squareBoard[yCoordinate-2][xCoordinate].isSquareOccupied()) {
                    legalMoves.add(squareBoard[yCoordinate-2][xCoordinate]);
                }
            }

            if (yCoordinate-1 >= 0) {
                if (!squareBoard[yCoordinate-1][xCoordinate].isSquareOccupied()) {
                    legalMoves.add(squareBoard[yCoordinate-1][xCoordinate]);
                }
            }

            if (xCoordinate+1 < 8 && yCoordinate-1 >= 0) {
                if (squareBoard[yCoordinate-1][xCoordinate+1].isSquareOccupied()) {
                    legalMoves.add(squareBoard[yCoordinate-1][xCoordinate+1]);
                }
            }

            if (xCoordinate-1 >= 0 && yCoordinate-1 >= 0) {
                if (squareBoard[yCoordinate-1][xCoordinate-1].isSquareOccupied()) {
                    legalMoves.add(squareBoard[yCoordinate-1][xCoordinate-1]);
                }
            }
        }

        return legalMoves;
    }


}
