
import org.chessGame.board.Board;
import org.chessGame.board.Square;
import org.chessGame.pieces.Piece;
import org.chessGame.pieces.Rook;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RookTest {

    @Test
    public void getPossibleMovesForRookPiece() {
        // Create a mock board
        Square[][] boardArray = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, 0, null, i, j) {
                    @Override
                    public int getColor() {
                        return 0;
                    }

                    @Override
                    public boolean isSquareOccupied() {
                        return false;
                    }
                };
            }
        }
        Board board = new Board(boardArray);

        // Create a rook on square (3, 3)
        Square rookSquare = boardArray[3][3];
        Rook rook = new Rook(0, rookSquare);

        // Set up some pieces on the board
        Square pieceSquare1 = boardArray[3][5];
        pieceSquare1.setPieceOccupied(new Piece(1, pieceSquare1) {
            @Override
            public List<Square> getPossibleMoves(Board board) {
                return null;
            }
        });

        Square pieceSquare2 = boardArray[5][3];
        pieceSquare2.setPieceOccupied(new Piece(1, pieceSquare2) {
            @Override
            public List<Square> getPossibleMoves(Board board) {
                return null;
            }
        });

        // Test the possible moves
        List<Square> possibleMoves = rook.getPossibleMoves(board);

        // Expected possible moves: horizontal and vertical squares excluding current position
        assertEquals(14, possibleMoves.size());
        // Ensure the correct position for rook
        assertEquals(3, rook.getPosition().getxCoordinate()); // x-coordinate should remain the same
        assertEquals(3, rook.getPosition().getyCoordinate()); // y-coordinate should remain the same
    }
    @Test
    public void testGetPossibleMoves() {
        // Create a board
        Square[][] boardArray = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, 0, null, i, j) {
                    @Override
                    public int getColor() {
                        return 0;
                    }

                    @Override
                    public boolean isSquareOccupied() {
                        return false;
                    }
                };
            }
        }
        Board board = new Board(boardArray);

        // Create a rook on square (3, 3)
        Square rookSquare = boardArray[3][3];
        Rook rook = new Rook(0, rookSquare);

        // Test the possible moves
        rookSquare.setPieceOccupied(rook); // Place the rook on the board
        rookSquare.setxCoordinate(3); // Set x-coordinate
        rookSquare.setyCoordinate(3); // Set y-coordinate

        // Calculate possible moves
        rookSquare.setPieceOccupied(rook); // Place the rook on the board
        Board board1 = new Board(boardArray);
        Rook rook1 = new Rook(0, rookSquare);
        Rook rook2 = new Rook(1, rookSquare);

        assertEquals(14, rook1.getPossibleMoves(board1).size());
        assertEquals(3, rook.getPosition().getyCoordinate());
    }
}
