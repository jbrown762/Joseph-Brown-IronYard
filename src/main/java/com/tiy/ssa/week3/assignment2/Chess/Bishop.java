package com.tiy.ssa.week3.assignment2.Chess;

public class Bishop extends AbstractPiece
{

    public Bishop(Location location)
    {
        super(location, 4);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (!isOutOfBounds(where))
            if (Math.abs(where.getX() - this.where().getX()) == Math.abs(where.getY() - this.where().getY()))
                return true;
        return false;
    }
}