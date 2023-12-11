public class Carro extends Veiculo { // classe Carro herda de Veiculo

    public Carro(String id) { // construtor da classe Carro
        super(id, "carro"); // chama o construtor da classe Veiculo
    }

    @Override // sobrescreve o método calcularValor da classe Veiculo
    public double calcularValor(int horaSaida) { // retorna o valor a ser pago
        double valor = (horaSaida - getEntrada()) / 10; // valor é calculado com base no tempo de permanência
        if (valor < 5) { // valor mínimo é 5.00 reais
            return 5.00; // retorna 5.00 reais
        }
        return valor; // retorna o valor calculado
    }
}