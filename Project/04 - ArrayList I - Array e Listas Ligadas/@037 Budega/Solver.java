/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - Utilizei o chatgpt para entender como manipulações do ArrayList e o LinkedList.  
O que aprendeu?
    - Aprendi sobre a manipulação e utilização dos ArrayList e dos LinkedList.  
Quanto tempo levou?
    - 4 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.*;

public class Solver {
    public static void main(String[] args) {
        Mercantil mercantil = new Mercantil(0);

        while (true) {
            String line = input();
            String[] argsL = line.split(" ");
            
            System.out.println('$' + line);

            switch (argsL[0]) {
                case "end":
                    return;
                case "init":
                    mercantil = new Mercantil(Integer.parseInt(argsL[1]));
                    break;
                case "call":
                    mercantil.chamarNoCaixa(Integer.parseInt(argsL[1]));
                    break;
                case "finish":
                    mercantil.finalizar(Integer.parseInt(argsL[1]));
                    break;
                case "arrive":
                    mercantil.chegar(new Pessoa(argsL[1]));
                    break;
                case "show":
                    System.out.print(mercantil.toString());
                    break;
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }
}