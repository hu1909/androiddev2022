package vn.edu.usth.email;

public class Content {
    private String sender;
    private String content;

    public static final Content[] contents = {
            new Content("Google", "something 1"),
            new Content("Youtube", "something 2"),
            new Content("Facebook", "something 3")
    };

    private Content(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }
    public String getSender() {
        return sender;
    }
    public String getContent() { return content; }
    public String toString() {
        return this.sender;
    }
}
