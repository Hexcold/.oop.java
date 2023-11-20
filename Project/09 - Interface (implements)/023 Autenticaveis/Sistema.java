import java.util.Map;
import java.util.TreeMap;

public class Sistema {
    private UFC ufc;
    Map<String, Autenticavel> usuarios;

    public Sistema() {
        this.ufc = new UFC();
        this.usuarios = new TreeMap<String, Autenticavel>();
    }

    public UFC getUFC() {
        return this.ufc;
    }

    public Autenticavel getUsuario(String nome) {
        return this.usuarios.get(nome);
    }

    public void addUsuario(String nome, String senha) {
        Funcionario f = this.getUFC().getFuncionario(nome);
        if (f != null && f instanceof Terceirizado) {
            throw new MsgException("fail: terc nao pode ser cadastrado no sistema");
        }

        Autenticavel usuario = (FuncionarioAutenticavel) this.getUFC().getFuncionario(nome);
        if (usuario == null) {
            usuario = this.getUFC().getAluno(nome);
        }

        if (usuario == null) {
            throw new MsgException("fail: " + nome + " nao encontrado");
        }

        this.usuarios.put(nome, usuario);
    }

    public void rmUsuario(String nome) {
        this.usuarios.remove(nome);
    }

    public void logar(String nome, String senha) {
        Autenticavel usuario = this.getUsuario(nome);
        if (usuario == null) {
            throw new MsgException("fail: usuario nao encontrado");
        }

        usuario.logar(senha);
    }

    public void deslogar(String nome) {
        Autenticavel usuario = this.getUsuario(nome);
        if (usuario == null) {
            throw new MsgException("fail: usuario nao encontrado");
        }

        usuario.deslogar();
    }

    public void deslogarTodos() {
        for (Autenticavel u : this.usuarios.values()) {
            u.deslogar();
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Autenticavel u : this.usuarios.values()) {
            s += u + ":" + u.getSenha() + ":" + u.getLogado() + "\n";
        }
        return s;
    }
}