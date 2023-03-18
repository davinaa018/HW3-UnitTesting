package HW3;

import org.junit.Assert.*;

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

    
}
