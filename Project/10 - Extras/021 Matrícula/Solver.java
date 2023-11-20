import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while (true) {
            String line = input();
            System.out.println("$"+ line);
            String[] ui = line.split(" ");

            try {
                switch (ui[0]) {
                    case "end":
                        return;
                
                    case "nwalu":
                        for (int i = 1; i < ui.length; i++) {
                            sistema.addAluno(ui[i]);
                        }
                        break;
                
                    case "nwdis":
                        for (int i = 1; i < ui.length; i++) {
                            sistema.addDiscp(ui[i]);
                        }
                        break;
                
                    case "show":
                        System.out.println(sistema);
                        break;
                
                    case "tie":
                        for (int i = 2; i < ui.length; i++) {
                            sistema.matricular(ui[1], ui[i]);
                        }
                        break;
                
                    case "untie":
                        for (int i = 2; i < ui.length; i++) {
                            sistema.desmatricular(ui[1], ui[i]);
                        }
                        break;
                
                    case "rmalu":
                        sistema.removerAluno(ui[1]);
                        break;
                
                    case "rmdis":
                        sistema.removerDiscp(ui[1]);
                        break;
                
                    default:
                        System.out.println("fail: comando invalido");
                        break;
                }
            } catch(RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    private static String input() {
        return scanner.nextLine();
    }

    public static void println(Object value) {
        System.out.println(value);
    }

    public static void print(Object value) {
        System.out.print(value);
    }
}