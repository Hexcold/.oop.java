import java.util.Map;

public class Chat {
    private String id;
    protected Map<String, Inbox> inboxes;
    protected Map<String, User> users;

    public Msg[] getMsgs(String userid) {
        Inbox inbox = inboxes.get(userid);
        return inbox.getMsgs();
    }
}
