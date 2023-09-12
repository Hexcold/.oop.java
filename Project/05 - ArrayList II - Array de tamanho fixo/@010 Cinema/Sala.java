import java.util.List;
import java.util.ArrayList;

public class Sala {
    private List<Client> cadeiras;

    public Sala(int capacidade) {
        this.cadeiras = new ArrayList<>(capacidade);

        for (int i = 0; i < capacidade; i++) {
            this.cadeiras.add(null);
        }
    }

    public List<Client> getCadeiras() {
        return this.cadeiras;
    }

    public boolean reservar(String id, String fone, int ind) {
        if (verificarIndice(ind)) {
            if (this.cadeiras.get(ind) != null) {
                System.out.println("fail: cadeira ja esta ocupada");
                return false;
            }

            for (Client cliente : this.cadeiras) {
                if (cliente != null && cliente.getId().equals(id)) {
                    System.out.println("fail: cliente ja esta no cinema");
                    return false;
                }
            }

            Client cliente = new Client(id, fone);
            this.cadeiras.set(ind, cliente);
            return true;
        }
        System.out.println("fail: cadeira nao existe");
        return false;

    }

    public int procurar(String nome) {
        for (int i = 0; i < this.cadeiras.size(); i++) {
            if (this.cadeiras.get(i) != null) {
                if (this.cadeiras.get(i) == null || !this.cadeiras.get(i).equals(nome)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean verificarIndice(int ind) {
        if (ind >= 0 && ind < this.cadeiras.size()) {
            return true;
        }

        return false;
    }

    public void cancelar(String id) {
        int indice = -1;
        for (int i = 0; i < this.cadeiras.size(); i++) {
            Client cliente = this.cadeiras.get(i);
            if (cliente != null && cliente.getId().equals(id)) {
                indice = i;
                break;
            }
            System.out.println("fail: cliente nao esta no cinema");
            return;
        }

        if (indice != -1) {
            this.cadeiras.set(indice, null);
        }
    }

    public String toString() {
        StringBuilder saida = new StringBuilder("[");
        boolean adicionarEspaco = false;

        for (Client cliente : cadeiras) {
            if (adicionarEspaco) {
                saida.append(" ");
            }

            if (cliente == null) {
                saida.append("-");
            } else {
                saida.append(cliente);
            }

            adicionarEspaco = true;
        }

        saida.append("]");
        return saida.toString();
    }
}