import java.sql.ResultSet;
import java.sql.SQLException;

public class Interface
{
    public static void main(String[] args)
    {
        Database db = Database.getDatabaseInstance();
        //test connection
        ResultSet resultSet = db.query("SELECT * FROM Users");
        try
        {
            while (resultSet.next())
            {
                System.out.println(resultSet.getString(1)+"---"+resultSet.getString(2));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
