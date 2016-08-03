package com.tiy.ssa.weekone.assignmentthree;

import java.util.Scanner;

public class PigLatin
{
	private String english;
	private String word;
	private String pigLatinSentence;
	private Scanner in;

	public PigLatin(String english)
	{
		this.english = english;
		in = new Scanner(english.toLowerCase());
		pigLatinSentence = "";
	}

	public String translate()
	{
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
		printString();
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
	
	private void printString()
	{
		System.out.println(english + " ---> " + pigLatinSentence);
	}
}
