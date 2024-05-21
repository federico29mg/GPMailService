package Utils.MailServiceDecorator;

import Entities.Mail;
import Entities.MailInfo;
import Services.MailService;

import java.util.List;

public class LoggingDecorator extends MailServiceDecorator {
    public LoggingDecorator(MailService mailService) {
        super(mailService);
    }

    @Override
    public void sendMail(Mail mail) {
        action(true);
        super.sendMail(mail);
        action(false);
    }

    @Override
    public List<MailInfo> listMails(int start, int finish) {
        action(true);
        List<MailInfo> mailInfoList = super.listMails(start, finish);
        action(false);
        return mailInfoList;
    }

    @Override
    public Mail downloadMail(MailInfo mailInfo) {
        action(true);
        Mail mail = super.downloadMail(mailInfo);
        action(false);
        return  mail;
    }

    private void action(boolean on) {
        String status = on ? "ON" : "OFF";
        System.out.println("Logging " + status);
    }
}
