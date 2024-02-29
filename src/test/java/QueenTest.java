import org.chessGame.board.Board;
import org.chessGame.board.Square;
import org.chessGame.pieces.Pown;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {
    @Test
    public void get(){
        // Create a mock board
        Square[][] boardArray = new Square[8][8];
        //linking squares to board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Create a rook on square (3, 3)
        Square pownSquare = boardArray[3][3];
        Pown pown = new Pown(1, pownSquare);

        // Set up some pieces on the board
        Square pieceSquare2 = boardArray[2][3];
        pieceSquare2.setPieceOccupied(new Pown(0, pieceSquare2));
        Square pieceSquare3 = boardArray[1][3];
        pieceSquare3.setPieceOccupied(new Pown(0, pieceSquare3));
        // Test the possible moves
        List<Square> possibleMoves = pown.getPossibleMoves(board);
        assertEquals(0, possibleMoves.size());
        // Ensure the correct position for rook
        assertEquals(3, pown.getPosition().getxCoordinate()); // x-coordinate should remain the same
        assertEquals(3, pown.getPosition().getyCoordinate()); // y-coordinate should remain the same
    }
}
