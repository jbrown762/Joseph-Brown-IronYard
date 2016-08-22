package com.tiy.ssa.weekone.assignmentfour;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class KnightTest
{

    ArrayList<Location> path = new ArrayList<>();

    @Test
    public void test()
    {
        Knight k = new Knight(new Location(15, 10));

        while (true)
        {
            Location previousLocation = k.current;

            path.add(k.move());

            // check if move was legal
            assertTrue(k.isLegal(previousLocation));

            if (k.isHome())
                break;
        }

        assertEquals("", new Location(15, 10), path.get(path.size() - 1));

        verify(k);
    }

    public void verify(Knight k)
    {
        // check if the Knight ever backtracked
        for (int i = 0; i < path.size() / 2; i++)
            assertFalse(path.get(i).equals(path.get(i + 2)));

        // check if total moves are no more than 4
        //System.out.println();
        assertTrue(path.size() < 5);
    }
}