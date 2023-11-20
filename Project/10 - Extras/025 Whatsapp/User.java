import java.util.List;
import java.util.Map;

public class User {
    protected Map<String, String> chats;
    protected List<String> notify;

    public Map<String, Chat> getChats() {
        return chats;
    }

    public List<String> getNotify() {
        return notify;
    }

    public Notify getNotify(String chat) {
        return notify.get(chat);
    }

    public void addChat(Chat chat) {
        chats.put(chat.getId(), chat);
    }

    public void addNotify(Chat chat) {
        this.notify.add(chat.getId());
    }

    public void rmChat(Chat chat) {
        chats.remove(chat.getId());
    }

    public String getId() {
        return id;
    }
}
