package vn.edu.usth2.emailclient;

public class Messages {
    private String sender, receiver, title, detail;


    public Messages() {
    }


    public Messages(String sender, String receiver, String title, String detail) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.detail = detail;
    }



    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
