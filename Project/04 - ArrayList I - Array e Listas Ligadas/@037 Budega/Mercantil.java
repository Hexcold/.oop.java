import java.util.ArrayList;
import java.util.LinkedList;

public class Mercantil {
    private ArrayList<Pessoa> caixas; // caixas do supermercado
    private LinkedList<Pessoa> esperando; // lista de clientes esperando
    // inicializa esperando como uma lista de tamanho vazio
    // inicializa caixas como um vetor de tamanho qtd_caixas com todas as posições
    // iguais a null

    Mercantil(int qtd_caixas) { // número de caixas no mercado
        this.caixas = new ArrayList<>(qtd_caixas);
        this.esperando = new LinkedList<>();

        for (int i = 0; i < qtd_caixas; i++) {
            this.caixas.add(null);
            
        }

    }

    // verifica se o indice é válido para acessar os
    public boolean validarIndice(int indice) {
        if (indice < 0 && indice >= this.caixas.size()) {
            System.out.println("fail: indice invalido");
            return false;
        }
        return true;

    }

    public void chegar(Pessoa person) {
        // estou adicionando ao final do "linkedlist"
        this.esperando.add(person);
    }

    // 1. verifica se o indice é válido
    // 2. verifica se o caixa chamado está vazio
    // 3. verifica se existe alguem na lista de espera
    // 4. se tudo estiver ok, o primeiro cliente da lista de espera é movido para
    // este caixa
    public boolean chamarNoCaixa(int indice) {

        if (indice < 0 || indice >= this.caixas.size()) {
            System.out.println("fail: indice invalido");
            return false;
        }

        if (this.esperando.isEmpty()) {
            System.out.println("fail: sem clientes");
            return false;
        }

        if (this.caixas.get(indice) == null) {
            this.caixas.set(indice, this.esperando.removeFirst());
            return true;
        }
        System.out.println("fail: caixa ocupado");
        return false;
    }

    // 1. verifica se o indice é válido
    // 2. verifica se este caixa possui um cliente
    // 3. Se tudo estiver ok, o cliente é removido do caixa e volta a ser null para
    // indicar que está vazio

    public Pessoa finalizar(int indice) {
        if (validarIndice(indice) && indice < this.caixas.size()) {
            if (this.caixas.get(indice) != null) {
                this.caixas.set(indice, null);
                return this.caixas.get(indice);
            } else {
                System.out.println("fail: caixa vazio");
                return null;
            }
        }
        System.out.println("fail: caixa inexistente");
        return null;
    }

    public String toString() {
        StringBuilder Mercantil = new StringBuilder();
        Mercantil.append("Caixas: [");

        for (int i = 0; i < this.caixas.size(); i++) {
            if (i > 0) {
                Mercantil.append(", ");
            }

            if (this.caixas.get(i) != null) {
                Mercantil.append(caixas.get(i).getNome());
            } else {
                Mercantil.append("-----");
            }
        }

        Mercantil.append("]\nEspera: [");

        for (int i = 0; i < this.esperando.size(); i++) {
            Mercantil.append(this.esperando.get(i).getNome());

            if (i < this.esperando.size() - 1) {
                Mercantil.append(", ");
            }
        }

        Mercantil.append("]\n");
        return Mercantil.toString();
    }
}