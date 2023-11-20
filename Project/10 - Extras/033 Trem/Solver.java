import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solver {

    private static Trem trem;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        while (true) {
            String line = input();
            System.out.println("$" + line);
            String[] arg = line.split(" ");

            try {
                switch (arg[0]) {
                    case "end":
                        System.exit(0);
                        return;

                    case "init":
                        trem = new Trem(Integer.parseInt(arg[1]));
                        break;

                    case "nwvag":
                        trem.addVagao(Integer.parseInt(arg[1]));
                        break;

                    case "entrar":
                        trem.embarcar(arg[1]);
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

}