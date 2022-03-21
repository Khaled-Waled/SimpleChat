package Core;

import java.sql.*;

public class Database
{
    private static Database databaseInstance = null;
    private Connection connection;

    private Database()
    {
        System.out.println("Starting Core.Database...");
        try
        {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/SimpleChat", "Generic", "password");
        } catch (SQLException e)
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

    public boolean update(String sqlQuery)
    {
        try (Statement statement = connection.createStatement())
        {
            statement.executeUpdate(sqlQuery);
            return true;
        }
        catch (SQLException throwable)
        {
            throwable.printStackTrace();
            return false;
        }
    }

    public ResultSet query(String sqlQuery)
    {
        try
        {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sqlQuery);
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
        }

        return null;
    }

    public PreparedStatement prepareStatement(String query)
    {
        try
        {
            return connection.prepareStatement(query);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}