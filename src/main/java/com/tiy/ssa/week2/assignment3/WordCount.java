package com.tiy.ssa.week2.assignment3;

import java.util.ArrayList;
import java.util.List;

public class WordCount
{
    private List<String> wordsList = new ArrayList<>();
    private List<Integer> topOrBottomWordsCount = new ArrayList<>();

    /**
     * 
     * @param word
     *            callers are responsible for ensuring <code>word</code> <br>
     *            is an actual word, parsing is done by the caller
     */
    public void addWord(String word)
    {
        // if (!wordsList.contains(word.toLowerCase()))
        wordsList.add(word.toLowerCase());
    }

    /**
     * @return a <em>case-insensitive</em> count of <code>word</word> in the words added to this instance
     */
    public int count(String word)
    {
        return wordsList.size();
    }

    /**
     *
     * @param many
     * @return a logical set of words ordered in descending popularity order, so top <code>many</code> words
     */
    public List<String> top(int many)
    {
        return getWordsList(many, "top");
    }

    /**
     *
     * @param many
     * @return a logical set of words ordered in ascending least popularity order, so bottom <code>many</code> words
     */
    public List<String> bottom(int many)
    {
        return getWordsList(many, "bottom");
    }

    public List<String> getWordsList(int many, String topOrBottom)
    {
        List<String> uniqueWords = new ArrayList<>();
        List<Integer> uniqueWordsCount = new ArrayList<>();

        for (int i = 0; i < wordsList.size(); i++)
            if (!uniqueWords.contains(wordsList.get(i)))
            {
                uniqueWords.add(wordsList.get(i));
                uniqueWordsCount.add(1);
            } else
                uniqueWordsCount.set(uniqueWords.indexOf(wordsList.get(i)),
                        uniqueWordsCount.get(uniqueWords.indexOf(wordsList.get(i))) + 1);

        if (many > uniqueWords.size())
            many = uniqueWords.size();
        else if (many < 0)
            many = 1;

        List<String> topOrBottomWords = new ArrayList<>(many);
        topOrBottomWordsCount = new ArrayList<>(many);

        for (int i = 0; i < many; i++)
        {
            int maxOrMinIndex = 0;
            int maxOrMin = uniqueWordsCount.get(0);

            for (int j = 1; j < uniqueWordsCount.size(); j++)
                if (topOrBottom.equals("top"))
                {
                    if (uniqueWordsCount.get(j) > maxOrMin)
                    {
                        maxOrMinIndex = j;
                        maxOrMin = uniqueWordsCount.get(j);
                    }
                } else
                {
                    if (uniqueWordsCount.get(j) < maxOrMin)
                    {
                        maxOrMinIndex = j;
                        maxOrMin = uniqueWordsCount.get(j);
                    }
                }

            topOrBottomWords.add(uniqueWords.get(maxOrMinIndex));
            topOrBottomWordsCount.add(uniqueWordsCount.get(maxOrMinIndex));
            uniqueWords.remove(maxOrMinIndex);
            uniqueWordsCount.remove(maxOrMinIndex);
        }

      //  System.out.println(getWordCount(topOrBottomWordsCount));
        return topOrBottomWords;
    }


    /**
     *
     * @return the input that is being word counted (maintaining the order prescribed by {@link #addWord(String) }
     * @see #addWord(String)
     */
    public String source()
    {
        String str = "";
        for (String s : wordsList)
            str += s + " ";
        return str;
    }

    private String getWordCount()
    {
        String counts = "\t\t[";
        counts += topOrBottomWordsCount.get(0);
        for (int i = 1; i < topOrBottomWordsCount.size(); i++)
            counts += ", " + topOrBottomWordsCount.get(i);
        return counts + "]";
    }
}