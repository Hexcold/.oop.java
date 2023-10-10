import java.util.*;

public class Client {
    private String name;
    private int limite;
    private ArrayList<Operation> operations;

    public Client(String name, int limite) {
        this.name = name;
        this.limite = limite;
        this.operations = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getLimite() {
        return this.limite;
    }

    public ArrayList getOperations() {
        return this.operations;
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public int getBalance() {
        int retorno = 0;
        for (Operation o : this.operations) {
            if (o.getLabel() == Label.TAKE) {
                retorno -= o.getValue();
            } else {
                retorno += o.getValue();
            }
        }
        return retorno;
    }

    @Override
    public String toString() {
        String saida = this.name + " " + this.getBalance() + "/" + this.limite + "\n";
        for (Operation o : this.operations) {
            saida += o + "\n";
        }
        return saida;
    }
}