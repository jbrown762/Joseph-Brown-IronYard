
package com.tiy.ssa.week3.assignment2.Chess;

/**
 * the board is a traditional 8 x 8 chessboard and is indexed at 0 so (0, 0) is the lower left hand corner, and (7, 7)
 * is the upper right hand corner Assume the pieces are all white and white 'started' at rows 0 & 1
 * 
 * @author thurston
 */
public interface Piece extends Comparable<Piece>
{

    Location where();

    boolean canMove(Location where);

    @Override
    String toString();

    @Override
    /**
     * chess pieces have an intrinsic 'value' ordered descending: King Queen Rook Bishop/Knight (tied) Pawn
     * 
     * in addition pieces have the same value can be valued by their location relative to the 'center' of the board (3,
     * 3) . . . (4, 4)
     */
    public int compareTo(Piece o);

    /**
     * take into account intrinsic value and location
     * 
     * @param other
     * @return
     */
    @Override
    boolean equals(Object other);

    @Override
    public int hashCode();

    int getValue();

}