package org.chessGame.board;

import org.chessGame.pieces.Piece;

public abstract class Square {
    private Board board;
    private final int color;
    private Piece pieceOccupied;
    boolean isSquareOccupied;
    private int xCoordinate;
    private int yCoordinate;

    public Square(Board board, int color, Piece pieceOccupied, int xCoordinate, int yCoordinate) {
        this.board = board;
        this.color = color;
        this.pieceOccupied = pieceOccupied;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getColor() {
        return color;
    }

    public Piece getPieceOccupied() {
        return pieceOccupied;
    }

    public void setPieceOccupied(Piece pieceOccupied) {
        this.pieceOccupied = pieceOccupied;
    }

    public boolean isSquareOccupied() {
        return (this.pieceOccupied != null);
    }

    public void setSquareOccupied(boolean squareOccupied) {
        isSquareOccupied = squareOccupied;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void changePiece(Piece piece){
        this.pieceOccupied = piece;
    }
    public void putPiece(Piece piece){
        this.pieceOccupied = piece;
        piece.setPosition(this);
    }
    public Piece removePiece(){
        Piece currentPiece = pieceOccupied;
        this.pieceOccupied = null;
        return currentPiece;
    }
}
