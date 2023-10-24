import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UFC ufc = new UFC();
        while (true) {
            try {
                String line = sc.nextLine();
                System.out.println("$" + line);
                String ui[] = line.split(" ");

                switch (ui[0]) {
                    case "end":
                        return;

                    case "addProf":
                        ufc.addFuncionario(new Professor(ui[1], ui[2]));
                        break;

                    case "addSta":
                        ufc.addFuncionario(new STA(ui[1], Integer.parseInt(ui[2])));
                        break;

                    case "addTer":
                        ufc.addFuncionario(new Tercerizado(ui[1], Integer.parseInt(ui[2]), ui[3]));
                        break;

                    case "rm":
                        ufc.rmFuncionario(ui[1]);
                        break;

                    case "showAll":
                        System.out.print(ufc);
                        break;

                    case "show":
                        System.out.println(ufc.getFuncionario(ui[1]));
                        break;

                    case "addDiaria":
                        ufc.getFuncionario(ui[1]).addDiaria();
                        break;

                    case "setBonus":
                        ufc.setBonus(Integer.parseInt(ui[1]));
                        break;

                    default:
                        System.out.print("fail: comando invalido");
                        break;
                }
            } catch (MsgException me) {
                System.out.println(me.getMessage());
            }
        }
    }
}