import java.util.Date;

public class User
{
    private int id;
    private String name;
    private String phoneNumber;
    private String imgDir;
    private Date birthDay;


    //Register in the DB
    boolean registerInDB()
    {


        return true;
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
