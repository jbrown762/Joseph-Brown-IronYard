package com.tiy.ssa.weekone.assignmentthree;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaybePalindromeTests
{
    static final Logger LOGGER = LogManager.getLogger(MaybePalindromeTests.class);

	@Test
	public void aTrueTest()
	{
		assertTrue(new MaybePalindrome("rAceCAR").isPalindrome());
		assertTrue(new MaybePalindrome("aaaaaaaaaaaaaa").isPalindrome());
		assertTrue(new MaybePalindrome("o").isPalindrome());
		assertTrue(new MaybePalindrome("5 -bob- 5").isPalindrome());
		
		 LOGGER.debug(new MaybePalindrome("5 -bob- 5").toString());
	}

	@Test
	public void bFalseTest()
	{
		assertFalse(new MaybePalindrome("banana").isPalindrome());
		assertFalse(new MaybePalindrome("aaao").isPalindrome());
		assertFalse(new MaybePalindrome("Whatever").isPalindrome());
		assertFalse(new MaybePalindrome("ethiopia").isPalindrome());
		assertFalse(new MaybePalindrome("").isPalindrome());
				
		 LOGGER.debug(new MaybePalindrome("Whatever").toString());
	}
}
