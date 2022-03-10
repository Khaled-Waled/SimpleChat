import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;


/**
 * The class that manages the storage and parsing of messages in the directory AppData/Chats/xxx.txt
 * @author Khaled-Waled
 */
public class MessageManager
{
    final static String DEFAULT_EXTENSION = "txt";

    /**
     * @param id1 First id (usually sender's)
     * @param id2 Second id (usually receiver's)
     * @param type The Extention that the server uses to store message (Default is DEFAULT_EXTENSION)
     * @return the naming convention used to store a message
     */
    private static String getBasicFileName(int id1, int id2, String type )
    {
        return  Math.max(id1,id2)
                + "_"
                + Math.min(id1,id2)
                +"." + type;
    }


    private static String getBasicMessageDirectory(int id1, int id2)
    {
        String slashChar = System.getProperty("file.separator");

        return  "AppData"+slashChar+"Chats"+slashChar
                + getBasicFileName(id1,id2,DEFAULT_EXTENSION);
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

    public static Message parseMessageLine(String line, String sourceFileName)
    {
        if (line == null)
            return null;


        char mleChar = 30;
        //extract data array of size 3
        String[] data = line.split(String.valueOf(mleChar));
        String[] userStr = sourceFileName.split("\\.")[0].split("_");
        int[] user = { Integer.parseInt(userStr[0]), Integer.parseInt(userStr[1])};

        int senderID= user[0];
        int receiverID= user[1];

        if (data[0].equals("0"))
        {
            senderID = user[1];
            receiverID = user[0];
        }


        Timestamp timestamp = Timestamp.valueOf(data[1]);
        String content = data[2];

        return new Message(senderID,receiverID,timestamp,content);
    }

    public static ArrayList<Message> retrieveConversation(int id1, int id2)
    {
        ArrayList<Message> messages = new ArrayList<>();
        String dir =
                System.getProperty("user.dir") + System.getProperty("file.separator")
                        + getBasicMessageDirectory(id1, id2);
        String line;
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader(dir));
            line = reader.readLine();
            while (line!=null)
            {
                Message message = parseMessageLine(line,getBasicFileName(id1,id2,DEFAULT_EXTENSION));
                messages.add(message);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return messages;
    }
}
