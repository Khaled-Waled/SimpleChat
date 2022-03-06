import java.sql.Date;

public class Interface
{
    public static void main(String[] args)
    {
        //Initialize the connection to the database
        Database db = Database.getDatabaseInstance();

        //Create a test user
        User testUser = new User(-1,"user1","123456","/home/pictures/k.png",
                new Date(System.currentTimeMillis()));
        User.registerInDB(testUser,"abc");

    }
}
