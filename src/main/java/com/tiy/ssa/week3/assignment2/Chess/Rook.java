package com.tiy.ssa.week3.assignment2.Chess;

public class Rook extends PieceAbstract
{

    public Rook(Location location)
    {
        super(location, 6);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (where.getX() > 7 || where.getX() < 0 || where.getY() > 7 || where.getY() < 0)
            return false;
        if ((where.getX() - this.where().getX() == 0) || (where.getY() - this.where().getY() == 0))
            return true;
        return false;
    }
}