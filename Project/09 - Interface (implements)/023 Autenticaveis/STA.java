class STA extends FuncionarioAutenticavel {
    protected int nivel;

    public STA(String nome, int nivel) {
        super(nome);
        this.nivel = nivel;
        this.maxDiarias = 1;
    }

    public int getNivel() {
        return this.nivel;
    }

    @Override
    public int getSalario() {
        return super.getSalario() + 3000 + 300 * this.getNivel();
    }

    @Override
    public String toString() {
        return "sta:" + this.getNome() + ":" + this.getNivel() + ":" + this.getSalario();
    }
}