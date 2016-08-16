package com.tiy.ssa.week3.assignment2.Chess;

public class Pawn extends PieceAbstract
{

    public Pawn(Location location)
    {
        super(location, 2);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (where.getX() > 7 || where.getX() < 0 || where.getY() > 7 || where.getY() < 0
                || (where.getX() - this.where().getX() != 0))
            return false;
        if (where.getY() - this.where().getY() == 1)
            return true;
        if (this.where().getY() == 1 && (where.getY() - this.where().getY()) == 2)
            return true;
        return false;
    }
}