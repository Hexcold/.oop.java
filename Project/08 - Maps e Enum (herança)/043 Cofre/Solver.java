/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - Fiz só, mas confirmei algumas dúvidas no código do professor 
O que aprendeu?
tive um entendimento melhor sobre a funcionalidade da interface, principalmente quando utilizamos enum
Quanto tempo levou?
    - 1 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Pig pig = new Pig(5);

        while (true) {
            String line = input();
            println("$" + line);
            String[] arg = line.split(" ");

            try {

                switch (arg[0]) {
                    case "end":
                        return;

                    case "init":
                        pig = new Pig((int) number(arg[1]));
                        break;

                    case "show":
                        println(pig);
                        break;

                    case "addCoin":
                        pig.addValuable(pig.createCoin(arg[1]));
                        break;

                    case "addItem":
                        pig.addValuable(new Item(arg[1], number(arg[2]), (int) number(arg[3])));
                        break;

                    case "break":
                        pig.breakPig();
                        break;

                    case "extractCoins":
                        println("[" + String.join(", ", pig.extractCoins()) + "]");
                        break;

                    case "extractItems":
                        println("[" + String.join(", ", pig.extractItems()) + "]");
                        break;

                    default:
                        println("fail: comando invalido");
                        break;
                }
            } catch (Exception e) {
                println(e.getMessage());
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
