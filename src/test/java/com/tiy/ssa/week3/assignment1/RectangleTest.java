package com.tiy.ssa.week3.assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest
{

    @Test
    public void isA()
    {
//        Rectangle r;
//        r = new Square(5, 100105);
//        r.setHeight(2);
        recalc(new Square(5));
    }

    public void recalc(Rectangle r)
    {
        int width = r.getWidth();
        r.setHeight(6);
        assertEquals(6, r.getWidth());
       assertEquals(r.height * r.width, r.area(), .1);

    }

}
