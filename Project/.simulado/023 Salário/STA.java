public class STA extends Funcionario {
    protected int nivel;

    public STA(String nome, int nivel) {
        super(nome);
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public int getSalario() {
        return 3000 + 300 * nivel + bonus + diarias * 100;
    }

    public String toString() {
        return "sta:" + nome + ":" + nivel + ":" + getSalario();
    }
}