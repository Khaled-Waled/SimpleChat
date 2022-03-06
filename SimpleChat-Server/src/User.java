import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class User
{
    private int id;
    private String name;
    private String phoneNumber;
    private String imgDir;
    private Date birthDay;


    /**
     * Constructor for the user class
     * @param id The ID for a specific user (Required)
     * @param name  The Username (Not Required but Preferred)
     * @param phoneNumber   User's phone number (Not required)
     * @param imgDir    The user's profile picture's directory on the server (Not Required)
     * @param birthDay  User's Birthday (Not Required)
     */
    public User(int id, String name, String phoneNumber, String imgDir, Date birthDay)
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imgDir = imgDir;
        this.birthDay = birthDay;
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

    //Register in the DB
    public static boolean registerInDB(User user, String password)
    {
        //TODO (registerInDB)
        //Extract data from parameter


        return true;
    }

    //Get ids by name
    ArrayList<User> getIdsByName(String name)
    {
        Database db = Database.getDatabaseInstance();
        ResultSet resultSet;
        //TODO (getIdsByName) Write the query



        ArrayList<User> users = null;
        return users;
    }

    //Get user by id
    public User getUserById(int id)
    {
        //TODO (getUserById)

        return null;
    }

    //Setters and getters
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * @param phoneNumber Phone Number
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getImgDir()
    {
        return imgDir;
    }

    public void setImgDir(String imgDir)
    {
        this.imgDir = imgDir;
    }

    public Date getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
    }
}
