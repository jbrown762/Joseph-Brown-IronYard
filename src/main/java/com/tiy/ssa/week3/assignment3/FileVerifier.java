package com.tiy.ssa.week3.assignment3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileVerifier
{

    File file;
    MessageDigest sha1;

    public FileVerifier(String filePath, String sha) throws NoSuchAlgorithmException
    {
        this.file = new File(filePath);
        this.sha1 = MessageDigest.getInstance(sha);
    }

    String hash()
    {
        byte[] bytes = new byte[1_024];
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file)))
        {
            int read;
            while ((read = inputStream.read(bytes)) > 0)
            {
                this.sha1.update(bytes, 0, read);
            }
            byte[] digest = this.sha1.digest();
            return toHex(digest);

        } catch (Exception e)
        {
        }

        return "";
    }

    private String toHex(byte[] digest)
    {
        StringBuilder sb = new StringBuilder();

        for (Byte b : digest)
            sb.append(String.format("%02x", b));

        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        String filePath = args[0];
        String alg = args[1];
        for (int i = 0; i < args.length; i++)
        {
            if(args[i].equals("-f"))
                filePath = args[i+1];
            else if(args[i].equals("-alg"))
                alg = args[i+1].toUpperCase();
        }
            
        FileVerifier f = new FileVerifier(filePath, alg);
        System.out.println((alg + " hash:").toUpperCase());
        System.out.println(f.hash());
    }

}
