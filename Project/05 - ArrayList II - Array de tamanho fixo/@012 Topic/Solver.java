/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - Fiz só, mas o Rodrigo me ajudou a encontrar uns pequenos erros
O que aprendeu?
    - Aprendi um pouco mais sobre List
Quanto tempo levou?
    - 4 horas (não sei exatamente, isso é uma especulação)
*/

import java.util.*;

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Topic topic = new Topic(0, 0);
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");

            switch (ui[0]) {
                case "end":
                    return;
                    
                case "init":
                    topic = new Topic(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                    break;
                
                case "show":
                    System.out.println(topic);
                    break;

                case "in":
                    topic.insert(new Pass(ui[1], Integer.parseInt(ui[2])));
                    break;

                case "out":
                    topic.remove(ui[1]);
                    break;
                
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
    }
}