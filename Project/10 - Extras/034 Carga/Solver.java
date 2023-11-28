import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solver {
    private static Scanner in = new Scanner(System.in);
    private static Trem trem;

    public static void Solver(String[] args) throws FileNotFoundException {
        while (true) {
            try {
                String line = input();
                System.out.println("$" + line);
                String[] arg = line.split(" ");

                switch (arg[0]) {
                    case "end":
                        return;

                    case "init":
                        trem = new Trem(numberInt(arg[1]));
                        break;

                    case "nwvp":
                        trem.addVagao(numberInt(arg[1]));
                        break;

                    case "nwvc":
                        trem.addCargo(numberFloat(arg[1]));
                        break;

                    case "addp":
                        trem.embarcar(arg[1]);
                        break;

                    case "addc":
                        trem.addItem(arg[1], numberFloat(arg[2]));
                        break;

                    case "la":
                        System.out.println(trem);
                        break;

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
                        trem.desembarcar(arg[1]);
                        break;

                    default:
                        System.out.println("fail: comando invalido");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String input() {
        return in.nextLine();
    }

    private static int numberInt(String num) {
        return Integer.parseInt(num);
    }

    private static float numberFloat(String num) {
        return Float.parseFloat(num);
    }
}