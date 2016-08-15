package com.tiy.ssa.week3.assignment1;

public class Square extends Rectangle
{
    public Square(int side)
    {
        super(side, side);
    }

    @Override
    public int getHeight()
    {

        return super.getHeight();
    }
    
    @Override
    public void setHeight(int side)
    {
        super.setWidth(side);
        super.setHeight(side);
    }
    
    @Override
    public void setWidth(int side)
    {
        setWidth(side);
    }
    
    @Override
    public float area()
    {
        return this.height * this.height;
    }
}
