package com.tiy.ssa.weekone.assignmentthree;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.tiy.ssa.weekone.assignmentthree.MaybePalindrome;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaybePalindromeTests
{
	@Test
	public void aTrueTest()
	{
		assertTrue(new MaybePalindrome("rAceCAR").isPalindrome());
		assertTrue(new MaybePalindrome("aaaaaaaaaaaaaa").isPalindrome());
		assertTrue(new MaybePalindrome("o").isPalindrome());
		assertTrue(new MaybePalindrome("5 -bob- 5").isPalindrome());
		assertTrue(new MaybePalindrome("").isPalindrome());
		
		System.out.println(new MaybePalindrome("5 -bob- 5").toString());
	}

	@Test
	public void bFalseTest()
	{
		assertFalse(new MaybePalindrome("banana").isPalindrome());
		assertFalse(new MaybePalindrome("aaao").isPalindrome());
		assertFalse(new MaybePalindrome("Whatever").isPalindrome());
		assertFalse(new MaybePalindrome("ethiopia").isPalindrome());
		
		assertFalse(new MaybePalindrome(null).isPalindrome());
		
		System.out.println(new MaybePalindrome("Whatever").toString());
	}
}
