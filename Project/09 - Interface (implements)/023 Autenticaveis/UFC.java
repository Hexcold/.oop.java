import java.util.Map;
import java.util.TreeMap;

public class UFC {
    private Map<String, Funcionario> funcionarios;
    private Map<String, Aluno> alunos;

    public UFC() {
        this.funcionarios = new TreeMap<String, Funcionario>();
        this.alunos = new TreeMap<String, Aluno>();
    }

    @Override
    public String toString() {
        String s = "";
        for (Funcionario f : this.funcionarios.values()) {
            s += f + "\n";
        }
        for (Aluno a : this.alunos.values()) {
            s += a + "\n";
        }
        return s;
    }

    public Funcionario getFuncionario(String nome) {
        return this.funcionarios.get(nome);
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.put(funcionario.getNome(), funcionario);
    }

    public void rmFuncionario(String nome) {
        this.funcionarios.remove(nome);
    }

    public void setBonus(int bonus) {
        if (this.funcionarios.size() == 0) {
            throw new MsgException("fail: sem funcionarios");
        }

        int eachBonus = bonus / this.funcionarios.size();
        for (Funcionario f : this.funcionarios.values()) {
            f.setBonus(eachBonus);
        }
    }

    public Aluno getAluno(String nome) {
        return this.alunos.get(nome);
    }

    public void addAluno(Aluno aluno) {
        this.alunos.put(aluno.getNome(), aluno);
    }

    public void rmAluno(String nome) {
        this.alunos.remove(nome);
    }
}