import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Sistema sis = new Sistema();

        while (true) {
            String line = input();
            println("$" + line);
            String[] arg = line.split(" ");

            try {

                switch (arg[0]) {
                    case "end":
                        return;

                    case "addProf":
                        sis.getUFC().addFuncionario(new Professor(arg[1], arg[2]));
                        break;

                    case "addSta":
                        sis.getUFC().addFuncionario(new STA(arg[1], (int) number(arg[2])));
                        break;

                    case "addAlu":
                        sis.getUFC().addAluno(new Aluno(arg[1], arg[2],(int) number(arg[3])));
                        break;

                    case "addTer":
                        sis.getUFC().addFuncionario(new Terceirizado(arg[1], (int) number(arg[2]), arg[3]));
                        break;

                    case "rm":
                        sis.getUFC().rmFuncionario(arg[1]);
                        break;

                    case "showAll":
                        print(sis.getUFC());
                        break;


                    case "show":
                        println(sis.getUFC().getFuncionario(arg[1]));
                        break;

                    case "addDiaria":
                        sis.getUFC().getFuncionario(arg[1]).addDiaria();
                        break;

                    case "setBonus":
                        sis.getUFC().setBonus((int) number(arg[1]));
                        break;

                    default:
                        println("fail: comando invalido");
                        break;
                }

            } catch (MsgException me) {
                println(me.getMessage());
                // e.printStackTrace(System.out);
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    private static String input() {
        return scanner.nextLine();
    }

    private static double number(String value) {
        return Double.parseDouble(value);
    }

    public static void println(Object value) {
        System.out.println(value);
    }

    public static void print(Object value) {
        System.out.print(value);
    }
}
