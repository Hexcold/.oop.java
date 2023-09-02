/*
O que fez?
    - Fiz tudo e passou em todos os testes
Com quem fez?
    - Tive a ajuda do Josias para entender que deveria inicializar até mesmo as variáveis máximas no construtor (fora que demorei para me tocar que deveria inicializar a variável booleana, acreditava que ela já vinha como true). Além da ajuda do Carlos para perceber um erro que estava cometendo nos métodos do tipo booleano.
O que aprendeu?
    - Aprendi que devo inicializar até as variáveis do tipo booleano. E aprendi um pouco mais o funcionamento dos get e set (principalmente quando usados juntos).
Quanto tempo levou?
    - 4 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.*;

public class Solver {
    public static void main(String[] a) {
        Pet pet = new Pet(0, 0, 0);

        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            switch (args[0]){
                case "end":
                    return;
                case "show":
                    write((pet.toString()));
                    break;
                case "init":
                    pet = new Pet((int) number(args[1]), (int) number(args[2]), (int) number(args[3]));
                    break;
                case "play":
                    pet.play();
                    break;
                case "eat":
                    pet.eat();
                    break;
                case "sleep":
                    pet.sleep();
                    break;
                case "shower":
                    pet.shower();
                    break;
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