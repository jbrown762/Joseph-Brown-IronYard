package com.tiy.ssa.week2.assignment1;

import java.util.ArrayList;
import java.util.List;

public class Lists
{
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
                    temp.add(t);
        return temp;
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