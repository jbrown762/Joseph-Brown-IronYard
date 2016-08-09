package com.tiy.ssa.week2.assignment2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.tiy.ssa.week2.assignment2.Foo;
import com.tiy.ssa.week2.assignment2.Goo;

public class FooGooTest
{

    @Test
    public void test()
    {
        Set<Foo> fooSet = new HashSet();
        Set<Goo> gooSet = new HashSet();
        Foo f = new Foo("test");
        Foo f2 = f;
     
        assertTrue(fooSet.add(new Foo("a")));
        assertTrue(fooSet.add(new Foo("a")));
        assertTrue(fooSet.add(f));
        assertFalse(fooSet.add(f));
        assertFalse(fooSet.add(f2));
        
        
        Goo g = new Goo("test");
        Goo g2 = g;
        assertTrue(gooSet.add(new Goo("a")));
        assertFalse(gooSet.add(new Goo("a")));
        assertTrue(gooSet.add(g));
        assertFalse(gooSet.add(g2));


    }
}
