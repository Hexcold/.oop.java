public class WhatsappService {
    Map<String, Chat> rep_chat;
    Map<String, User> rep_user;

    public WhatsappService() {
        rep_chat = new HashMap<>();
        rep_user = new HashMap<>();
    }

    protected User getUser(String userid) {
        return rep_user.get(id);
    }

    protected Chat getChat(String chatid) {
        return rep_chat.get(id);
    }

    protected boolean chatExiste(Chat chat) {
        return rep_chat.containsKey(chatid);
    }

    protected boolean userExiste(User user) {
        return rep_user.containsKey(userid);
    }

    public String getChatsUser(String userid) {
        User user = getUser(userid);
        return user.getChats();
    }

    public String getUsersChat(String chatid) {
        Chat chat = getChat(chatid);
        return chat.getUsers();
    }

    public String getNotifyUser(String userid) {
        User user = getUser(userid);
        return user.getNotify();
    }

    public void createChat(String chatid) {
        Chat chat = new Chat(chatid);
        rep_chat.put(chatid, chat);
    }

    public void addByInvite(String userid, String chatid) {
        User user = getUser(userid);
        Chat chat = getChat(chatid);
        user.addChat(chat);
        chat.addUser(user);
    }

    public void createUser(String userid) {
        User user = new User(userid);
        rep_user.put(userid, user);
    }

    public void allUsers() {
        return rep_user.values();
    }

    public void removerUserChat(String userid, String chatid) {
        User user = getUser(userid);
        Chat chat = getChat(chatid);
        user.removeChat(chat);
        chat.removeUser(user);
    }

    public void sendMessagem(String userid, String chatid, String message) {
        User user = getUser(userid);
        Chat chat = getChat(chatid);
        user.sendMessagem(chat, text);
    }

    public String readMessagemUserChat(String userid, String chatid) {
        User user = getUser(userid);
        Chat chat = getChat(chatid);
        return user.readMessagem(chat);
    }
    
}
