import org.chessGame.board.Board;
import org.chessGame.board.Square;
import org.chessGame.pieces.King;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {
    @Test
    public void testGetPossibleMovesForKingPieceWithNoObstacles() {
        // Créer un plateau simulé
        Square[][] boardArray = new Square[8][8];
        // Relier les carrés au plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Créer un roi sur la case (3, 3)
        Square kingSquare = boardArray[3][3];
        King king = new King(0, kingSquare);

        // Test des mouvements possibles sans obstacles
        List<Square> possibleMoves = king.getPossibleMoves(board);

        // Les mouvements possibles devraient inclure les cases adjacentes
        assertEquals(8, possibleMoves.size());
        // Vérifier la position correcte du roi
        assertEquals(3, king.getPosition().getxCoordinate());
        assertEquals(3, king.getPosition().getyCoordinate());
    }

    @Test
    public void testGetPossibleMovesForKingPieceWithObstacles() {
        // Créer un plateau simulé
        Square[][] boardArray = new Square[8][8];
        // Relier les carrés au plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Créer un roi sur la case (3, 3)
        Square kingSquare = boardArray[3][3];
        King king = new King(0, kingSquare);
        // Ajouter des obstacles sur le plateau
        Square obstacle1 = boardArray[2][2];
        obstacle1.setPieceOccupied(new King(1, obstacle1));
        Square obstacle2 = boardArray[3][2];
        obstacle2.setPieceOccupied(new King(0, obstacle2));

        // Test des mouvements possibles avec des obstacles
        List<Square> possibleMoves = king.getPossibleMoves(board);

        // Les mouvements possibles devraient exclure les cases obstruées
        assertEquals(7, possibleMoves.size());
        // Vérifier la position correcte du roi
        assertEquals(3, king.getPosition().getxCoordinate());
        assertEquals(3, king.getPosition().getyCoordinate());
    }
}
