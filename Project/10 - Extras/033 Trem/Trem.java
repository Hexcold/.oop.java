import java.util.ArrayList;
import java.util.Arrays;

public class Trem {
    private ArrayList<Vagao> vagoes;
    private int maxCapacidade;
    private String movimentacao = "";
    private String cadastro = "";

    Trem(int capacidade) {
        vagoes = new ArrayList<>();
        maxCapacidade = capacidade;
    }

    public void addVagao(int capacidade) {
        if (vagoes.size() >= maxCapacidade) {
            throw new RuntimeException("fail: limite de vagões atingido");
        }

        vagoes.add(new Vagao(capacidade));
    }

    public void desembarcar(String nome) {
        int indexVagao = -1;
        int indexPassageiro = -1;

        search: for (Vagao i : vagoes) {
            for (Passageiro j : i.getPassageiros()) {
                if (j.getNome().equals(nome)) {
                    indexVagao = vagoes.indexOf(i);
                    indexPassageiro = i.getPassageiros().indexOf(j);

                    break search;
                }
            }
        }

        if (indexPassageiro == -1) {
            throw new RuntimeException("fail: " + nome + " nao esta no trem");
        }

        vagoes.get(indexVagao).desembarcar(nome, indexPassageiro);
        movimentacoes(nome, "out");
    }

    public void embarcar(String nome) {
        int indexVagao = -1;
        int indexPassageiro = -1;

        search: for (Vagao i : vagoes) {
            for (Passageiro j : i.getPassageiros()) {
                if (j.getNome().equals(nome)) {
                    throw new RuntimeException("fail: " + nome + " já está no trem");
                }

                if (j.getNome().equals("-")) {
                    indexVagao = vagoes.indexOf(i);
                    indexPassageiro = i.getPassageiros().indexOf(j);

                    break search;
                }
            }
        }

        cadastro(nome);

        if (indexPassageiro == -1) {
            throw new RuntimeException("fail: trem lotado");
        }

        vagoes.get(indexVagao).embarcar(nome, indexPassageiro);
        movimentacoes(nome, "in");
    }

    private void movimentacoes(String nome, String tipo) {
        if (!movimentacao.isBlank()) {
            movimentacao += "\n";
        }

        movimentacao += nome + " " + tipo;
    }

    private void cadastro(String nome) {
        if (cadastro.contains(nome)) {
            return;
        }

        if (!cadastro.isBlank()) {
            cadastro += "\n";
        }

        cadastro += nome;
    }

    @Override
    public String toString() {
        String str = "";

        for (Vagao i : vagoes) {
            str += "[" + i + "]";
        }

        if (str.equals("")) {
            str = "[]";
        }

        return "Trem " + str;
    }

    public String getCadastro() {
        String[] temp = cadastro.split("\n");

        Arrays.sort(temp);

        cadastro = String.join("\n", temp);

        return cadastro;
    }

    public String getMovimentacao() {
        return movimentacao;
    }
}