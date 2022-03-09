import java.sql.Date;

public class Message
{
    private int senderId;
    private int receiverId;
    private Date date;
    private String content;

    @Override
    public String toString()
    {
        return  "From: " + senderId +
                ", To: " + receiverId +
                ", At: " + date.toString() +
                "\n    content='" + content + '\'' +
                '}';
    }

    public Message(int senderId, int receiverId, Date date, String content)
    {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.content = content;
    }

    public int getSenderId()
    {
        return senderId;
    }

    public void setSenderId(int senderId)
    {
        this.senderId = senderId;
    }

    public int getReceiverId()
    {
        return receiverId;
    }

    public void setReceiverId(int receiverId)
    {
        this.receiverId = receiverId;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}
