package main.Utilities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil
{
    public static String generateHash(String sample)
    {

        byte[] hash = null;
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(sample.getBytes(StandardCharsets.UTF_8));
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return hash.toString();
    }

    public static boolean testHashFor(String sample, String hash)
    {
        return (hash.equals(generateHash(sample)));
    }
}
