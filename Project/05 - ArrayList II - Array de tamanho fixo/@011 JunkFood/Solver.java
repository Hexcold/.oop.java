import java.text.DecimalFormat;
import java.util.Scanner; 

class Solver {
    public static void main (String[] args) {
        VendingMachine machine = new VendingMachine(0);
        
        while( true ) {
            String linha = input();
            String[] palavras = linha.split(" ");
            println("$" + linha);

            if ( palavras[0].equals("end") ) { break; }
            else if ( palavras[0].equals("init")     ) { machine = new VendingMachine( Integer.parseInt(palavras[1]) ); }
            else if ( palavras[0].equals("show")     ) { print(machine); }
            else if ( palavras[0].equals("set")      ) { machine.setSlot( Integer.parseInt(palavras[1]), new Slot( palavras[2], Float.parseFloat(palavras[4]), Integer.parseInt(palavras[3]) ) ); }
            else if ( palavras[0].equals("limpar")   ) { machine.clearSlot( Integer.parseInt(palavras[1]) ); }
            else if ( palavras[0].equals("apurado")  ) { println( "apurado total: " + decForm.format(machine.getProfit()) ); }
            else { println("comando inválido!"); }
        }
    }

    public static Scanner scan = new Scanner(System.in);
    public static String input() { return scan.nextLine(); }
    public static void println(Object str) { System.out.println(str); }
    public static void print(Object str) { System.out.print(str); }
    public static DecimalFormat decForm = new DecimalFormat("0.00");
}