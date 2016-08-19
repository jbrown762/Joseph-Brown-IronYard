package com.tiy.ssa.week3.assignment4.Trie;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class TrieTests
{
    Scanner in;
    String filePath;

    @Test
    public void test() throws FileNotFoundException
    {
        Trie t = new Trie();
        filePath = "C:/Users/admin/workspace/SSA_12_Week/src/main/java/resources/corncob_lowercase.txt";
        in = new Scanner(new File(filePath));

        while (in.hasNext())
        {
            String currentWord = in.next();
            t.addWord(currentWord);
        }

        assertTrue(t.contains("apple"));
        assertTrue(t.contains("computer"));
        assertTrue(t.contains("key"));
        assertTrue(t.remove("apple"));

        t.suggest("286");
        //t.suggest("3");

        t.clear();
        assertFalse(t.contains("can"));

    }

}
