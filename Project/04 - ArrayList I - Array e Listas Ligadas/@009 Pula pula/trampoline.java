import java.util.LinkedList;
import java.util.stream.Collectors;

public class Trampoline{
    private LinkedList<Kid> waiting;
    private LinkedList<Kid> playing;
    
    public Trampoline() {
        this.waiting = new LinkedList<>();
        this.playing = new LinkedList<>();
    }

    private Kid removeFromList(String name, LinkedList<Kid> list) {
        if(list.size() > 0){
            list.removeLast();
            return null;
        }
        return null;
    }

    public void arrive(Kid kid) {
        this.waiting.addFirst(kid);
    }

    public void enter() {
        if(this.waiting.size() > 0){
            this.playing.addFirst(this.waiting.removeLast());
        }
    }

    public void leave() {
        if(this.playing.size() > 0){
            this.waiting.addFirst(this.playing.removeLast());
        }
    }   

    public Kid remoteKid(String name) {
        for(int i = 0; i < this.playing.size(); i++){
            if(this.playing.get(i).getName().equals(name)){
                removeFromList(name, playing);
                return null;
            }
        }
        for (int i = 0; i < this.waiting.size(); i++) {
            if (this.waiting.get(i).getName().equals(name)) {
                removeFromList(name, waiting);
                return null;
            }
        
        }
        return null;
    }

    public String toString() {
        return   "[" + waiting.stream().map(Kid::toString).collect(Collectors.joining(", ")) + "]" + " => "
               + "[" + playing.stream().map(Kid::toString).collect(Collectors.joining(", ")) + "]";
    }
}