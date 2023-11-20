import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discp {
    String id;
    Map<String, Aluno> alunos;

    Discp(String id) {
        this.id = id;
        this.alunos = new HashMap<String, Aluno>();
    }

    public String getId() {
        return id;
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<Aluno>(alunos.values()); 
    }

    @Override 
    public String toString() {
        ArrayList <Aluno> alunos = new ArrayList<Aluno>(this.alunos.values());
        Collections.sort(alunos, (a1, a2) -> a1.getId().compareTo(a2.getId()));
        String saida = id + " [";
        for(int i = 0; i < alunos.size(); i++) {
            if (i == alunos.size() - 1) {
                saida += alunos.get(i).getId();
            } else {
                saida += alunos.get(i).getId() + ", ";
            }
        }
        saida += "]";  
        return saida;
    }

    public void addAluno(Aluno aluno) {
        alunos.put(aluno.getId(), aluno);
    }

    public void rmAluno(String idAluno) {
        alunos.remove(idAluno);
    }
}
