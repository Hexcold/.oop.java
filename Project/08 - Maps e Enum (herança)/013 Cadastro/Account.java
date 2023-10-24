import java.text.DecimalFormat;

public abstract class Account {
    protected double balance;
    private static int nextAccountId = 0;
    protected int accId;
    protected String clientId;
    protected String typeId;

    public Account(String clientId, String typeId) {
        this.balance = 0;
        this.accId = nextAccountId++;
        this.clientId = clientId;
        this.typeId = typeId;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) throws Exception {
        if (value > this.balance) {
            throw new Exception("fail: saldo insuficiente");
        }

        this.balance -= value;
    }

    public void transfer(Account other, double value) throws Exception {
        this.withdraw(value);
        other.deposit(value);
    }

    @Override
    public String toString() {
        // 0:Almir:0.00:CC
        DecimalFormat df = new DecimalFormat("0.00"); // double x = 4.3; System.out.println( d.format(x) ); //4.30
        return this.accId + ":" + this.clientId + ":" + df.format(this.balance) + ":" + this.typeId + "\n";

    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccId() {
        return this.accId;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public abstract void updateMonthly();
}