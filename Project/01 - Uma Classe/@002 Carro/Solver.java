/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    -Fiz sozinho
O que aprendeu?
    - Aprendi melhor sobre a comunicação dos parâmetros e as variáveis com this. Além do funcionamento do shell
Quanto tempo levou?
    - 2 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.*;

public class Solver {
    public static void main(String[] arg) {
        Car car = new Car();

        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            switch (args[0]){
                case "end":
                    return;
                case "show":
                    System.out.println(car);
                    break;
                case "enter":
                    car.enter();
                    break;
                case "leave":
                    car.leave();
                    break;
                case "drive":
                    car.drive((int) number(args[1]));
                    break;
                case "fuel":
                    car.fuel((int) number(args[1]));
                    break;
                default:
                    write("fail: comando invalido");
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

    static void write(String value) {
        System.out.println(value);
    }
}
