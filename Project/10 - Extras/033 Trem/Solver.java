import java.util.Scanner;

public class Solver {
    private static Scanner in = new Scanner(System.in);
    private static String[] userInput;
    private static Trem trem;

    public static void main(String[] args) {

        while (true) {
            String line = input();
            System.out.println("$" + line);
            userInput = line.split(" ");

            try {
                switch (userInput[0]) {
                    case "end":
                        System.exit(0);
                        break;

                    case "init":
                        trem = new Trem(toInt(userInput[1]));
                        break;

                    case "nwvag":
                        trem.addVagao(toInt(userInput[1]));
                        break;

                    case "entrar":
                        trem.embarcar(userInput[1]);
                        break;

                    case "la":
                    case "show":
                        System.out.println(trem);
                        break;

                    case "cadastro":
                        System.out.println(trem.getCadastro());
                        break;

                    case "movimentacao":
                        System.out.println(trem.getMovimentacao());
                        break;

                    case "sair":
                        trem.desembarcar(userInput[1]);
                        break;

                    default:
                        System.out.println("fail: comando invalido");
                        break;
                }
            }

            catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String input() {
        return in.nextLine();
    }

    private static int toInt(String num) {
        return Integer.parseInt(num);
    }
}