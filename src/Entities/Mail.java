package Entities;

public class Mail {
    public MailInfo mailInfo;
    public String body;

    public Mail(String from, String to, String body) {
        this.mailInfo = new MailInfo(from, to);
        this.body = body;
    }
}
