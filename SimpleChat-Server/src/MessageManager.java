public class MessageManager
{

    public static boolean sendMessage(Message message)
    {
        String fileDir= (Math.max(message.getReceiverId(),message.getSenderId())
                         +"_"+
                         Math.max(message.getReceiverId(),message.getSenderId()) );

        //TODO (sendMessage)
        return true;
    }
}
