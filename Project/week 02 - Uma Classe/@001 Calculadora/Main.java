import java.util.*;

public class Main{
    public static void main(String[] arg){
        Calculator cal = null;

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

    }

    private static Scanner scanner = new Scanner(System.in);

    private static String input() {
        return scanner.nextLine();
    }

    private static double number(String value) {
        return Float.parseFloat(value);
    }

    private static void write(String value) {
        System.out.println(value);
    }
}