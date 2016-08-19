package com.tiy.ssa.week3.assignment4.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Letter
{
    char letter;
    final Map<Character, Letter> alphabet = new HashMap<>();
    boolean endOfWord = false;

    public Letter(char letter)
    {
        this.letter = letter;
    }

    public char getLetter()
    {
        return letter;
    }

    public void add(String word)
    {
        if (word.length() > 0)
        {
            // System.out.println(word);

            Letter firstChar = new Letter(word.charAt(0));

            if (alphabet.get(word.charAt(0)) == null)
                alphabet.put(word.charAt(0), firstChar);

            alphabet.get(word.charAt(0)).add(word.substring(1));
        } else
            endOfWord = true;
    }

    public String getWordCheckString(String word)
    {
        if (word.length() > 0)
        {
            if (alphabet.get(word.charAt(0)) != null)
            {
                String wordCheck = "" + alphabet.get(word.charAt(0)).letter;
                return wordCheck += alphabet.get(word.charAt(0)).getWordCheckString(word.substring(1));
            }
        } else if (endOfWord)
            return "|";
        return "";
    }

    public void remove(String word)
    {
        // System.out.println(word);
        if (word.length() == 0)
        {
            endOfWord = false;
           // System.out.println(letter);
        } else{
            System.out.println(word);
            alphabet.get(word.charAt(0)).remove(word.substring(1));
        }
        // if (word.length() > 2)
        // {
        // alphabet.get(word.charAt(0)).remove(word.substring(1, word.length()));
        // }
        //
        // if (alphabet.get(word.charAt(0)).nextLettersSize() == 0)
        // alphabet.remove(alphabet.get(word.substring(1, word.length())));

        // if(alphabet.get(word.charAt(0)).nextLettersSize() < 1)
        // alphabet.remove(alphabet.get(word.substring(1,word.length())));

        // if (alphabet.get(word.indexOf(0)).nextLettersSize() > 1)
        // alphabet.get(word.indexOf(0)).remove(word.substring(1, word.length()));
        // else
        // endOfWord = false;
        // alphabet.remove(alphabet.get(word.indexOf(0)));
    }

    public int nextLettersSize()
    {
        return alphabet.size();
    }

    public ArrayList<String> suggest(String digits, String word)
    {
        String[] digitArray =
        { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> list = new ArrayList<>();
        String currentWord = word;
        word += letter;

        if (digits.length() > 0)
        {
            int nextDigit = Character.getNumericValue(digits.charAt(0));
            String digitLetters = digitArray[nextDigit];

            for (int i = 0; i < digitLetters.length(); i++)
            {
                word = currentWord;
                char nextChar = digitLetters.charAt(i);
                if (digits.length() != 1)
                    word += nextChar;

                if (alphabet.get(nextChar) != null)
                    list.addAll(alphabet.get(nextChar).suggest(digits.substring(1), word));

            }
        } else
        {
            if (endOfWord)
            {
                System.out.println(word);
                list.add(word);
            }
            for (Entry<Character, Letter> e : alphabet.entrySet())
                list.addAll(e.getValue().suggest("", word));
            

        }

        return list;
    }
}
