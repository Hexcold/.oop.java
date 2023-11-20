import java.util.List;

public class Inbox {
    public User user;
    public List<Msg> msgs;

    public void addMsg(){
        msgs.add(msg);
    }

    public List<Msg> getMsgs(){
        return msgs;
    }

    public User getUser(){
        return user;
    }

}
