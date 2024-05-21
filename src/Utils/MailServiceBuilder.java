package Utils;

import Services.MailService;
import Utils.MailServiceDecorator.CachingDecorator;
import Utils.MailServiceDecorator.LoggingDecorator;
import Utils.MailServiceDecorator.RetryDecorator;
import Utils.MailServiceDecorator.ThreadDecorator;

public class MailServiceBuilder {
    private MailService mailService;

    public MailServiceBuilder(MailService mailService) {
        this.mailService = mailService;
    }

    public MailServiceBuilder setRetries(int retries) {
        this.mailService = new RetryDecorator(this.mailService, retries);
        return this;
    }

    public MailServiceBuilder setThread(boolean safe) {
        this.mailService = new ThreadDecorator(this.mailService, safe);
        return this;
    }

    public MailServiceBuilder setLogging() {
        this.mailService = new LoggingDecorator(this.mailService);
        return this;
    }

    public MailServiceBuilder setCaching() {
        this.mailService = new CachingDecorator(this.mailService);
        return this;
    }

    public MailService build() {
        return this.mailService;
    }
}
