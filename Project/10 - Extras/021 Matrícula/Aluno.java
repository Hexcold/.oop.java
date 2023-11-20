import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aluno {
    String id;
    Map<String, Discp> disp;

    Aluno(String id) {
        this.id = id;
        this.disp = new HashMap<String, Discp>();
    }

    public String getId() {
        return id;
    }

    public List<Discp> getDisp() {
        return new ArrayList<Discp>(disp.values()); // Construtor de cópia para coleções
    }

    public void addDiscp(Discp discp) {
        disp.put(discp.getId(), discp);
    }

    public void rmDisp(String id) {
        disp.remove(id);
    }

    @Override
    public String toString() {
        ArrayList<Discp> disp = new ArrayList<Discp>(this.disp.values());
        Collections.sort(disp, (d1, d2) -> d1.getId().compareTo(d2.getId()));
    
        String saida = id + " [";
        for(int i = 0; i < disp.size(); i++) {
            if (i == disp.size() - 1) {
                saida += disp.get(i).getId();
            } else {
                saida += disp.get(i).getId() + ", ";
            }
        }
        saida += "]";
        return saida;
    }
}