import java.sql.Date;

public class Interface
{
    public static void main(String[] args)
    {
        //Initialize the connection to the database
        //Database db = Database.getDatabaseInstance();

        Date date = new Date(System.currentTimeMillis());
        String s = date.toString();
        System.out.println(s);

    }
}
