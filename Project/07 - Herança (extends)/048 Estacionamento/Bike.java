public class Bike extends Veiculo { // classe Bike herda de Veiculo

    public Bike(String id) { // construtor da classe Bike
        super(id, "bike"); // chama o construtor da classe Veiculo
    }

    @Override // sobrescreve o método calcularValor da classe Veiculo
    public double calcularValor(int horaSaida) { // retorna o valor a ser pago
        return 3.00; // valor fixo de 3.00 reais
    }
}