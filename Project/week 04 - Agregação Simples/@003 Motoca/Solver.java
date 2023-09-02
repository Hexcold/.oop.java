/*
O que fez?
    Fiz tudo e passou em todos os testes
Com quem fez?
    Fiz a maior parte sozinho. Mas tive ajuda do Joasi, para entender o método “drive” (Era apenas a ordem  dos if). E o Josias me explicou que dava para retornar uma metodo de outra class no toString
O que aprendeu?
    prendi um pouco mais referente a interação entre duas classes, ademais
Quanto tempo levou?
    2 hora (não sei exatamente, isso é uma especulação )
*/

import java.util.*;

class Solver {
    static Motorcycle motoca = new Motorcycle(1);

    public static void main(String[] args) {
        while (true) {
            String line = input();
            args = line.split(" ");
            write('$' + line);

            switch (args[0]){
                case "end":
                    return;
                case "show":
                    System.out.println(motoca);
                    break;
                case "init":
                    motoca = new Motorcycle(number(args[1]));
                    break;
                case "buy":
                    motoca.buy(number(args[1]));
                    break;
                case "drive":
                    motoca.drive(number(args[1]));
                    break;
                case "enter":
                    motoca.enter(new Person(args[1], number(args[2])));
                    break;
                case "honk":
                    motoca.honk();
                    break;
                case "leave":
                    Person person = motoca.leave();
                    if (person != null) {
                        System.out.println(person.toString());
                        break;
                    }
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

    public static int number(String str) {
        return Integer.parseInt(str);
    }
}