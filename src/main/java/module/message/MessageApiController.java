package module.message;

import module.ModelToResponseMapper;
import module.Response;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("warung-pintar/module")
public class MessageApiController {
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Response<String> saveMessage(
            String message) throws Exception {
        return ModelToResponseMapper.mapThisSuccess(message);
    }

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public Message getMessage(Message message) {
        return new Message("This is your message : " + message.getContent());
    }
}
