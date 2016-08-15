package com.tiy.ssa.week3.assignment1;

public class Rectangle implements Shape
{

    protected int height, width; // protected means both package private + subclasses

    public Rectangle(int height, int width)
    {
        this.height = height;
        this.width = width;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }

    @Override
    public void draw()
    {

    }

    @Override
    public float area()
    {
        return getHeight() * getWidth();
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }
}
