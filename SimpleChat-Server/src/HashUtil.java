import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil
{
    public byte[] generateHash(String sample)
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
        return hash;
    }

    public boolean testHashFor(String sample, byte[] hash)
    {
        return (hash == generateHash(sample));
    }
}
