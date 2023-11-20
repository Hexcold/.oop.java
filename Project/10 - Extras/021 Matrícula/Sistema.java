import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {
    Map<String, Aluno> alunos;
    Map<String, Discp> discp;

    Sistema() {
        this.alunos = new HashMap<String, Aluno>();
        this.discp = new HashMap<String, Discp>();
    }

    @Override
    public String toString() {
        String saida = "- alunos\n";
        List<Aluno> lista = new ArrayList<Aluno>(alunos.values());
        Collections.sort(lista, (a1, a2) -> a1.getId().compareTo(a2.getId()));
        for(Aluno aluno : lista) {
            saida += aluno + "\n";
        }
        saida += "- discps\n";
        List<Discp> lista2 = new ArrayList<Discp>(discp.values());
        Collections.sort(lista2, (d1, d2) -> d1.getId().compareTo(d2.getId()));
        for(Discp discp : lista2) {
            //Se for o ultimo nao da /n 
            saida += discp + "\n";
        }
        //remove o ultimo \n
        saida = saida.substring(0, saida.length() - 1);
        return saida;
    }

    public void addAluno(String idAluno) {
        alunos.put(idAluno, new Aluno(idAluno));
    }

    public void addDiscp(String idDiscp) {
        discp.put(idDiscp, new Discp(idDiscp));
        
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<Aluno>(alunos.values());
    }

    public List<Discp> getDiscp() {
        return new ArrayList<Discp>(discp.values());
    }

   public void matricular(String idAluno, String idDiscp) {
        Aluno aluno = alunos.get(idAluno);
        Discp discp = this.discp.get(idDiscp);
        aluno.addDiscp(discp);
        discp.addAluno(aluno);
    }

    public void desmatricular(String idAluno, String idDiscp) {
        Aluno aluno = alunos.get(idAluno);
        Discp discp = this.discp.get(idDiscp);
        aluno.rmDisp(idDiscp);
        discp.rmAluno(idAluno);
    }

    public void removerAluno(String idAluno) {
        Aluno aluno = alunos.get(idAluno);
        for(Discp discp : aluno.getDisp()) {
            discp.rmAluno(idAluno);
        }
        alunos.remove(idAluno);
    }

    public void removerDiscp(String idDiscp) {
        Discp discp = this.discp.get(idDiscp);
        for(Aluno aluno : discp.getAlunos()) {
            aluno.rmDisp(idDiscp);
        }
        this.discp.remove(idDiscp);
    }
}