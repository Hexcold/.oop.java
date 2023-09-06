/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - Fiz sozinho
O que aprendeu?
    - Mais prática, visto que a guide já veio praticamente pronta, acabei tendo o trabalho apenas de modificação de pequenas coisas
Quanto tempo levou?
    - 1 hora (não sei exatamente, isso é uma especulação)
*/

import java.util.*;

public class Solver {

    public static void main(String[] _args) {
        Animal animal = new Animal("", "");

        while (true) {
            var line = input();
            var args = line.split(" ");
            write("$" + line);

            switch (args[0]){
                case "end":
                    return;
                case "init":
                    animal = new Animal(args [1], args[2]);
                    break;
                case "grow":
                    animal.envelhecer((int) number(args[1]));
                    break;
                case "noise":
                    write(animal.fazerBarulho());
                    break;
                case "show":
                    write(animal.toString());
                    break;
                default:
                    write("fail: comando invalido");
                    break;
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static void write(String value) {
        System.out.println(value);
    }

    public static double number(String str) {
        return Double.parseDouble(str);
    }
}