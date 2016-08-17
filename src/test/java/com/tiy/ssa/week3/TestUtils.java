package com.tiy.ssa.week3;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestUtils
{

    private TestUtils()
    {
    }

    public static <T> void membership(Collection<? extends T> expected, Collection<? extends T> actual)
    {
        assertTrue("", expected.containsAll(actual));
        assertEquals("", expected.size(), actual.size());
        
//        Collections.sort(expected);
//        Collections.sort(actual);
//        assertEquals("",  expected, actual);
        String s = "s";
        Object o = s;
        s = (String)o;
    }

    @Test
    public void test()
    {
        fail("Not yet implemented");
    }

}
