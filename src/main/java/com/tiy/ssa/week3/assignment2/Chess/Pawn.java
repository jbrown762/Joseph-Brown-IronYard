package com.tiy.ssa.week3.assignment2.Chess;

public class Pawn extends AbstractPiece
{

    public Pawn(Location location)
    {
        super(location, 2);
    }

    @Override
    public boolean canMove(Location where)
    {
        if (isOutOfBounds(where) || (where.getX() - this.where().getX() != 0))
            return false;
        if (where.getY() - this.where().getY() == 1)
            return true;
        if (this.where().getY() == 1 && (where.getY() - this.where().getY()) == 2)
            return true;
        return false;
    }
}