package com.tiy.ssa.week2.assignment1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HarambeTests
{

    List<Harambe> harambes = new ArrayList<>();
    
    @Test
    public void test1()
    {
        for (Harambe harambe : getBigGorillas())
        {
            System.out.print(harambe.toString() + " ");
            assertTrue(harambe.getWeight() > 500);
        }
    }

    @Test
    public void test2()
    {
        for (Harambe harambe : getSmallGorillas())
        {
            System.out.print(harambe.toString() + " ");
            assertTrue(!(harambe.getWeight() > 500));
        }
    }

    @Test
    public void test3()
    {
        removeBigGorillas();
        for (Harambe harambe : harambes)
        {
            System.out.print(harambe.toString() + " ");
            assertTrue(!(harambe.getWeight() > 500));
        }
    }

    @Test
    public void test4()
    {
        keepBigGorillas();
        for (Harambe harambe : harambes)
        {
            System.out.print(harambe.toString() + " ");
            assertTrue(!(harambe.getWeight() < 500));
        }
    }

    @Before
    public void setup()
    {
        this.harambes.add(new Harambe(400));
        this.harambes.add(new Harambe(15000));
        this.harambes.add(new Harambe(70));
        this.harambes.add(new Harambe(999));
    }

    @After
    public void clear()
    {
        this.harambes.clear();
        System.out.println();
    }

    // inclusive; return new list that meets criteria
    public List<Harambe> getBigGorillas()
    {
        List<Harambe> bigHarambes = new ArrayList<>();
        for (Harambe harambe : harambes)
        {
            if (harambe.getWeight() > 500)
                bigHarambes.add(harambe);
        }
        return bigHarambes;
    }

    // exclusive; return new list that doesn't meet criteria
    public List<Harambe> getSmallGorillas()
    {
        List<Harambe> smallHarambes = new ArrayList<>();
        for (Harambe harambe : harambes)
        {
            if (!(harambe.getWeight() > 500))
                smallHarambes.add(harambe);
        }
        return smallHarambes;
    }

    // inclusive; modify list
    public void removeBigGorillas()
    {
        for (Iterator<Harambe> iterator = harambes.iterator(); iterator.hasNext();)
        {
            Harambe harambe = (Harambe) iterator.next();
            if (harambe.getWeight() > 500)
                iterator.remove();
        }
    }

    // exclusive; modify list
    public void keepBigGorillas()
    {
        for (Iterator<Harambe> iterator = harambes.iterator(); iterator.hasNext();)
        {
            Harambe harambe = (Harambe) iterator.next();
            if (!(harambe.getWeight() > 500))
                iterator.remove();
        }

        List<Harambe> bigHarambes = new ArrayList<>();

        for (Harambe harambe : harambes)
        {
            if (!(harambe.getWeight() < 500))
                bigHarambes.add(harambe);
        }

        harambes = bigHarambes;
    }

}
