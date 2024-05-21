import DB.MailDB;
import Entities.Mail;
import Entities.MailInfo;
import Services.MailService;
import Services.MailServiceImpl;
import Utils.MailServiceBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MailDB mailDB = new MailDB();

        MailService mailService = new MailServiceBuilder(new MailServiceImpl(mailDB))
                .setRetries(2)
                .setThread(false)
                .setLogging()
                .setCaching()
                .build();

        List<MailInfo> mailInfoList = mailService.listMails(1, 2);
        Mail downloadedMail = mailService.downloadMail(mailInfoList.getFirst());
        mailService.sendMail(downloadedMail);
    }
}