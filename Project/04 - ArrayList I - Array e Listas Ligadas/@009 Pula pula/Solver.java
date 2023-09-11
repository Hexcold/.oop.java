/*
O que fez?
    Fiz tudo e passou em todos os testes
Com quem fez?
    Fiz sozinho.
O que aprendeu?
    Entendi melhor o como realizar de maneira mais específica a adição ou remoção no início e no fim de um LinkedList.
Quanto tempo levou?
    1 horas (não sei exatamente, isso é uma especulação )
*/

import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trampoline tramp = new Trampoline();

        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");

            switch (ui[0]) {
                case "end":
                    return;

                case "arrive":
                    tramp.arrive(new Kid(ui[1], Integer.parseInt(ui[2])));
                    break;

                case "enter":
                    tramp.enter();
                    break;

                case "leave":
                    tramp.leave();
                    break;

                case "remove":
                    tramp.remoteKid(ui[1]);
                    break;

                case "show":
                    System.out.println(tramp);
                    break;

                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
    }
}
