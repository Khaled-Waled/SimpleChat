import java.io.FileWriter;
import java.io.IOException;

public class MessageManager
{

    public static boolean storeMessage(Message message)
    {
        String slashChar = System.getProperty("file.separator");
        //Message Element Separator character
        char mleChar = 30;

        String fileDir= "AppData"+slashChar+"Chats"+slashChar
                         + (Math.max(message.getReceiverId(),message.getSenderId())
                         + "_"
                         + Math.max(message.getReceiverId(),message.getSenderId()) );

        //Person with the smaller id stores messages with char = 0
        //NEEDS TESTING
        char senderChar;
        if (message.getSenderId() > message.getReceiverId())
            senderChar = '1';

        else senderChar = '0';
        String line=  senderChar + mleChar + message.getDate().toString() + mleChar + message.getContent();
        try
        {
            FileWriter fileWriter = new FileWriter("filename.txt");
            fileWriter.write(line);
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static Message retrieveMessage(String line)
    {
        //TODO (retrieveMessage)
        return null;
    }
}
