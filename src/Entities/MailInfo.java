package Entities;

import java.util.UUID;

public class MailInfo {
    public UUID uuid;
    public String from;
    public String to;

    public MailInfo(String from, String to) {
        this.uuid = UUID.randomUUID();
        this.from = from;
        this.to = to;
    }
}
