
import org.chessGame.board.Board;
import org.chessGame.board.Square;
import org.chessGame.pieces.Rook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RookTest {

    @Test
    @DisplayName("this test gives number of test when we have rook with same color")
    public void getPossibleMovesForRookPieceSameColor() {
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
        Square rookSquare = boardArray[3][3];
        Rook rook = new Rook(0, rookSquare);
        // Set up some pieces on the board
        Square pieceSquare2 = boardArray[3][4];
        pieceSquare2.setPieceOccupied(new Rook(0, pieceSquare2));
        Square pieceSquare3 = boardArray[4][3];

        pieceSquare3.setPieceOccupied(new Rook(0, pieceSquare3));

        // Test the possible moves
        List<Square> possibleMoves = rook.getPossibleMoves(board);

        // Expected possible moves: horizontal and vertical squares excluding current position
        assertEquals(6, possibleMoves.size());
        // Ensure the correct position for rook
        assertEquals(3, rook.getPosition().getxCoordinate()); // x-coordinate should remain the same
        assertEquals(3, rook.getPosition().getyCoordinate()); // y-coordinate should remain the same
    }
    @Test
    @DisplayName("this test gives number of test when we have rook with same color")
    public void getPossibleMovesForRookPieceDiffColor() {
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
        Square rookSquare = boardArray[3][3];
        Rook rook = new Rook(0, rookSquare);
        // Set up some pieces on the board
        Square pieceSquare2 = boardArray[3][4];
        pieceSquare2.setPieceOccupied(new Rook(1, pieceSquare2));
        Square pieceSquare3 = boardArray[4][3];
        pieceSquare3.setPieceOccupied(new Rook(1, pieceSquare3));

        // Test the possible moves
        List<Square> possibleMoves = rook.getPossibleMoves(board);

        // Expected possible moves: horizontal and vertical squares excluding current position
        assertEquals(8, possibleMoves.size());
        // Ensure the correct position for rook
        assertEquals(3, rook.getPosition().getxCoordinate()); // x-coordinate should remain the same
        assertEquals(3, rook.getPosition().getyCoordinate()); // y-coordinate should remain the same
    }
    @Test
    @DisplayName("this test gives number of test when we have rook with same color")
    public void getPossibleMovesForRookPieceInCorner() {
        // Create a mock board
        Square[][] boardArray = new Square[8][8];
        //linking squares to board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Create a rook on square (7, 7)
        Square rookSquare = boardArray[7][7];
        Rook rook = new Rook(0, rookSquare);
        // Set up some pieces on the board
        Square pieceSquare2 = boardArray[3][4];
        pieceSquare2.setPieceOccupied(new Rook(0, pieceSquare2));
        Square pieceSquare3 = boardArray[4][3];
        pieceSquare3.setPieceOccupied(new Rook(0, pieceSquare3));

        // Test the possible moves
        List<Square> possibleMoves = rook.getPossibleMoves(board);

        // Expected possible moves: horizontal and vertical squares excluding current position
        assertEquals(14, possibleMoves.size());
        // Ensure the correct position for rook
        assertEquals(7, rook.getPosition().getxCoordinate()); // x-coordinate should remain the same
        assertEquals(7, rook.getPosition().getyCoordinate()); // y-coordinate should remain the same
    }

}
