package module.message;

@lombok.Data
public class Message {
    private String content;

    public Message() {
        // this utility class is deliberately empty
    }

    public Message(String content) {
        this.content = content;
    }
}
