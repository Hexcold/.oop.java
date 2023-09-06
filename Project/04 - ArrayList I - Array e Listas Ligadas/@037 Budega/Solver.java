import java.util.*;

public class Solver {
    static Shell sh = new Shell();
    static Mercantil mercantil = new Mercantil(0);

    public static void main(String[] args) {
        sh.addCmd("init", () -> mercantil = new Mercantil(sh.getInt(1)));
        sh.addCmd("call", () -> mercantil.chamarNoCaixa(sh.getInt(1)));
        sh.addCmd("finish", () -> mercantil.finalizar(sh.getInt(1)));
        sh.addCmd("arrive", () -> mercantil.chegar(new Pessoa(sh.getStr(1))));
        sh.addCmd("show", () -> System.out.print(mercantil.toString()));
        sh.evaluate();
    }
}