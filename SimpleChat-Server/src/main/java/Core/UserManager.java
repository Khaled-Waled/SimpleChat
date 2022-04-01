package main.java.Core;

import main.java.Utilities.HashUtil;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The class managing a user's interaction with the system
 * @author Khaled-Waled
 */
public class UserManager
{
    /**
     * A function to store a new user in the database
     * @param user          the user as an object
     * @param password      main.Core.User's password
     * @return              Success or failure
     */
    public static boolean registerInDB(User user, String password)
    {
        Database db = Database.getDatabaseInstance();
        //Prepare query
        String query =
                "INSERT INTO `SimpleChat`.`Users`\n" +
                        "(`Name`,`Passphrase`,`phoneNumber`,`imgDir`,`birthDay`)VALUES"+
                        "(?,?,?,?,?)";
        PreparedStatement preparedStatement = db.prepareStatement(query);
        try
        {
            //Extract data from parameter
            String passwordHash = HashUtil.generateHash(password);
            //String passwordHash = new  String(Base64.getDecoder().decode(main.Utilities.HashUtil.generateHash(password)));
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, passwordHash);
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getImgDir());
            preparedStatement.setDate(5, user.getBirthDay());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Gets all users with this name
     * @param name the name to search with
     * @return  all users with that name
     */
    ArrayList<User> getUsersByName(String name)
    {
        ArrayList<User> users = new ArrayList<>();
        Database db = Database.getDatabaseInstance();
        //Prepare query
        String query = "SELECT * FROM `SimpleChat`.`Users`\n" +
                "WHERE `Name` = ? ;";

        PreparedStatement preparedStatement = db.prepareStatement(query);

        try
        {
            preparedStatement.setString(0,name);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user;
            while (resultSet.next())
            {
                user = getUserFromTuple(resultSet);
                if (user != null)
                    users.add(user);
            }
            if (users.size()>0)
                return users;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Search for a user provided their ID
     * @param id user id
     * @return  the targeted user
     */
    public User getUserById(int id)
    {
        Database db = Database.getDatabaseInstance();
        //Prepare query
        String query = "SELECT * FROM `SimpleChat`.`Users`\n" +
                "WHERE `ID` = ? ;";

        PreparedStatement preparedStatement = db.prepareStatement(query);

        try
        {
            preparedStatement.setInt(0,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user;
            resultSet.next();
            user = getUserFromTuple(resultSet);
            return user;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * A utility function to translate a user tuple to a user object
     * @param resultSet The Tuple containing the user's data
     * @return the resulting user as an object
     */
    public static User getUserFromTuple(ResultSet resultSet)
    {
        try
        {
            //Extract data from tuple
            int id
                    = resultSet.getInt(0);
            String name
                    = resultSet.getString(1);
            String phoneNumber
                    = resultSet.getString(2);
            String imgDir
                    = resultSet.getString(3);
            Date birthDay
                    = resultSet.getDate(4);

            //Put the data into a new user
            return new User(id,name,phoneNumber,imgDir,birthDay);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
