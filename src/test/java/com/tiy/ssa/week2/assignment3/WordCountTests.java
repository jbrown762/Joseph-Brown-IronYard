package com.tiy.ssa.week2.assignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WordCountTests
{
    static String SOURCE = "Alexander Augustus Norman Dudley Jerry Pentland, MC, DFC, AFC (5 August 1894 – 3 November 1983) was an Australian fighter ace in World War I. Born in Maitland, New South Wales, he commenced service as a Lighthorseman with the Australian Imperial Force in 1915, and saw action at Gallipoli. He transferred to the Royal Flying Corps the following year, rising to captain. Credited with twenty-three aerial victories, Pentland became the fifth highest-scoring Australian ace of the war, after Robert Little, Stan Dallas, Harry Cobby and Roy King. He was awarded the Military Cross in January 1918 for conspicuous gallantry and devotion to duty on a mission attacking an aerodrome behind enemy lines, and the Distinguished Flying Cross that August for engaging four hostile aircraft single-handedly.";
    WordCount wordCount = new WordCount();

    @Before
    public void parse()
    {
        this.wordCount = new WordCount();
        String[] words = SOURCE.split("\\W+"); // should take care of punctuation and other special characters

        for (String word : words)
            this.wordCount.addWord(word);
    }

    @Test
    public void count()
    {
        parse();
        assertEquals(127, wordCount.count(SOURCE));
    }

    @Test
    public void topWords()
    {
        List<String> list = new ArrayList<>();
        list.add("the");
        list.add("in");
        list.add("and");
        list.add("australian");

        parse();
        System.out.println("TOP WORDS: " + print(wordCount.top(4)) + "\n");// + wordCount.getWordCount() + "\n");
        assertEquals(list, wordCount.top(4));
    }

    @Test
    public void bottomWords()
    {
        List<String> list = new ArrayList<>();
        list.add("alexander");
        list.add("augustus");
        list.add("norman");
        list.add("dudley");

        parse();
        System.out.println("BOTTOM WORDS: " + print(wordCount.bottom(4)) + "\n");// + wordCount.getWordCount() + "\n");
        assertEquals(list, wordCount.bottom(4));
    }

    @Test
    public void source()
    {
        parse();
        // assertEquals(SOURCE.toLowerCase().split("\\W+").length, wordCount.source().trim().split("\\W+").length);
        // assertTrue(SOURCE.toLowerCase().split("\\W+").equals(wordCount.source().toLowerCase().split("\\W+")));

        String[] a = SOURCE.toLowerCase().split("\\W+");
        String[] b = wordCount.source().toLowerCase().split("\\W+");
        for (int i = 0; i < a.length; i++)
            assertTrue(a[i].equals(b[i]));

        // System.out.println("SOURCE: " + wordCount.source());
    }

    private String print(List<String> list)
    {
        String s = "";
        s += list.get(0);
        for (int i = 1; i < list.size(); i++)
            s += ", " + list.get(i);
        return s;
    }
}