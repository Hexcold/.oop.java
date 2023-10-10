import java.util.*;

public class Agiota {
    private ArrayList<Client> aliveList;
    private ArrayList<Client> deathList;
    private ArrayList<Operation> aliveOper;
    private ArrayList<Operation> deathOper;

    public Agiota() {
        this.aliveList = new ArrayList<>();
        this.aliveOper = new ArrayList<>();
        this.deathList = new ArrayList<>();
        this.deathOper = new ArrayList<>();
    }

    private int searchClient(String name) {
        for (int i = 0; i < this.aliveList.size(); i++) {
            if (this.aliveList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void pushOperation(Client client, String name, Label label, int value) {
        Operation o = new Operation(name, label, value);
        this.aliveOper.add(o);
        client.addOperation(o);
    }

    public Client getClient(String name) {
        int index = searchClient(name);
        if (index == -1) {
            return null;
        }
        return (Client) this.aliveList.get(index);
    }

    public void addClient(String name, int limite) {
        Client cliente = getClient(name);
        if (cliente != null) {
            throw new RuntimeException("fail: cliente ja existe");
        }
        this.aliveList.add(new Client(name, limite));
        this.sortAliveList();
    }

    public void give(String name, int value) {
        Client cliente = getClient(name);
        if (cliente == null)
            throw new RuntimeException("fail: cliente nao existe");
        if (cliente.getBalance() + value > cliente.getLimite())
            throw new RuntimeException("fail: limite excedido");
        this.pushOperation(cliente, name, Label.GIVE, value);
    }

    public void take(String name, int value) {
        Client cliente = getClient(name);
        if (cliente == null)
            throw new RuntimeException("fail: cliente nao existe");
        this.pushOperation(cliente, name, Label.TAKE, value);
    }

    public void kill(String name) {
        if (this.searchClient(name) == -1)
            return;
        this.deathList.add(this.aliveList.remove(this.searchClient(name)));
        for (int i = 0; i < this.aliveOper.size(); i++) {
            if (this.aliveOper.get(i).getName().equals(name)) {
                this.deathOper.add(this.aliveOper.remove(i));
                i--;
            }
        }
    }

    public void plus() {
        for (Client cliente : this.aliveList) {
            this.pushOperation(cliente, cliente.getName(), Label.PLUS, (int) Math.ceil(0.1 * cliente.getBalance()));
        }

        for (int i = this.aliveList.size() - 1; i >= 0; i--) {
            Client client = this.aliveList.get(i);
            if (client.getBalance() > client.getLimite()) {
                this.kill(client.getName());
            }
        }
    }

    private void sortDeathList() {
        this.deathList.sort(new Comparator<Client>() {
            public int compare(Client c1, Client c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
    }

    private void sortDeathOper() {
        this.deathOper.sort(new Comparator<Operation>() {
            public int compare(Operation o1, Operation o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    private void sortAliveList() {
        this.aliveList.sort(new Comparator<Client>() {
            public int compare(Client c1, Client c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
    }

    @Override
    public String toString() {
        sortAliveList();
        sortDeathList();
        sortDeathOper();

        StringBuilder sb = new StringBuilder();

        // Clientes vivos
        for (Client client : this.aliveList) {
            sb.append(":) ").append(client.getName()).append(" ").append(client.getBalance()).append("/")
                    .append(client.getLimite()).append("\n");
        }

        // Operações vivas
        for (Operation oper : this.aliveOper) {
            sb.append("+ ").append(oper).append("\n");
        }

        // Clientes mortos
        for (Client client : this.deathList) {
            sb.append(":( ").append(client.getName()).append(" ").append(client.getBalance()).append("/")
                    .append(client.getLimite()).append("\n");
        }

        // Operações mortas
        for (Operation oper : this.deathOper) {
            sb.append("- ").append(oper).append("\n");
        }

        return sb.toString();
    }

}