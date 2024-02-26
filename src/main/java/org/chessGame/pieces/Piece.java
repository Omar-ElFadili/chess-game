package org.chessGame.pieces;

import org.chessGame.board.Board;
import org.chessGame.board.Square;

import java.util.LinkedList;
import java.util.List;

public abstract class Piece {
    private final int color;
    private Square currentSquare;

    public Piece(int color, Square currentSquare) {
        this.color = color;
        this.currentSquare = currentSquare;
    }

    public boolean canMovePiece(Square squareGoal){
        Piece pieceOccupied = squareGoal.getPieceOccupied();
        if(pieceOccupied != null){
            if(pieceOccupied.getColor() == this.getColor()){
                return false;
            }
            else{
                squareGoal.changePiece(this);
            }
        }
        currentSquare.removePiece();
        this.currentSquare = squareGoal;
        currentSquare.putPiece(this);
        return true;
    }

    public Square getPosition(){
        return this.currentSquare;
    }
    public void setPosition(Square newSquarePosition){
        this.currentSquare = newSquarePosition;
    }

    public int getColor() {
        return color;
    }
    public int[] getLinearOccupiedSquares(Square[][] board, int x, int y){
        int lastXright = 7;
        int lastXleft = 0;
        int lastYup = 0;
        int lastYdown = 7;
        //pour les squares existent vertical au-dessus de position de piece x,y
        for (int i = 0; i < y; i++) {
            if (board[i][x].isSquareOccupied()) {
                if (board[i][x].getPieceOccupied().getColor() != this.color) {
                    lastYup = i;
                } else lastYup = i + 1;
            }
        }
        //pour les squares existent vertical au-dessous de position de piece x,y
        for (int i = 7; i > y; i--) {
            if (board[i][x].isSquareOccupied()) {
                if (board[i][x].getPieceOccupied().getColor() != this.color) {
                    lastYdown = i;
                } else lastYdown = i - 1;
            }
        }
        //pour les squares existent horizontal à gauche de position de piece x,y
        for (int i = 0; i < x; i++) {
            if (board[y][i].isSquareOccupied()) {
                if (board[y][i].getPieceOccupied().getColor() != this.color) {
                    lastXleft = i;
                } else lastXleft = i + 1;
            }
        }
        //pour les squares existent horizontal à droite de position de piece x,y
        for (int i = 7; i > x; i--) {
            if (board[y][i].isSquareOccupied()) {
                if (board[y][i].getPieceOccupied().getColor() != this.color) {
                    lastXright = i;
                } else lastXright = i - 1;
            }
        }

        int[] occups = {lastYup, lastYdown, lastXleft, lastXright};

        return occups;
    }
    //this function return all diagonal occupied squares for a specific x, y coordinate
    public List<Square> getDiagonalOccupations(Square[][] board, int x, int y){
        LinkedList<Square> diagOccup = new LinkedList<Square>();

        int xNorthWest = x - 1;
        int xSouthWest = x - 1;
        int xNorthEst = x + 1;
        int xSouthEst = x + 1;
        int yNorthWest = y - 1;
        int ySouthWest = y + 1;
        int yNorthEst = y - 1;
        int ySouthEst = y + 1;

        while (xNorthWest >= 0 && yNorthWest >= 0) {
            if (board[yNorthWest][xNorthWest].isSquareOccupied()) {
                if (board[yNorthWest][xNorthWest].getPieceOccupied().getColor() == this.color) {
                    break;
                } else {
                    diagOccup.add(board[yNorthWest][xNorthWest]);
                    break;
                }
            } else {
                diagOccup.add(board[yNorthWest][xNorthWest]);
                yNorthWest--;
                xNorthWest--;
            }
        }

        while (xSouthWest >= 0 && ySouthWest < 8) {
            if (board[ySouthWest][xSouthWest].isSquareOccupied()) {
                if (board[ySouthWest][xSouthWest].getPieceOccupied().getColor() == this.color) {
                    break;
                } else {
                    diagOccup.add(board[ySouthWest][xSouthWest]);
                    break;
                }
            } else {
                diagOccup.add(board[ySouthWest][xSouthWest]);
                ySouthWest++;
                xSouthWest--;
            }
        }

        while (xSouthEst < 8 && ySouthEst < 8) {
            if (board[ySouthEst][xSouthEst].isSquareOccupied()) {
                if (board[ySouthEst][xSouthEst].getPieceOccupied().getColor() == this.color) {
                    break;
                } else {
                    diagOccup.add(board[ySouthEst][xSouthEst]);
                    break;
                }
            } else {
                diagOccup.add(board[ySouthEst][xSouthEst]);
                ySouthEst++;
                xSouthEst++;
            }
        }

        while (xNorthEst < 8 && yNorthEst >= 0) {
            if (board[yNorthEst][xNorthEst].isSquareOccupied()) {
                if (board[yNorthEst][xNorthEst].getPieceOccupied().getColor() == this.color) {
                    break;
                } else {
                    diagOccup.add(board[yNorthEst][xNorthEst]);
                    break;
                }
            } else {
                diagOccup.add(board[yNorthEst][xNorthEst]);
                yNorthEst--;
                xNorthEst++;
            }
        }

        return diagOccup;
    }
    public abstract List<Square> getPossibleMoves(Board board);
}
