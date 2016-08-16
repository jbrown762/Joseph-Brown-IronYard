package com.tiy.ssa.week3.assignment2;

import com.tiy.ssa.week3.assignment1.Rectangle;
import com.tiy.ssa.week3.assignment1.Shape;

public class Square2 implements Shape
{
    final Rectangle rectangle;

    public Square2(int dimension)
    {
        this.rectangle = new Rectangle(dimension, dimension);
    }

    @Override
    public void draw()
    {
        this.rectangle.draw();
    }

    @Override
    public float area()
    {
        
        return this.rectangle.area();
    }

    public void setDimension(int dimension)
    {
        this.rectangle.setHeight(dimension);
        this.rectangle.setWidth(dimension);
    }
    
    public int getDimension()
    {
        return this.rectangle.getHeight();
    }
}
