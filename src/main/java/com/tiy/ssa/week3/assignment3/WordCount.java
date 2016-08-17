package com.tiy.ssa.week3.assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    /**
     * 
     * @param word
     *            callers are responsible for ensuring <code>word</code> <br>
     *            is an actual word, parsing is done by the caller
     */
     final List<String> words = new ArrayList<>();
     final List<String> words2 = new ArrayList<>();
     final Map<String, Integer> map = new HashMap<>();

    public void addWord(String word) {
        word = word.toLowerCase();
        words.add(word);
        if (!words2.contains(word))
            words2.add(word);
       
        map.merge(word, 1, (count, ignore) -> ++count);

      
        
    }

    public int count(String word) {
        return map.getOrDefault(word, 0);
    }

    /**
     *
     * @param many
     * @return a logical set of words ordered in descending popularity order, so
     *         top <code>many</code> words
     */
    public List<String> top(int many) {
        List<String> temp = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();
        for (String s : words2) {
            temp2.add(s);
        }

        temp2.sort((s1, s2) -> -(count(s1) - count(s2)));

        for (int i = 0; i < many; i++) {
            temp.add(temp2.get(i));
        }

        return temp;
    }

    /**
     *
     * @param many
     * @return a logical set of words ordered in ascending least popularity
     *         order, so bottom <code>many</code> words
     */
    public List<String> bottom(int many) {
        List<String> temp = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();
        for (String s : words2) {
            temp2.add(s);
        }

        temp2.sort((s1, s2) -> (count(s1) - count(s2)));

        for (int i = 0; i < many; i++) {
            temp.add(temp2.get(i));
        }
        
        

        return temp;

    }

    /**
     *
     * @return the input that is being word counted (maintaining the order
     *         prescribed by {@link #addWord(String) }
     * @see #addWord(String)
     */
    public String source() {
        String article = "";
        for (String s : words)
            article = article.concat(s + " ");

        return article;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((map == null) ? 0 : map.hashCode());
        result = prime * result + ((words == null) ? 0 : words.hashCode());
        result = prime * result + ((words2 == null) ? 0 : words2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WordCount other = (WordCount) obj;
        if (map == null) {
            if (other.map != null)
                return false;
        } else if (!map.equals(other.map))
            return false;
        if (words == null) {
            if (other.words != null)
                return false;
        } else if (!words.equals(other.words))
            return false;
        if (words2 == null) {
            if (other.words2 != null)
                return false;
        } else if (!words2.equals(other.words2))
            return false;
        return true;
    }

}