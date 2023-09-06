/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - Tive ajuda do Joasi na realização de alguns métodos, no entendimento da lógica da questão.  
O que aprendeu?
    - Aprendi um pouco mais sobre os métodos get e set.
Quanto tempo levou?
    - 3 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.*;

public class Solver {
    public static void main(String[] args) {
        Pencil lap = new Pencil(0.5f);

        while (true) {  
            String line = input();
            String[] argsL = line.split(" ");
            write('$' + line);
            
            switch (argsL[0]) {
                case "end":
                    return;
                case "init":
                    lap = new Pencil(number(argsL[1]));
                    break;
                case "insert":
                    lap.insert(new Lead(number(argsL[1]), argsL[2], (int) number(argsL[3])));
                    break;
                case "remove":
                    lap.remove();
                    break;
                case "write":
                    lap.writePage();
                    break;
                case "show":
                    write(lap.toString());
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

    public static float number(String str) {
        return Float.parseFloat(str);
    }
}