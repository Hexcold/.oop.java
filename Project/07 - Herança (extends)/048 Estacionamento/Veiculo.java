public abstract class Veiculo { // classe abstrata Veiculo
    protected String id; // id será o nome do dono da bike ou a placa do carro/moto
    protected String tipo; // tipo será "bike", "carro" ou "moto"
    protected int horaEntrada; // hora de entrada do veiculo no estacionamento
    protected boolean pago; // true se o veiculo já foi pago, false caso contrário

    public Veiculo(String id, String tipo) { // construtor da classe Veiculo
        this.id = id; // inicializa o id do veiculo
        this.tipo = tipo; // inicializa o tipo do veiculo
        this.horaEntrada = 0; // inicializa a hora de entrada do veiculo
        this.pago = false; // inicializa a variável pago como false
    }

    public void setEntrada(int horaEntrada) { // salva a hora de entrada
        this.horaEntrada = horaEntrada;
    }

    public int getEntrada() { // retorna a hora de entrada
        return this.horaEntrada;
    }

    public String getTipo() { // retorna o tipo do veiculo
        return this.tipo;
    }

    public String getId() { // retorna o id do veiculo
        return this.id;
    }

    public boolean estaPago() { // retorna true se o veiculo já foi pago, false caso contrário
        return this.pago;
    }

    public void efetuarPagamento() { // efetua o pagamento
        this.pago = true;
    }

    // Retorna o valor a ser pago
    public abstract double calcularValor(int horaSaida); // retorna o valor a ser pago (método abstrato)

    // Retorna comprovante de pagamento
    public String getComprovante(int horaSaida) { // retorna comprovante de pagamento
        String s = ""; // inicializa a variável s como string vazia
        s += String.format("%8s", this.tipo) + " " + String.format("%8s", this.id); // concatena o tipo e o id do veiculo
        s += " chegou " + String.format("%3d", this.horaEntrada); // concatena a hora de entrada do veiculo
        s += " e saiu " + String.format("%3d", horaSaida) + " | "; // concatena a hora de saída do veiculo
        s += "pago R$ " + String.format("%.2f", calcularValor(horaSaida)); // concatena o valor pago pelo veiculo
        return s; // retorna o comprovante de pagamento
    }

    @Override // sobrescreve o método toString
    public String toString() { // retorna uma string com os dados do veiculo
        return String.format("%10s : %8s : %3d : %s", this.tipo, this.id, this.horaEntrada, // concatena o tipo, o id e a hora de entrada do veiculo
                this.estaPago() ? "pago" : "pendente"); // concatena o status do veiculo
    }
}

// Obs.: Caso não saiba usar maps e decida usar uma lista de veiculos, já perde
// 1 ponto, mas torna possível a resolução completa da questão
// Usando lista, será necessário um método para procurar um veiculo na lista
// pelo seu id
