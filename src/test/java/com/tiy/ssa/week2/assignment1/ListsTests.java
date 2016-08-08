package com.tiy.ssa.week2.assignment1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListsTests
{
    @Test
    public void ListsMatchTest()
    {
        List<Object> one = new ArrayList<>();
        one.add("a");
        one.add("b");
        one.add(new Integer(5));
        one.add("this");
        one.add("that");

        List<Object> other = new ArrayList<>();
        other.add("z");
        other.add("y");
        other.add("that");
        other.add("this");
        other.add("f");
        other.add("");
        other.add(new Integer(5));


        List<Object> expected = new ArrayList<>();
        expected.add(new Integer(5));
        expected.add("this");
        expected.add("that");


        List<Object> matchedList = Lists.match(one, other);
        assertEquals(expected, matchedList);

        printList(matchedList);
    }

    @Test
    public void ListsDescendOrderTest()
    {
        List<String> list = new ArrayList<>();
        list.add("string");
        list.add("short");
        list.add("reallylongstring");
        list.add("longstring");
        list.add("string");

        List<String> expected = new ArrayList<>();
        expected.add("reallylongstring");
        expected.add("longstring");
        expected.add("string");
        expected.add("string");
        expected.add("short");

        List<String> descendedList = Lists.descendingBySize(list);
        assertEquals(expected, descendedList);

        printList(descendedList);
    }

    private <T> void printList(List<T> list)
    {
        System.out.print(list.get(0));
        for (int i = 1; i < list.size(); i++)
        {
            System.out.print(", " + list.get(i));
        }
        System.out.println();
    }
}
