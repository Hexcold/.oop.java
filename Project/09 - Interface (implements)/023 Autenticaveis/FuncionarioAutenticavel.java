public class FuncionarioAutenticavel extends Funcionario implements Autenticavel {
    private String senha;
    private boolean logado;

    public FuncionarioAutenticavel(String nome) {
        super(nome);

        this.senha = "";
        this.logado = false;
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
}