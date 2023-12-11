public class Moto extends Veiculo { // classe Moto herda de Veiculo

    public Moto(String id) { // construtor da classe Moto
        super(id, "moto"); // chama o construtor da classe Veiculo
    }

    @Override // sobrescreve o método calcularValor da classe Veiculo
    public double calcularValor(int horaSaida) { // retorna o valor a ser pago
        return (horaSaida - getEntrada()) / 20.0; // valor é calculado com base no tempo de permanência
    }
}