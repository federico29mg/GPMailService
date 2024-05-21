package Services;

import DB.MailDB;
import Entities.Mail;
import Entities.MailInfo;

import java.util.List;

public class MailServiceImpl implements MailService {
    private final MailDB mailDB;

    @Override
    public void sendMail(Mail mail) {
        System.out.println("Email with ID " + mail.mailInfo.uuid + " was sent");
    }

    @Override
    public List<MailInfo> listMails(int start, int finish) {
        List<MailInfo> mailInfoList = this.mailDB.mails.subList(start - 1, finish)
                .stream()
                .map(mail -> mail.mailInfo)
                .toList();

        mailInfoList.forEach(mailInfo -> System.out.println("Entities.Mail ID " + mailInfo.uuid));

        return mailInfoList;
    }

    @Override
    public Mail downloadMail(MailInfo mailInfo) {
        return this.mailDB.mails.stream().filter(mail -> mail.mailInfo.uuid == mailInfo.uuid).findFirst().orElse(null);
    }

    public MailServiceImpl(MailDB mailDB) {
        this.mailDB = mailDB;
    }
}
