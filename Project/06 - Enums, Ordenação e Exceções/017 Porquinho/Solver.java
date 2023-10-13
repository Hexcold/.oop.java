/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - Fiz só, mas tive que pesquisar muita coisa.
O que aprendeu?
    - Aprendi um pouco mais sobre enum
Quanto tempo levou?
    - 2 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.Scanner;

public class Solver {
    public static void main(String[] arg) throws Exception {
        Pig pig = new Pig(5);

        while (true) {
            String line = input();
            println("$" + line);
            String[] args = line.split(" ");

            switch (args[0]) {
                case "end":
                    return;

                case "init":
                    pig = new Pig((int) number(args[1]));
                    break;

                case "show":
                    println(pig);
                    break;

                case "addCoin":
                    pig.addCoin(pig.createCoin(args[1]));
                    break;

                case "addItem":
                    pig.addItem(new Item(args[1], (int) number(args[2])));
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
