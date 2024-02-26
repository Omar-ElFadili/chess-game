package org.chessGame.board;

import org.chessGame.pieces.Piece;

import java.util.List;

public class Board {
    private final Square[][] board;
    public Board(Square[][] board) {
        this.board = board;
    }

    public Square[][] getBoard() {
        return board;
    }
}
