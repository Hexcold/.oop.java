public class Tercerizado extends Funcionario {
    protected int horas;
    protected boolean isSalubre = false;

    public Tercerizado(String nome, int horas, String isSalubre) {
        super(nome);
        this.horas = horas;
        if (isSalubre.equals("sim") || isSalubre.equals("SIM")) {
            this.isSalubre = true;
        } else {
            this.isSalubre = false;
        }
    }

    public int getHoras() {
        return horas;
    }

    public String getIsSalubre() {
        if (isSalubre) {
            return "sim";
        } else {
            return "nao";
        }
    }

    public int getSalario() {
        int salario = 4 * horas;
        if (isSalubre) {
            salario += 500;
        }
        return salario + bonus + diarias * 100;
    }

    public void addDiaria() {
        throw new MsgException("fail: terc nao pode receber diaria");
    }

    public String toString() {
        return "ter:" + nome + ":" + horas + ":" + getIsSalubre() + ":" + getSalario();
    }
}