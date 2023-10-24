import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class UFC {
    private Map<String, Funcionario> funcionarios = new TreeMap<>();
    private Map<String, Integer> taxaSalarialPorClasse = new HashMap<>();

    public UFC() {
        taxaSalarialPorClasse.put("A", 3000);
        taxaSalarialPorClasse.put("B", 5000);
        taxaSalarialPorClasse.put("C", 7000);
        taxaSalarialPorClasse.put("D", 9000);
        taxaSalarialPorClasse.put("E", 11000);
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Funcionario funcionario : funcionarios.values()) {
            saida.append(funcionario).append("\n");
        }
        return saida.toString();
    }

    public Funcionario getFuncionario(String nome) {
        if (!funcionarios.containsKey(nome)) {
            throw new MsgException("fail: funcionario " + nome + " nao existe");
        }
        return funcionarios.get(nome);
    }

    public void addFuncionario(Funcionario funcionario) {
        if (funcionarios.containsKey(funcionario.getNome())) {
            throw new MsgException("fail: funcionario " + funcionario.getNome() + " já existe");
        }
        funcionarios.put(funcionario.getNome(), funcionario);
    }

    public void rmFuncionario(String nome) {
        if (!funcionarios.containsKey(nome)) {
            throw new MsgException("fail: funcionario " + nome + " nao existe");
        }
        funcionarios.remove(nome);
    }

    // reparte o bonus para todos os funcionarios
    public void setBonus(int bonus) {
        int bonusIndividual = bonus / funcionarios.size();
        for (Funcionario funcionario : funcionarios.values()) {
            funcionario.setBonus(bonusIndividual);
        }
    }
}