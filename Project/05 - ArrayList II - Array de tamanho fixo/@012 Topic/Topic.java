import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Topic {
    private List<Pass> prioritySeats;
    private List<Pass> normalSeats;
    private String topicMapString;

    public Topic(int capacity, int qtdPriority) {
        this.prioritySeats = new ArrayList<Pass>(qtdPriority);
        this.normalSeats = new ArrayList<Pass>(capacity);

        for (int i = 0; i < qtdPriority; i++) {
            this.prioritySeats.add(i, null);
        }

        for (int i = 0; i < capacity - qtdPriority; i++) {
            this.normalSeats.add(i, null);
        }
        
    }

    private static int findFirstFreePos(List<Pass> list) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == null){
                return i;
            }
        }
        return -1;
    }

    private static int findByName(String name, List<Pass> list) {
            for(int i = 0; i < list.size(); i++){
                if (list.get(i) != null && name.equals(list.get(i).getName())) {
                    return i; 
                }     
            }
            return -1;
        }
    
    private static boolean insertOnList(Pass pass, List<Pass> list) {
    int freePos = findFirstFreePos(list);
    if (freePos != -1) {
        list.set(freePos, pass);
        return true;
    }
    return false;
    
    
}

private static boolean removeFromList(String name, List<Pass> list) {
        int index = findByName(name, list);
        if (index != -1) {
            list.set(index, null);
            return true;
        }
        return false;
    }


    public boolean insert(Pass pass) {
        if (findByName(pass.getName(), this.prioritySeats) != -1 || findByName(pass.getName(), this.normalSeats) != -1){
            System.out.println("fail: " + pass.getName() + " ja esta na topic");
            return false;
        }
        if(pass.isPriority()){
            if(insertOnList(pass, this.prioritySeats)){
                return true;
            }
            if(insertOnList(pass, this.normalSeats)) {
                return true;
            }
            return false;
        } else {
            if(insertOnList(pass, this.normalSeats)) {
                return true;
            }
            if(insertOnList(pass, this.prioritySeats)){
                return true;
            }
            System.out.println("fail: topic lotada");
            return false;
        }
    }

    public boolean remove(String name) {
        if(removeFromList(name, this.prioritySeats)){
            return true;
        }

        if(removeFromList(name, this.normalSeats)){
            return true;
        }
        System.out.println("fail: " + name + " nao esta na topic");
        return false;
    }
    
    public String toString() {
    return "[" + Stream.concat(
        this.prioritySeats.stream().map(p -> ("@" + ((p == null) ? "" : p))),
        this.normalSeats.stream().map(p -> ("=" + ((p == null) ? "" : p))))
        .collect(Collectors.joining(" ")) + "]";
}

}

/*
 * topicMapString = "[";
        for(int i = 0; i < qtdPriority; i++){
            topicMapString += "@ ";
        }
        for (int i = 0; i < capacity - qtdPriority; i++){
            topicMapString += i == capacity - qtdPriority - 1 ? "=" : "= ";
        }
        topicMapString += "]";
 */