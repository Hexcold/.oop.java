/*
O que fez?
    - Fiz tudo e passou em todos os testes.
Com quem fez?
    - Fiz só, mas confirmei algumas dúvidas no código do professor 
O que aprendeu?
    - Aprendi sobre extends
Quanto tempo levou?
    - 1 horas (não sei exatamente, isso é uma especulação)
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<Shape>();

        while (true) {
            String line = input();
            println("$" + line);
            String[] arg = line.split(" ");

            if (arg[0].equals("end")) {
                break;
            }
            else if (arg[0].equals("circle")) {
                shapes.add(new Circle(new Point2D(number(arg[1]), number(arg[2])), number(arg[3])));
            } else if (arg[0].equals("rect")) {
                shapes.add(new Rectangle(new Point2D(number(arg[1]), number(arg[2])),
                        new Point2D(number(arg[3]), number(arg[4]))));
            }
            else if (arg[0].equals("show")) {
                showAll(shapes);
            } else if (arg[0].equals("info")) {
                infoAll(shapes);
            } else {
                println("fail: comando invalido");
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

    public static void println(Object value) {
        System.out.println(value);
    }

    public static void print(Object value) {
        System.out.print(value);
    }

    public static void infoAll(ArrayList<Shape> shapes) {
        for (Shape s : shapes)
            println(s.getInfo());
    }

    public static void showAll(ArrayList<Shape> shapes) {
        for (Shape s : shapes) {
            println(s.toString());
        }
    }

}
