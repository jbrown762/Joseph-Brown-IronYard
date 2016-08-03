package com.tiy.ssa.weekone.assignmentthree;

public class MaybePalindrome
{
	final String value;

	public MaybePalindrome(String value)
	{
		this.value = value; //.toLowerCase();
	}

	public boolean isPalindrome()
	{
		if(this.value == null){
			System.out.println("Cannot use a null string!");
			return false;
		}
		
		char[] chars = value.toLowerCase().toCharArray();

		for (int i = 0; i < chars.length / 2; i++)
			if (chars[i] != chars[chars.length - i - 1])
				return false;

		return true;
	}

	@Override
	public String toString()
	{
		return this.value + (isPalindrome() ? " is " : " isn't ") + "a palindrome.";
	}
}