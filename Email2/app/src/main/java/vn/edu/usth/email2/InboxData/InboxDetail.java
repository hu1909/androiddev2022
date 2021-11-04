package vn.edu.usth.email2.InboxData;

public class InboxDetail {
    private String IbSender;
    private String IbTitle;
    private String IbDetails;
    private String RcvTime;

    public InboxDetail(String IbSender, String IbTitle, String IbDetails, String RcvTime) {
        this.IbSender = IbSender;
        this.IbTitle = IbTitle;
        this.IbDetails = IbDetails;
        this.RcvTime = RcvTime;
    }

    public String getIbSender() { return IbSender; }

    public String getIbTitle() {
        return IbTitle;
    }

    public String getIbDetails() {
        return IbDetails;
    }

    public String getRcvTime() {
        return RcvTime;
    }
}
