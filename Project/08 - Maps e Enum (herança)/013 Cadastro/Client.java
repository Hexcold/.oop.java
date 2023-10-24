import java.util.ArrayList;

public class Client {
    protected String clientId;
    protected ArrayList<Account> accounts;

    public Client(String clientId) {
        this.clientId = clientId;
        this.accounts = new ArrayList<Account>();
    }

    public void addAccount(Account acc) {
        this.accounts.add(acc);
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public String getClientId() {
        return this.clientId;
    }

    @Override
    public String toString() {
        return this.clientId + " [" + this.accounts.get(0).getAccId() + ", " + this.accounts.get(1).getAccId() + "]\n";
    }
}