package com.tiy.ssa.week3.assignment3;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class FileVerifierTest
{
    static final Logger LOGGER = LogManager.getLogger(FileVerifierTest.class);

    String eclipse = ("C:/Users/admin/Downloads/eclipse-inst-win64.exe");
    String eclipse512 = "21302bcf1d6d22ce3022af54f958649695afb84e38c8e640eafd7e64ba852ff3c13eae33db9e19affbc4e861341391143a40669da839c1bddcc8dea7240218e9";

    String mysql = ("C:/Users/admin/Downloads/mysql-5.7.14-win32.zip");
    String mysqlMD5 = "5b88f3e3724122f1fbd2fac26f8a7bd8";
    
    String maven = ("C:/Users/admin/Downloads/apache-maven-3.3.9-bin.zip");


    @Test
    public void test() throws NoSuchAlgorithmException
    {
        FileVerifier f1 = new FileVerifier(eclipse, "SHA-512");
        LOGGER.debug(f1.hash());
        
        assertTrue(eclipse512.equals(f1.hash()));
        
        FileVerifier f2 = new FileVerifier(mysql, "MD5");
        LOGGER.debug(f2.hash());
        
        assertTrue(mysqlMD5.equals(f2.hash()));
        
        FileVerifier f3 = new FileVerifier(maven, "MD5");
        LOGGER.debug(f3.hash());
    }

}
