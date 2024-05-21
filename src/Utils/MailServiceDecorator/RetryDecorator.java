package Utils.MailServiceDecorator;

import Entities.Mail;
import Entities.MailInfo;
import Services.MailService;

import java.util.List;

public class RetryDecorator extends MailServiceDecorator {
    private final int retries;
    public RetryDecorator(MailService mailService, int retries) {
        super(mailService);
        this.retries = retries;
    }

    @Override
    public void sendMail(Mail mail) {
        for(int i = 0; i < this.retries; i++) {
            try {
                super.sendMail(mail);
                return;
            }
            catch (Exception e) {
                System.out.println("Retry # " + (i + 1));
            }
        }
        System.out.println("Couldn't process request");
    }

    @Override
    public List<MailInfo> listMails(int start, int finish) {
        for(int i = 0; i < this.retries; i++) {
            try {
                return super.listMails(start, finish);
            }
            catch (Exception e) {
                System.out.println("Retry # " + (i + 1));
            }
        }
        System.out.println("Couldn't process request");
        return null;
    }

    @Override
    public Mail downloadMail(MailInfo mailInfo) {
        for(int i = 0; i < this.retries; i++) {
            try {
                return super.downloadMail(mailInfo);
            }
            catch (Exception e) {
                System.out.println("Retry # " + (i + 1));
            }
        }
        System.out.println("Couldn't process request");
        return null;
    }
}
