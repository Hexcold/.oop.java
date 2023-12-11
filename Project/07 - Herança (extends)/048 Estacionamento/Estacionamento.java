import java.util.LinkedHashMap; // LinkedHashMap mantém a ordem de inserção
import java.util.Map; // Map é uma interface que define o comportamento de um map

public class Estacionamento { // classe Estacionamento
    private Map<String, Veiculo> veiculos; // map de veiculos
    private int horaAtual; // hora atual

    public Estacionamento() { // construtor da classe Estacionamento
        this.veiculos = new LinkedHashMap<>(); // inicializa o map de veiculos
        this.horaAtual = 0; // inicializa a hora atual
    }

    // Incrementa a hora atual
    public void passarTempo(int tempo) { // incrementa a hora atual
        this.horaAtual += tempo;
    }

    // Retorna o veiculo desejado a partir do seu id
    private Veiculo getVeiculo(String id) { // retorna o veiculo desejado a partir do seu id
        return this.veiculos.get(id);
    }

    // Apenas no caso de não usar maps, caso contrário, pode apagar esse método
    // comentado
    // // Retorna o índice do veículo na lista ou -1 se não encontrar
    // private int procurarVeiculo( String id ) {
    // }

    // Estaciona o veículo no estacionamento, salva a hora de entrada
    public void estacionar(Veiculo veiculo) { // estaciona o veiculo no estacionamento
        veiculo.setEntrada(horaAtual); // salva a hora de entrada
        this.veiculos.put(veiculo.getId(), veiculo); // adiciona o veiculo no map

    }

    // Verifica se o veículo existe no map, verifica se não está pago e retorna
    // comprovante de pagamento do veiculo
    public String pagar(String id) {
        Veiculo veiculo = this.getVeiculo(id); // retorna o veiculo desejado a partir do seu id

        try { // tenta executar o bloco de código
            if (veiculo != null) { // verifica se o veiculo existe no map
                if (!veiculo.estaPago()) { // verifica se não está pago
                    veiculo.efetuarPagamento(); // efetua o pagamento
                    return veiculo.getComprovante(this.horaAtual); // retorna comprovante de pagamento do veiculo
                } else {
                    throw new RuntimeException("fail: veiculo  " + id + " ja foi pago"); // lança exceção
                }
            } else {
                throw new RuntimeException("fail: veiculo " + id + " nao encontrado"); // lança exceção
            }

        } catch (RuntimeException e) { // captura a exceção
            return e.getMessage(); // retorna a mensagem de erro
        }
    }

    // Verifica se há algum veículo no estacionamento e retorna os comprovantes de
    // pagamento de todos os veiculos
    public String pagarTodos() { 

        StringBuilder comprovantes = new StringBuilder(); // inicializa o StringBuilder para concatenar os comprovantes
        boolean algumPendente = false; // inicializa a variável algumPendente como false

        for (Veiculo veiculo : veiculos.values()) { // percorre o map de veiculos e verifica se há algum veiculo
                                                    // pendente
            if (!veiculo.estaPago()) { // verifica se o veiculo não está pago
                veiculo.efetuarPagamento(); // efetua o pagamento
                comprovantes.append(veiculo.getComprovante(this.horaAtual)).append("\n"); // adiciona o comprovante no
                                                                                          // StringBuilder
                algumPendente = true; // altera o valor da variável algumPendente para true
            }
        }
        try {
            if (algumPendente) { // verifica se há algum veiculo pendente
                return comprovantes.toString(); // retorna os comprovantes de pagamento de todos os veiculos
            } else { // caso não haja nenhum veiculo pendente
                throw new RuntimeException("fail: nenhum veiculo encontrado\n"); // lança exceção
            }
        } catch (RuntimeException e) { // captura a exceção
            return e.getMessage(); // retorna a mensagem de erro
        }
    }

    // Verifica se o veículo existe no map, verifica se está pago e o remove
    public void sair(String id) {
        Veiculo veiculo = getVeiculo(id); // retorna o veiculo desejado a partir do seu id
        try { // tenta executar o bloco de código
            if (veiculo != null && veiculo.estaPago()) { // verifica se o veiculo existe no map e se está pago
                veiculos.remove(id); // remove o veiculo do map
            } else { // caso o veiculo não exista no map ou não esteja pago
                throw new RuntimeException("fail: veiculo  " + id + " so pode sair depois de pagar"); // lança exceção
            } 
        } catch (RuntimeException e) { // captura a exceção
            System.err.println(e.getMessage()); // retorna a mensagem de erro
        }
    }

    // Remove todos os veiculos
    public void sairTodos() { 
        this.veiculos.clear(); 
    }

    // Mostra a lista de veículos na ordem em que foram estacionados
    @Override // sobrescreve o método toString
    public String toString() { 
        StringBuilder listaVeiculos = new StringBuilder(); // inicializa o StringBuilder para concatenar os veiculos
        for (Veiculo veiculo : veiculos.values()) { // percorre o map de veiculos
            listaVeiculos.append(veiculo.toString()).append("\n"); // adiciona o veiculo no StringBuilder
        }
        listaVeiculos.append("hora atual : ").append(horaAtual); // adiciona a hora atual no StringBuilder
        return listaVeiculos.toString(); // retorna a lista de veiculos na ordem em que foram estacionados
    }
}