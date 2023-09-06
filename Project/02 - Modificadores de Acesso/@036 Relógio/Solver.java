/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - Fiz sozinho
O que aprendeu?
    - Esta questão foi mais prática do que aprendizado, pois a grande base já vinha formulada pelo guide. Meu trabalho foi maior na modificação de algumas coisas mesmo.
Quanto tempo levou?
    - 1 hora (não sei exatamente, isso é uma especulação)
*/

import java.util.*;

public class Solver {
    public static void main(String[] a) {
        Time time = new Time(0, 0, 0);

        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            switch (args[0]) {
                case "end":
                    return;
                case "show":
                    System.out.println(time);
                    break;
                case "next":
                    time.nextSecond();
                case "set":
                    time.setHour((int) number(args[1]));
                    time.setMinute((int) number(args[2]));
                    time.setSecond((int) number(args[3]));
                    break;
                case "init":
                    time = new Time((int) number(args[1]), (int) number(args[2]), (int) number(args[3]));
                default:
                    write("fail: comando invalido");
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

    static void write(String value) {
        System.out.println(value);
    }
}