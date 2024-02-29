package org.chessGame.board;

public class Board {
    private final Square[][] board;
    public Board(Square[][] board) {
        this.board = board;
    }

    public Square[][] getBoard() {
        return board;
    }
}
