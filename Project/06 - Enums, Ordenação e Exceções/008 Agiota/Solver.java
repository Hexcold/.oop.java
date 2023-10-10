/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - O Marcos Vitor me deu uma ajuda para ter o entendimento da questão e do código. Ademais, eu realizei algumas pesquisas para conseguir compreender cada elemento novo que veio a ser necessário nessa questão, ao fim consegui fazer tudo funcionar.
O que aprendeu?
    - Eu melhorei meu entendimento sobre o assunto de enums, mesmo assim num acredito ter tido grande avanço no assunto em sua totalidade. Ainda preciso estudar mais sobre o mesmo. O tempo para enviar a questão também me atrapalhou, pois deixei de lado tentar aprender ainda mais sobre para tentar enviar o quanto antes possível. 
Quanto tempo levou?
    - 4 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.*;

public class Solver {
    public static void main(String[] arg) {
        Agiota agiota = new Agiota();

        while (true) {
            String line = input();
            println("$" + line);
            String[] args = line.split(" ");

            try {
                switch (args[0]) {

                    case "end":
                        return;

                    case "init":
                        agiota = new Agiota();
                        break;

                    case "show":
                        print(agiota);
                        break;

                    case "showCli":
                        print(agiota.getClient(args[1]));
                        break;

                    case "addCli":
                        agiota.addClient(args[1], (int) number(args[2]));
                        break;

                    case "give":
                        agiota.give(args[1], (int) number(args[2]));
                        break;

                    case "take":
                        agiota.take(args[1], (int) number(args[2]));
                        break;

                    case "kill":
                        agiota.kill(args[1]);
                        break;

                    case "plus":
                        agiota.plus();
                        break;

                    default:
                        println("fail: comando invalido");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
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