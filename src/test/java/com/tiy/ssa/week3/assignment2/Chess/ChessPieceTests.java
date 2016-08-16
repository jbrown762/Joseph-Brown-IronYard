package com.tiy.ssa.week3.assignment2.Chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessPieceTests
{
    @Test
    public void test()
    {
        Piece king = new King(new Location(1, 1));
        assertTrue(king.canMove(new Location(1, 1)));
        assertTrue(king.canMove(new Location(1, 2)));
        assertFalse(king.canMove(new Location(3, 3)));
        assertFalse(king.canMove(new Location(-1, -1)));
        assertEquals(new Location(1, 1), king.where());
        System.out.println(king);
    
        Piece queen = new Queen(new Location(7, 1));
        assertTrue(queen.canMove(new Location(0, 1)));
        assertTrue(queen.canMove(new Location(7, 7)));
        assertTrue(queen.canMove(new Location(3, 5)));
        assertTrue(queen.canMove(new Location(7, 0)));
        assertFalse(queen.canMove(new Location(7, -1)));
        assertEquals(new Location(7, 1), queen.where());
        System.out.println(queen);
     
        Piece rook = new Rook(new Location(4, 4));
        assertTrue(rook.canMove(new Location(7, 4)));
        assertTrue(rook.canMove(new Location(4, 0)));
        assertFalse(rook.canMove(new Location(3, 3)));
        assertEquals(new Location(4, 4), rook.where());
        System.out.println(rook);
        
        Piece bishop = new Bishop(new Location(3, 3));
        assertTrue(bishop.canMove(new Location(1, 1)));
        assertTrue(bishop.canMove(new Location(5, 1)));
        System.out.println(bishop);

        Piece knight = new Knight(new Location(3, 3));
        assertTrue(knight.canMove(new Location(2, 5)));
        assertFalse(knight.canMove(new Location(3, 5)));
        System.out.println(knight);


        Piece pawn = new Pawn(new Location(5, 1));
        assertTrue(pawn.canMove(new Location(5, 2)));
        assertTrue(pawn.canMove(new Location(5, 3)));
        assertFalse(pawn.canMove(new Location(5, 0)));
        assertFalse(pawn.canMove(new Location(1, 2)));
        System.out.println(pawn);


        assertEquals(1, king.compareTo(queen));
        assertEquals(-1, rook.compareTo(king));
        assertEquals(0, bishop.compareTo(knight));
        assertEquals(-1, pawn.compareTo(bishop));
    }
}
