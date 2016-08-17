package com.tiy.ssa.week3.assignment3;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class ShakespearReader
{
    WordCount counter = new WordCount();

    @Test
    public void justChecking() throws Exception
    {
        BufferedReader reader = null;
        String path = "C:/Users/admin/workspace/SSA_12_Week/src/main/java/resources/the-complete-works.txt";

        try
        {
            reader = Files.newBufferedReader(Paths.get(path), Charset.defaultCharset());

            String line;
            int i = 0;

            while (null != (line = reader.readLine()) && i++ < 100)
            {
                String[] words = line.split("\\W+");
                // System.out.println(line + " ");

                for (String word : words)
                    if (!word.isEmpty())
                        counter.addWord(word);

            }

        } catch (IOException iex)
        {
            System.err.println(iex);
        } finally
        {
            if (null != reader)
                reader.close();
        }
        System.out.println(counter.top(15));
        System.out.println(counter.bottom(15));
        assertTrue(this.counter.count("the") > 2);
    }

}
