package com.tiy.ssa.weekone.assignmentthree;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tiy.ssa.weekone.assignmentone.Power;

public class PigLatin
{
    static final Logger LOGGER = LogManager.getLogger(Power.class);

    private String english;
    private Scanner in;

    public PigLatin(String english)
    {
        this.english = english;
        in = new Scanner(english.toLowerCase());
    }

    public String translate()
    {
        String word;
        String pigLatinSentence = "";

        while (in.hasNext())
        {
            word = in.next();

            if (isVowel(word.toCharArray()[0])) // first letter is vowel
                pigLatinSentence += word + "way";
            else if (word.toCharArray().length < 2) // single letter word that is a consonant
                pigLatinSentence += word + "ay";
            else if (isVowel(word.toCharArray()[1])) // first consonant, second vowel
                pigLatinSentence += word.substring(1) + word.substring(0, 1) + "ay";
            else // first consonant, second consonant
                pigLatinSentence += word.substring(2) + word.substring(0, 2) + "ay";

            if (in.hasNext())
                pigLatinSentence += " ";
        }
        printString(pigLatinSentence);
        return pigLatinSentence;
    }

    private boolean isVowel(char c)
    {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    @Override
    public String toString()
    {
        return english + " ---> " + translate();
    }

    private void printString(String pigLatinSentence)
    {
        LOGGER.debug(english + " ---> " + pigLatinSentence);
    }
}
