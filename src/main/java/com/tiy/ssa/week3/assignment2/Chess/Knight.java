package com.tiy.ssa.week3.assignment2.Chess;

public class Knight extends PieceAbstract
{

    public Knight(Location location)
    {
        super(location, 4);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (where.getX() > 7 || where.getX() < 0 || where.getY() > 7 || where.getY() < 0)
            return false;
        if ((Math.abs(where.getX() - this.where().getX()) == 2) && (Math.abs(where.getY() - this.where().getY()) == 1))
            return true;
        if ((Math.abs(where.getX() - this.where().getX()) == 1) && (Math.abs(where.getY() - this.where().getY()) == 2))
            return true;
        return false;
    }
}
