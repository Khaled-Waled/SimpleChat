package Core;

import java.sql.Date;

/**
 * A class representing the user structure
 * @author Khaled-Waled
 */
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
     * @param phoneNumber   Core.User's phone number (Not required)
     * @param imgDir    The user's profile picture's directory on the server (Not Required)
     * @param birthDay  Core.User's Birthday (Not Required)
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
     * A function allows displaying a user's data in a string form
     * @return user data as txt
     */
    @Override
    public String toString()
    {
        return "Core.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", imgDir='" + imgDir + '\'' +
                ", birthDay=" + birthDay +
                '}';
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
