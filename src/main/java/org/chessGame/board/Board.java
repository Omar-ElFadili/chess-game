package org.chessGame.board;

import org.chessGame.exceptions.MoveException;

import java.util.List;

public class Board {
    private final Square[][] board;
    public Board(Square[][] board) {
        this.board = board;
    }

    public Square[][] getBoard() {
        return board;
    }
    public void move(Square currentSquare, Square targetSquare) throws MoveException {
        Piece piece = currentSquare.getPieceOccupied();
        List<Square> squares = piece.getPossibleMoves(this);
        if(squares.contains(targetSquare)){
            piece.setPosition(targetSquare);
            currentSquare.removePiece();
        }
        else{
            throw new MoveException("vous pouvez pas faire ce movement");
        }
    }
}
