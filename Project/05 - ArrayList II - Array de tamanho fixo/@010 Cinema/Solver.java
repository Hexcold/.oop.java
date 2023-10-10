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

    class Solver {
        public static void main(String args[]) {
            Sala sala = new Sala(0);

            while (true) {
                String line = sc.nextLine();
                String[] argsL = line.split(" ");
                System.out.println('$' + line);

                switch (argsL[0]) {

                    case "end":
                        return;

                    case "init":
                        sala = new Sala(getInt(argsL[1]));
                        break;

                    case "show":
                        System.out.println(sala);
                        break;

                    case "reservar":
                        sala.reservar(argsL[1], argsL[2], getInt(argsL[3]));
                        break;

                    case "cancelar":
                        sala.cancelar(argsL[1]);
                        break;

                    default:
                        System.out.println("fail: comando invalido");
                        break;
                }
            }
        }

        static Scanner sc = new Scanner(System.in);

        static int getInt(String pos) {
            return Integer.parseInt(pos);
        }
    }
