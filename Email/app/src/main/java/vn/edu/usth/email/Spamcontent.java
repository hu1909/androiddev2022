package vn.edu.usth.email;

public class Spamcontent {
    private final String spammer;
    private final String spamcontent;

    public static final Spamcontent[] spamcontents = {
            new Spamcontent("Spam1", "something 1"),
            new Spamcontent("Spam2", "something 2"),
            new Spamcontent("Spam3", "something 3")
    };

    private Spamcontent(String spammer, String spamcontent) {
        this.spammer = spammer;
        this.spamcontent = spamcontent;
    }
    public String getSpammer() {
        return spammer;
    }
    public String getSpamcontent() { return spamcontent; }
    public String toString() {
        return this.spammer;
    }
}
