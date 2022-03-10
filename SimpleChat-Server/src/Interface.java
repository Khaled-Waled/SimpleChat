import java.util.ArrayList;

public class Interface
{
    public static void main(String[] args)
    {
        //Initialize the connection to the database
        //Database db = Database.getDatabaseInstance();


        MessageManager.storeMessage(new Message(11,56,"text"));
        MessageManager.storeMessage(new Message(56,11,"hi"));

        ArrayList<Message> messages = MessageManager.retrieveConversation(56,11);

        for(Message message: messages)
            System.out.println(message.toString());

    }
}
