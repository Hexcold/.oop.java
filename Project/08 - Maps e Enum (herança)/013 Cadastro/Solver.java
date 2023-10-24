/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - Fiz só, mas confirmei algumas dúvidas no código do professor 
O que aprendeu?
    - Aprendi a utilização do map
Quanto tempo levou?
    - 1 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Agency agency = new Agency();

        while (true) {
            String line = input();
            println("$" + line);
            String[] arg = line.split(" ");

            try {
                switch (arg[0]) {

                    case "end":
                        return;

                    case "show":
                        print(agency);
                        break;

                    case "addCli":
                        agency.addClient(arg[1]);
                        break;

                    case "deposito":
                        agency.deposit((int) number(arg[1]), number(arg[2]));
                        break;

                    case "saque":
                        agency.withdraw((int) number(arg[1]), number(arg[2]));
                        break;

                    case "transf":
                        agency.transfer((int) number(arg[1]), (int) number(arg[2]), number(arg[3]));
                        break;

                    case "update":
                        agency.updateMonthly();
                        break;

                    default:
                        println("fail: comando invalido");
                        break;
                }
            } catch (Exception e) {
                println(e.getMessage());
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
