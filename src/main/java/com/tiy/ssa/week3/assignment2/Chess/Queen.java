package com.tiy.ssa.week3.assignment2.Chess;

public class Queen extends PieceAbstract
{

    public Queen(Location location)
    {
        super(location, 8);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (where.getX() > 7 || where.getX() < 0 || where.getY() > 7 || where.getY() < 0)
            return false;
        if ((where.getX() - this.where().getX() == 0) || (where.getY() - this.where().getY() == 0))
            return true;
        if (Math.abs(where.getX() - this.where().getX()) == Math.abs(where.getY() - this.where().getY()))
            return true;
        
        return true;
    }
}