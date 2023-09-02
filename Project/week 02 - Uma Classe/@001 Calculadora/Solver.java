/*
O que fez?
    - Fiz tudo e passou em todos os testes
Com quem fez?
    - Fiz tudo sozinho. Mas a substituição dos if’s, no while, por switch case, foi uma sugestão da Taynara
O que aprendeu?
    - Aprendi principalmente sobre o funcionamento do construtor dentro das classes
Quanto tempo levou?
    - 2 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.*;

public class Solver {
    public static void main(String[] arg) {
        Calculator cal = null;
        
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");
        
            switch (args[0]) {
                case "end":
                    return;
                case "init":
                    int batteryMax = (int) number(args[1]);
                    cal = new Calculator(batteryMax);
                    break;
                case "show":
                    System.out.println(cal);
                    break;
                case "charge":
                    cal.chargeBattery((int) number(args[1]));
                    break;
                case "sum":
                    cal.sum((int) number(args[1]), (int) number(args[2]));
                    break;
                case "div":
                    cal.division((int) number(args[1]), (int) number(args[2]));
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
        return Float.parseFloat(value);
    }

    static void write(String value) {
        System.out.println(value);
    }
}

/* 
 - Como era feito antes o while

while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if (args[0].equals("end")) {
                break;
            } else if (args[0].equals("init")) {
                int batteryMax = (int) number(args[1]);
                cal = new Calculator(batteryMax);
            } else if (args[0].equals("show")) {
                System.out.println(cal);
            } else if (args[0].equals("charge")) {
                cal.chargeBattery((int) number(args[1]));
            } else if (args[0].equals("sum")) {
                cal.sum((int) number((args[1])), (int) number(args[2]));
            } else if (args[0].equals("div")) { 
                cal.division((int) number(args[1]), (int) number(args[2]));
            } else {
                write("fail: comando invalido");
            }
        }
*/