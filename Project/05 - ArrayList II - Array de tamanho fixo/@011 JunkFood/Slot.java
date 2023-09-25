class Slot {
    private String name;
    private float price;
    private int quantity;
    
    public Slot( String name, float price, int quantity ) {
    }
    
    public String toString() {
        return String.format("%8s",this.name) + " : " +
               this.quantity + " U : " +
               Solver.decForm.format(this.price) + " RS";
    }
}
