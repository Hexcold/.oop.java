import java.util.ArrayList;
import java.util.Arrays;

public class Trem {
    private ArrayList<Vagao> vagoes;
    private ArrayList<Cargo> cargos;
    private char[] a = new char[20];
    private int count = 0;
    private int maxCapacidade;
    private String movimentacao = "";
    private String cadastro = "";

    Trem(int capacidade) {
        vagoes = new ArrayList<>();
        cargos = new ArrayList<>();
        maxCapacidade = capacidade;
    }

    public void addVagao(int capacidade) {
        if (vagoes.size() + cargos.size() >= maxCapacidade) {
            throw new RuntimeException("fail: limite de vagões atingido");
        }

        vagoes.add(new Vagao(capacidade));
        a[count] = 'v';
        count++;
    }

    public void desembarcar(String nome) {
        for (Cargo i : cargos) {
            for (Item j : i.getItems()) {
                if (j.getName().equals(nome)) {
                    cargos.get(cargos.indexOf(i)).removeItem(i.getItems().indexOf(j));

                    movimentacoes(j.toString(), "out");
                    return;
                }
            }
        }

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

    public void addItem(String nome, float weight) {
        cadastro(nome + ":" + weight);
        cargos.get(0).addItem(nome, weight);
        movimentacoes(nome + ":" + weight, "in");
    }

    @Override
    public String toString() {
        String str = "";
        int x = 0;
        int y = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'v') {
                str += "[" + vagoes.get(x).toString() + "]";
                x++;
            }

            if (a[i] == 'c') {
                str += "(" + cargos.get(y).toString() + ")";
                y++;
            }
        }

        if (str.equals("")) {
            str = "[]";
        }

        return "Trem " + str;
    }

    public void addCargo(float capacidade) {
        if (vagoes.size() + cargos.size() >= maxCapacidade) {
            throw new RuntimeException("fail: limite de vagões atingido");
        }

        cargos.add(new Cargo(capacidade));
        a[count] = 'c';
        count++;
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