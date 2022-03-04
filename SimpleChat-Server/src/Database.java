import java.sql.*;

public class Database
{
    private static Database databaseInstance = null;

    private Database()
    {
        System.out.println("Starting Database...");
        try
        {
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","Generic","password");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static Database getDatabaseInstance()
    {
        if (databaseInstance == null)
            databaseInstance = new Database();
        return databaseInstance;
    }
}