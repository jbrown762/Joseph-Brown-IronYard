package com.tiy.ssa.week3.assignment2.Chess;

public class Knight extends AbstractPiece
{

    public Knight(Location location)
    {
        super(location, 4);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (!isOutOfBounds(where))
        {
            double xDistance = Math.abs(where.getX() - this.where().getX());
            double yDistance = Math.abs(where.getY() - this.where().getY());

            if (xDistance == 2 && yDistance == 1)
                return true;
            if (xDistance == 1 && yDistance == 2)
                return true;
        }
        return false;
    }
}
