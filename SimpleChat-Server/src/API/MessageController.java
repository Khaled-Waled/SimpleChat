package Core;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping("/hello")
    public String testing()
    {
        return "Hello there!";
    }
    @GetMapping("/error")
    public String errorPage()
    {
        return "ERRORRRR !";
    }
    @GetMapping("")
    public String testing2()
    {
        return "Hello thereeeeee!";
    }
}
