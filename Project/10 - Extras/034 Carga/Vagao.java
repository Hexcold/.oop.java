import java.util.ArrayList;

public class Vagao {
    private ArrayList<Passageiro> passageiros;
    private int maxCapacidade;

    Vagao(int capacidade) {
        passageiros = new ArrayList<>();
        maxCapacidade = capacidade;

        for (int i = 0; i < capacidade; i++) {
            passageiros.add(new Passageiro("-"));
        }
    }

    public void embarcar(String nome, int indexPassageiro) {
        passageiros.set(indexPassageiro, new Passageiro(nome));
    }

    public void desembarcar(String nome, int indexPassageiro) {
        passageiros.set(indexPassageiro, new Passageiro("-"));
    }

    @Override
    public String toString() {
        String str = " ";

        for (Passageiro i : passageiros) {
            str += i + " ";
        }

        return str;
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }
}