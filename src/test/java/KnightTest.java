import org.chessGame.board.Board;
import org.chessGame.board.Square;
import org.chessGame.pieces.Knight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {
    @Test
    public void testGetPossibleMovesForKnightPieceWithNoObstacles() {
        // Créer un plateau simulé
        Square[][] boardArray = new Square[8][8];
        // Relier les carrés au plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Créer un cavalier sur la case (3, 3)
        Square knightSquare = boardArray[3][3];
        Knight knight = new Knight(0, knightSquare);

        // Test des mouvements possibles sans obstacles
        List<Square> possibleMoves = knight.getPossibleMoves(board);

        // Les mouvements possibles devraient inclure les cases en forme de L
        assertEquals(8, possibleMoves.size());
        // Vérifier la position correcte du cavalier
        assertEquals(3, knight.getPosition().getxCoordinate());
        assertEquals(3, knight.getPosition().getyCoordinate());
    }

    @Test
    public void testGetPossibleMovesForKnightPieceWithObstacles() {
        // Créer un plateau simulé
        Square[][] boardArray = new Square[8][8];
        // Relier les carrés au plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Créer un cavalier sur la case (3, 3)
        Square knightSquare = boardArray[3][3];
        Knight knight = new Knight(0, knightSquare);
        // Ajouter des obstacles sur le plateau
        Square obstacle1 = boardArray[1][2];
        obstacle1.setPieceOccupied(new Knight(1, obstacle1));
        Square obstacle2 = boardArray[2][5];
        obstacle2.setPieceOccupied(new Knight(0, obstacle2));

        // Test des mouvements possibles avec des obstacles
        List<Square> possibleMoves = knight.getPossibleMoves(board);

        // Les mouvements possibles devraient exclure les cases obstruées
        assertEquals(8, possibleMoves.size());
        // Vérifier la position correcte du cavalier
        assertEquals(3, knight.getPosition().getxCoordinate());
        assertEquals(3, knight.getPosition().getyCoordinate());
    }
}
