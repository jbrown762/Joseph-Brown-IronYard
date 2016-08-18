package com.tiy.ssa.week3.assignment2.Chess;

public abstract class PieceAbstract implements Piece
{
    final Location location;
    final int value;

    protected PieceAbstract(Location location, int value)
    {
        this.location = location;
        this.value = value;
    }

    @Override
    public Location where()
    {
        return location;
    }

    @Override
    public int getValue()
    {
        return value;
    }

    @Override
    public int compareTo(Piece o)
    {
        if (this.getValue() != o.getValue())
            if (this.getValue() > o.getValue())
                return 1;
            else
                return -1;

        double piece1DistanceToCenter = Math.abs(this.location.getX() - 3.5) + Math.abs(this.location.getY() - 3.5);
        double piece2DistanceToCenter = Math.abs(o.where().getX() - 3.5) + Math.abs(o.where().getY() - 3.5);

        if (piece1DistanceToCenter < piece2DistanceToCenter)
            return 1;
        else if (piece1DistanceToCenter > piece2DistanceToCenter)
            return -1;
        return 0;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PieceAbstract other = (PieceAbstract) obj;
        if (location == null)
        {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (value != other.value)
            return false;
        return true;
    }
    
    @Override
    public String toString()
    {
        return "(" + location.getX() + ", " + location.getY() + ")";
    }
    
    public boolean isOutOfBounds(Location where)
    {
        if (where.getX() > 7 || where.getX() < 0 || where.getY() > 7 || where.getY() < 0)
            return true;
        if(where().equals(where))
            return true;
        return false;
    }

}