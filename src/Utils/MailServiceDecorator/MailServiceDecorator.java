package Utils.MailServiceDecorator;

import Entities.Mail;
import Entities.MailInfo;
import Services.MailService;

import java.util.List;

public abstract class MailServiceDecorator implements MailService {
    private final MailService mailService;

    @Override
    public void sendMail(Mail mail) {
        this.mailService.sendMail(mail);
    }

    @Override
    public List<MailInfo> listMails(int start, int finish) {
        return this.mailService.listMails(start, finish);
    }

    @Override
    public Mail downloadMail(MailInfo mailInfo) {
        return this.mailService.downloadMail(mailInfo);
    }

    public MailServiceDecorator(MailService mailService) {
        this.mailService = mailService;
    }
}
