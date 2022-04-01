package main.java.API;

import main.java.Core.Message;
import main.java.Core.MessageManager;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * A Spring controller class that manages message operations
 * @author Khaled-Waled
 */
@RestController
public class MessageController
{

    @PutMapping("Messages/send")
    public boolean putMessage(@RequestBody Message message)
    {
        return MessageManager.storeMessage(message);
    }

    @GetMapping("Messages/{id1}-{id2}")
    public ArrayList<Message> getConversation(@PathVariable int id1, @PathVariable int id2)
    {
        return MessageManager.retrieveConversation(id1,id2);
    }


    @GetMapping("/test")
    public String testing2()
    {
        return "Hello there!";
    }
}
