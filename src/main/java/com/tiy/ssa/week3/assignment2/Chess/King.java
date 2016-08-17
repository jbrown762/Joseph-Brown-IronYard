package com.tiy.ssa.week3.assignment2.Chess;

public class King extends PieceAbstract
{

    public King(Location location)
    {
        super(location, 10);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (!isOutOfBounds(where))
        {
            double xDistance = Math.abs(where.getX() - this.where().getX());
            double yDistance = Math.abs(where.getY() - this.where().getY());

            if ((xDistance == 1) && (yDistance == 0))
                return true;
            if ((xDistance == 0) && (yDistance == 1))
                return true;
            if ((xDistance == 1) && (yDistance == 1))
                return true;
            if (this.location.equals(where))
                return true;
        }
        return false;
    }

}
