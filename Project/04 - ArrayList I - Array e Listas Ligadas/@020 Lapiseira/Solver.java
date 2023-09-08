import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pencil lapiseira = new Pencil(0.5f);
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String arg[] = line.split(" ");

            switch (arg[0]) {
                case "end":
                    return;

                case "help":
                    write("init _calibre; insert _calibre _dureza _tamanho; remove; writePage _folhas");
                    break;
                
                case "init":
                    lapiseira = new Pencil(Float.parseFloat(arg[1]));
                    break;

                case "insert":
                    float thickness = Float.parseFloat(arg[1]);
                    String hardness = arg[2];
                    int size = Integer.parseInt(arg[3]);
                    lapiseira.insert(new Lead(thickness, hardness, size));
                    break;

                case "remove":
                    lapiseira.remove();
                    break;

                case "show":
                    System.out.println(lapiseira);
                    break;

                case "write":
                    lapiseira.writePage();
                    break;
                
                case "pull":
                    lapiseira.pull();
                    break;

                default:
                    write("fail: comando invalido");
                    break;
            }

        }
    }

    public static void write(String value) {
        System.out.println(value);
    }
}