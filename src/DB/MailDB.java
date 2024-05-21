package DB;

import Entities.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailDB {
    public List<Mail> mails;

    public MailDB() {
        this.mails = new ArrayList<>();

        Mail mail1 = new Mail("user1@test.com", "user2@test.com", "Hello User2!");
        Mail mail2 = new Mail("user1@test.com", "user3@test.com", "Hello User3!");
        Mail mail3 = new Mail("user1@test.com", "user4@test.com", "Hello User4!");

        this.mails.add(mail1);
        this.mails.add(mail2);
        this.mails.add(mail3);
    }
}
