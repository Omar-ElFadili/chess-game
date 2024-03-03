import org.chessGame.board.Board;
import org.chessGame.board.Square;
import org.chessGame.pieces.Bishop;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BishopTest {

    @Test
    public void testGetPossibleMovesForBishopPieceWithNoObstacles() {
        // Créer un plateau simulé
        Square[][] boardArray = new Square[8][8];
        // Relier les carrés au plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Créer un fou sur la case (3, 3)
        Square bishopSquare = boardArray[3][3];
        Bishop bishop = new Bishop(0, bishopSquare);

        // Test des mouvements possibles sans obstacles
        List<Square> possibleMoves = bishop.getPossibleMoves(board);

        // Les mouvements possibles devraient inclure toutes les cases diagonales
        assertEquals(13, possibleMoves.size());
        // Vérifier la position correcte du fou
        assertEquals(3, bishop.getPosition().getxCoordinate());
        assertEquals(3, bishop.getPosition().getyCoordinate());
    }

    @Test
    public void testGetPossibleMovesForBishopPieceWithObstacles() {
        // Créer un plateau simulé
        Square[][] boardArray = new Square[8][8];
        // Relier les carrés au plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = new Square(null, null, i, j);
            }
        }
        Board board = new Board(boardArray);
        // Créer un fou sur la case (3, 3)
        Square bishopSquare = boardArray[3][3];
        Bishop bishop = new Bishop(0, bishopSquare);
        // Ajouter des obstacles sur le plateau
        Square obstacle1 = boardArray[1][1];
        obstacle1.setPieceOccupied(new Bishop(1, obstacle1));
        Square obstacle2 = boardArray[5][5];
        obstacle2.setPieceOccupied(new Bishop(0, obstacle2));

        // Test des mouvements possibles avec des obstacles
        List<Square> possibleMoves = bishop.getPossibleMoves(board);

        // Les mouvements possibles devraient exclure les cases obstruées
        assertEquals(9, possibleMoves.size());
        // Vérifier la position correcte du fou
        assertEquals(3, bishop.getPosition().getxCoordinate());
        assertEquals(3, bishop.getPosition().getyCoordinate());
    }
}
