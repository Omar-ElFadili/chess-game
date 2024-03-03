import org.chessGame.board.Board;
import org.chessGame.board.Square;
import org.chessGame.pieces.Pown;
import org.chessGame.pieces.Queen;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {
    @Test
    public void testGetPossibleMovesForQueenPieceWithNoObstacles() {
        // Créer un plateau simulé
        Square[][] boardArray = new Square[8][8];
        // Relier les carrés au plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Créer une reine sur la case (3, 3)
        Square queenSquare = boardArray[3][3];
        Queen queen = new Queen(0, queenSquare);

        // Test des mouvements possibles sans obstacles
        List<Square> possibleMoves = queen.getPossibleMoves(board);

        // Les mouvements possibles devraient inclure les cases verticales, horizontales et diagonales
        assertEquals(27, possibleMoves.size());
        // Vérifier la position correcte de la reine
        assertEquals(3, queen.getPosition().getxCoordinate());
        assertEquals(3, queen.getPosition().getyCoordinate());
    }

    @Test
    public void testGetPossibleMovesForQueenPieceWithObstacles() {
        // Créer un plateau simulé
        Square[][] boardArray = new Square[8][8];
        // Relier les carrés au plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Créer une reine sur la case (3, 3)
        Square queenSquare = boardArray[3][3];
        Queen queen = new Queen(0, queenSquare);
        // Ajouter des obstacles sur le plateau
        Square obstacle1 = boardArray[2][2];
        obstacle1.setPieceOccupied(new Queen(1, obstacle1));
        Square obstacle2 = boardArray[2][4];
        obstacle2.setPieceOccupied(new Queen(0, obstacle2));

        // Test des mouvements possibles avec des obstacles
        List<Square> possibleMoves = queen.getPossibleMoves(board);

        // Les mouvements possibles devraient exclure les cases obstruées
        assertEquals(22, possibleMoves.size());
        // Vérifier la position correcte de la reine
        assertEquals(3, queen.getPosition().getxCoordinate());
        assertEquals(3, queen.getPosition().getyCoordinate());
    }
}
