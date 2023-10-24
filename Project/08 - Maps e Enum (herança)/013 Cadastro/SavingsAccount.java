public class SavingsAccount extends Account {
    protected double monthlyInteresr;

    public SavingsAccount(String clientId) {
        super(clientId, "CP");
        this.monthlyInteresr = 0.01;
    }

    @Override
    public void updateMonthly() {
        this.balance += this.monthlyInteresr * this.balance;
    }
}