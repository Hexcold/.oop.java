import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Slot> slots;
    private float profit;
    private float cash;
    private int capacity;
    
    public VendingMachine( int capacity ) {
    }

    private boolean indiceInvalido( int ind ) {
        if ( ind < 0 || ind >= this.slots.size() ) {
            return true;
        }
        return false;
    }

    public Slot getSlot( int ind ) {
        if ( this.indiceInvalido(ind) ) {
            return null;
        }

        return this.slots.get(ind);
    }
    public void setSlot( int ind, Slot slot ) {
    }
    public void clearSlot( int ind ) {
    }

    public float withdrawCash() {
        Solver.println("voce recebeu " + Solver.decForm.format(this.cash) + " RS");
    }
    public float getProfit() {
    }

    public void buyItem( int ind ) {
    }

    public String toString() {
        String s = "saldo: " + Solver.decForm.format(this.cash) + "\n";
        for (int i=0; i<this.slots.size(); i++) {
            Slot slot = this.getSlot(i);
            s += i + " [" + slot + "]\n";

            
        }
        return s;
    }
}