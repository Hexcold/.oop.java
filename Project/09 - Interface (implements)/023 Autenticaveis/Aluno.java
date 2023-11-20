public class Aluno implements Autenticavel {
    private String nome;
    private String curso;
    private int bolsa;

    private String senha;
    private boolean logado;

    public Aluno(String nome, String curso, int bolsa) {
        this.nome = nome;
        this.curso = curso;
        this.bolsa = bolsa;

        this.senha = "";
        this.logado = false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCurso() {
        return this.curso;
    }

    public int getBolsa() {
        return this.bolsa;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public boolean getLogado() {
        return this.logado;
    }

    public void logar(String senha) {
        if (!this.senha.equals(senha)) {
            throw new MsgException("fail: senha invalida");
        }

        this.setLogado(true);
    }

    public void deslogar() {
        this.setLogado(false);
    }

    @Override
    public String toString() {
        return "alu:" + this.getNome() + ":" + this.getCurso() + ":" + this.getBolsa();
    }
}