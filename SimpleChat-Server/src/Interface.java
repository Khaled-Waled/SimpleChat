public class Interface
{
    public static void main(String[] args)
    {
        //Initialize the connection to the database
        //Database db = Database.getDatabaseInstance();

        for (int i=1; i<=5; i++)
        {
            String text = "Hello World, For the "+i+"th time!" ;
            Message message1 = new Message(56,11,text);
            MessageManager.storeMessage(message1);
        }

        for (int i=1; i<=5; i++)
        {
            String text = "Hello World, For the "+i+"th time!" ;
            Message message1 = new Message(11,56,text);
            MessageManager.storeMessage(message1);
        }

    }
}
