import java.util.Scanner; // Scanner é uma classe que permite ler dados do teclado

public class Solver { // classe Solver
    public static void main(String[] arg) { // método main
        Estacionamento estac = new Estacionamento(); // cria um estacionamento

        while (true) { // loop infinito
            try { // tenta executar o bloco de código
                String line = input(); // lê uma linha do teclado
                println("$" + line); // imprime a linha lida
                String[] args = line.split(" "); // separa a linha lida em um array de strings

                if (args[0].equals("end")) { // verifica se o comando é end
                    break; // sai do loop
                } else if (args[0].equals("show")) { // verifica se o comando é show
                    println(estac); // imprime o estacionamento
                } else if (args[0].equals("bike")) { // verifica se o comando é bike
                    estac.estacionar(new Bike(args[1])); // estaciona a bike no estacionamento
                } else if (args[0].equals("moto")) { // verifica se o comando é moto
                    estac.estacionar(new Moto(args[1])); // estaciona a moto no estacionamento
                } else if (args[0].equals("carro")) { // verifica se o comando é carro
                    estac.estacionar(new Carro(args[1])); // estaciona o carro no estacionamento
                } else if (args[0].equals("tempo")) { // verifica se o comando é tempo
                    estac.passarTempo((int) number(args[1])); // incrementa a hora atual
                } else if (args[0].equals("pagar")) { // verifica se o comando é pagar
                    println(estac.pagar(args[1])); // imprime o comprovante de pagamento do veiculo
                } else if (args[0].equals("pagarTodos")) { // verifica se o comando é pagarTodos
                    print(estac.pagarTodos()); // imprime os comprovantes de pagamento de todos os veiculos
                } else if (args[0].equals("sair")) { // verifica se o comando é sair
                    estac.sair(args[1]); // remove o veiculo do estacionamento
                } else if (args[0].equals("sairTodos")) { // verifica se o comando é sairTodos
                    estac.sairTodos(); // remove todos os veiculos do estacionamento
                } else { // comando inválido
                    throw new RuntimeException("fail: comando invalido"); // lança exceção
                }

            } catch (Exception e) { // captura a exceção
                println(e.getMessage()); // imprime a mensagem de erro
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in); // cria um scanner para ler dados do teclado

    private static String input() { // lê uma linha do teclado
        return scanner.nextLine();
    }

    private static double number(String value) { // converte uma string para double
        return Double.parseDouble(value);
    }

    public static void println(Object value) { // imprime uma linha no terminal e pula uma linha
        System.out.println(value);
    }

    public static void print(Object value) { // imprime no terminal
        System.out.print(value);
    }
}
