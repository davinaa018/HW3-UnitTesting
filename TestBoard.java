package HW3;


import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestBoard {
    private Board board;
    private Player player1;
    private Player player2;

    @Before
    public void setUp(){
        board = new Board();
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
    }

    @Test
    public void testSize(){
        assertEquals(15, board.size());
    }

    @Test 
    public void testClear(){
        board.placeStone(0, 0, player1);
        assertFalse(board.isEmpty(0, 0));
        board.clear();
        assertTrue(board.isEmpty(0, 0));
    }

    @Test 
    public void testIsFull(){
        assertFalse(board.isFull());
        for (int row = 0; row < board.size(); row++){
            for (int col = 0; col < board.size(); col++){
                board.placeStone(row, col, new Player("Player 1"));
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testPlaceStone(){
       board.placeStone(0, 0, player1);
       assertTrue(board.isOccupiedBy(0, 0, player1));
       assertFalse(board.isOccupiedBy(0, 0, player2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlaceStoneOnOccupiedPlace() {
        board.placeStone(1, 2, player1);
        board.placeStone(1, 2, player2);
    }

    @Test
    public void testIsEmpty(){
        assertTrue(board.isEmpty(0, 0));
        board.placeStone(0, 0, player1);
        assertFalse(board.isEmpty(0, 0));
    }

    @Test
    public void testIsOccupied(){
        assertFalse(board.isOccupied(0, 0));
        board.placeStone(0, 0, player1);
        assertTrue(board.isOccupied(0, 0));
    }

    @Test
    public void testIsOccupiedBy(){
        assertFalse(board.isOccupiedBy(0, 0, player1));
        board.placeStone(0, 0, player1);
        assertTrue(board.isOccupiedBy(0, 0, player1));
        assertFalse(board.isOccupiedBy(0, 0, player2));
    }

    @Test
    public void testPlayerAt(){
        assertNull( board.playerAt(0, 0));
        board.placeStone(0, 0, player2);
        // assertEquals(player2, board.playerAt(0, 0));
    }

    @Test
    public void testHorizontalWin(){
        assertFalse(board.isWonBy(player1));
        assertFalse(board.isWonBy(player2));
    
        // Horizontal Stones for player1 
        board.placeStone(0, 0, player1);
        board.placeStone(1, 0, player1);
        board.placeStone(2, 0, player1);
        board.placeStone(3, 0, player1);
        board.placeStone(4, 0, player1);      
        assertTrue(board.isWonBy(player1));
        assertFalse(board.isWonBy(player2));
        board.clear();

        // Horizontal Stones for player2
        board.placeStone(0, 1, player2);
        board.placeStone(1, 1, player2);
        board.placeStone(2, 1, player2);
        board.placeStone(3, 1, player2);
        board.placeStone(4, 1, player2);
        assertTrue(board.isWonBy(player2));
        assertFalse(board.isWonBy(player1));
    }

    @Test
    public void testVerticalWin(){
        assertFalse(board.isWonBy(player1));
        assertFalse(board.isWonBy(player2));
    
        // Vertical Stones for player1 
        board.placeStone(0, 0, player1);
        board.placeStone(0, 1, player1);
        board.placeStone(0, 2, player1);
        board.placeStone(0, 3, player1);
        board.placeStone(0, 4, player1);      
        assertTrue(board.isWonBy(player1));
        assertFalse(board.isWonBy(player2));

        board.clear();

        // Vertical Stones for player2
        board.placeStone(1, 0, player2);
        board.placeStone(1, 1, player2);
        board.placeStone(1, 2, player2);
        board.placeStone(1, 3, player2);
        board.placeStone(1, 4, player2);
        assertTrue(board.isWonBy(player2));
        assertFalse(board.isWonBy(player1));
    }

    @Test
    public void testDiagonalWin(){
        assertFalse(board.isWonBy(player1));
        assertFalse(board.isWonBy(player2));
    
        // Diagonal Stones for player1 
        board.placeStone(0, 0, player1);
        board.placeStone(1, 1, player1);
        board.placeStone(2, 2, player1);
        board.placeStone(3, 3, player1);
        board.placeStone(4, 4, player1);      
        assertTrue(board.isWonBy(player1));
        assertFalse(board.isWonBy(player2));

        board.clear();

        // Diagonal Stones for player2
        board.placeStone(0, 0, player2);
        board.placeStone(1, 1, player2);
        board.placeStone(2, 2, player2);
        board.placeStone(3, 3, player2);
        board.placeStone(4, 4, player2);      
        assertTrue(board.isWonBy(player2));
        assertFalse(board.isWonBy(player1));
    }

    @Test
    public void testReverseDiagonalWin(){
        assertFalse(board.isWonBy(player1));
        assertFalse(board.isWonBy(player2));
    
        // Reverse Diagonal Stones for player1 
        board.placeStone(0, 4, player1);
        board.placeStone(1, 3, player1);
        board.placeStone(2, 2, player1);
        board.placeStone(3, 1, player1);
        board.placeStone(4, 0, player1);      
        assertTrue(board.isWonBy(player1));
        assertFalse(board.isWonBy(player2));

        board.clear();

        // Reverse Diagonal Stones for player2
        board.placeStone(0, 4, player2);
        board.placeStone(1, 3, player2);
        board.placeStone(2, 2, player2);
        board.placeStone(3, 1, player2);
        board.placeStone(4, 0, player2);      
        assertTrue(board.isWonBy(player2));
        assertFalse(board.isWonBy(player1));
    }
    

    
}
