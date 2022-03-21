package Core;

import java.sql.Timestamp;

/**
 * A class to represent a message and its related operations
 * @author Khaled-Waled
 */
public class Message
{
    private int senderId;
    private int receiverId;
    private Timestamp date;
    private String content;

    /**
     * Override for the toString function to show a message as a string.
     * @return A string that contains the message's data
     */
    @Override
    public String toString()
    {
        return  "From: " + senderId +
                ", To: " + receiverId +
                ", At: " + date.toString() +
                "\n    content='" + content + '\'';
    }

    /**
     * Complete Constructor for the message
     * @param senderId      Sender ID
     * @param receiverId    Receiver ID
     * @param date          Core.Message time and date
     * @param content       Core.Message content
     */
    public Message(int senderId, int receiverId, Timestamp date, String content)
    {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.content = content;
    }

    /**
     * A Compact constructor that sets the time of the message to now
     * @param senderId      Sender ID
     * @param receiverId    Receiver ID
     * @param content       Core.Message content
     */
    public Message(int senderId, int receiverId, String content)
    {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = new Timestamp(System.currentTimeMillis());
        this.content = content;
    }


    /**
     * Get The sender of the message
     * @return ID ==> int
     */
    public int getSenderId()
    {
        return senderId;
    }

    /**
     * Sets the sender's id
     * @param senderId The id of the sender ==> int
     */
    public void setSenderId(int senderId)
    {
        this.senderId = senderId;
    }

    /**
     * Get The receiver of the message
     * @return ID ==> int
     */
    public int getReceiverId()
    {
        return receiverId;
    }


    /**
     * Sets the receiver's ID
     * @param receiverId the id of the receiver ==> int
     */
    public void setReceiverId(int receiverId)
    {
        this.receiverId = receiverId;
    }

    /**
     * Gets the time the message was created
     * @return date ==> java.sql.Timestamp
     */
    public Timestamp getDate()
    {
        return date;
    }

    /**
     * Sets the message's timestamp
     * @param date the message timestamp ==> java.sql.Timestamp
     */
    public void setDate(Timestamp date)
    {
        this.date = date;
    }

    /**
     * Get the message content
     * @return content ==> String
     */
    public String getContent()
    {
        return content;
    }


    /**
     * Sets the message's content
     * @param content The message's content ==> String
     */
    public void setContent(String content)
    {
        this.content = content;
    }
}
