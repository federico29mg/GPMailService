package Services;

import Entities.Mail;
import Entities.MailInfo;

import java.util.List;

public interface MailService {
    void sendMail(Mail mail);
    List<MailInfo> listMails(int start, int finish);
    Mail downloadMail(MailInfo mailInfo);
}
