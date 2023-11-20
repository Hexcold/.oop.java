public class Notify {
    public String chatId;
    public int unreadCount;

    public String getId() {
        return chatId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void addCount() {
        unreadCount++;
    }

    public void rmNotify() {
        unreadCount = 0;
    }
}
