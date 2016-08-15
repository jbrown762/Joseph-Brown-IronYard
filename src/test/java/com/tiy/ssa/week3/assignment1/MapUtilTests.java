package com.tiy.ssa.week3.assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapUtilTests
{

    @Test
    public void test()
    {
        MapUtil<String, Integer> mapUtil = new MapUtil<>();
        mapUtil.add("a", 33);
        
        assertEquals(new Integer(33), mapUtil.mapHelper("a", 0));
        
        assertEquals(new Integer(5), mapUtil.mapHelper("b", 5));
    }

}
