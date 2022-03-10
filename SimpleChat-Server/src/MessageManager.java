import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The class that manages the storage and parsing of messages in the directory AppData/Chats/xxx.txt
 * @author Khaled-Waled
 */
public class MessageManager
{
    private static String getBasicMessageDirectory(int id1, int id2)
    {
        String slashChar = System.getProperty("file.separator");

        return  "AppData"+slashChar+"Chats"+slashChar
                + Math.max(id1,id2)
                + "_"
                + Math.min(id1,id2)
                +".txt";
    }


    public static boolean storeMessage(Message message)
    {
        String fileDir=
                getBasicMessageDirectory(message.getSenderId() ,message.getReceiverId());

        //Message Element Separator character
        char mleChar = 30;

        //Person with the smaller id stores messages with char = 0
        //NEEDS TESTING
        String senderChar;
        if (message.getSenderId() > message.getReceiverId())
            senderChar = "1";
        else senderChar = "0";

        //Construct the (tuple) line
        String line=  senderChar + mleChar + message.getDate().toString() + mleChar + message.getContent()+'\n';
        try
        {
            FileWriter fileWriter = new FileWriter(fileDir,true);
            fileWriter.write(line);
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static Message parseMessageLine(String line)
    {
        //TODO (retrieveMessage)
        return null;
    }

    public ArrayList<Message> retrieveConversation(String dir)
    {
        //TODO (retrieveConversation)
        return null;
    }
}
