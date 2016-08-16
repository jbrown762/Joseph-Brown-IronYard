package com.tiy.ssa.week3.assignment2.Chess;

public class Bishop extends PieceAbstract
{

    public Bishop(Location location)
    {
        super(location, 4);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (where.getX() > 7 || where.getX() < 0 || where.getY() > 7 || where.getY() < 0)
            return false;
        if (Math.abs(where.getX() - this.where().getX()) == Math.abs(where.getY() - this.where().getY()))
            return true;
        return false;
    }
}