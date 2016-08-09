package com.tiy.ssa.week2.assignment1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lists
{
    private Lists()
    {
    }

    /**
     * @return a new List<T> containing only elements that are both in #one and #other (i.e. are "equal") - but just
     *         make sure that the returned List<T> is a logical set
     */
    public static <T> List<T> match(List<T> one, List<T> other)
    {
        List<T> temp = new ArrayList<>();
        for (T t : one)
            for (T q : other)
                if (t.equals(q))
                {
                    temp.add(t);
                    break;
                }
        return temp;
    }

    public static <T> List<T> match2(List<T> one, List<T> other)
    {
        Set<T> newSet = new HashSet<>();

        Set<T> oneSet = new HashSet<>();
        oneSet.addAll(one);
        Set<T> otherSet = new HashSet<>();
        otherSet.addAll(other);

        
        for (T t : oneSet)
            for (T q : otherSet)
            {
                if (t.equals(q) && !newSet.contains(t))
                    newSet.add(t);
                break;
            }
        
        List<T> newList = new ArrayList<>();

        newList.addAll(newSet);
        return newList;
    }

    /**
     * @return a new List, ordered by the length of the input strings in descending order
     */
    public static List<String> descendingBySize(List<String> input)
    {
        List<String> newList = new ArrayList<>();

        for (String str : input)
            newList.add(str);

        for (int i = 0; i < newList.size(); i++)
            for (int j = 0; j < newList.size() - 1; j++)
            {
                if (newList.get(j).length() < newList.get(j + 1).length())
                {
                    String temp = newList.get(j);
                    newList.set(j, newList.get(j + 1));
                    newList.set(j + 1, temp);
                }
            }
        return newList;
    }
}