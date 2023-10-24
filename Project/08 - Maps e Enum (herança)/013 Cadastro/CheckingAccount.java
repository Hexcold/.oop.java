public class CheckingAccount extends Account {
    protected double monthlyFee;

    public CheckingAccount(String clientId) {
        super(clientId, "CC");
        this.monthlyFee = 20.0;
    }

    @Override
    public void updateMonthly() {
        this.balance -= this.monthlyFee;
    }
}