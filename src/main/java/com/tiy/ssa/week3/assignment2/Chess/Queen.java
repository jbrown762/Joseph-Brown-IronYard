package com.tiy.ssa.week3.assignment2.Chess;

public class Queen extends AbstractPiece
{

    public Queen(Location location)
    {
        super(location, 8);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (!isOutOfBounds(where))
        {
            double xDistance = Math.abs(where.getX() - this.where().getX());
            double yDistance = Math.abs(where.getY() - this.where().getY());
            
            if ((xDistance == 0) || (yDistance == 0))
                return true;
            if (xDistance == yDistance)
                return true;
        }
        return false;
    }
}