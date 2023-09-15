import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Topic {
    private List<Pass> prioritySeats;
    private List<Pass> normalSeats;

    public Topic(int capacity, int qtdPriority) {
        this.prioritySeats = new ArrayList<Pass>(qtdPriority);
        this.normalSeats = new ArrayList<Pass>(capacity);
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
        if (findFirstFreePos(list) != 1) {
            list.set(findFirstFreePos(list), pass);

            return true;
        }
        return false;
    }

    private static boolean removeFromList(String name, List<Pass> list) {
            if (findByName(name, list) != 1) {
                list.remove(findByName(name, list));
                return true;
            }
            return false;
    }


    public boolean insert(Pass pass) {
        if (findByName(pass.getName(), this.prioritySeats) != -1 || findByName(pass.getName(), this.normalSeats) != -1){
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
        return false;
    }

    public String toString() {
        return "[" + Stream.concat(
            this.prioritySeats.stream().map(p -> ("@" + ((p == null)?(""):("" + p)))), 
            this.normalSeats.stream().map(p -> ("=" + ((p == null)?(""):("" + p)))))
            .collect(Collectors.joining(" ")) + "]";
    }
}