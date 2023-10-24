public class Professor extends Funcionario {
    protected String classe;

    // inicializa classe e muda maxDiarias para 2
    public Professor(String nome, String classe) {
        super(nome);
        this.classe = classe;
        this.maxDiarias = 2;
    }

    public String getClasse() {
        return classe;
    }

    // lógica do salário do professor
    // usa o super.getSalario para pegar bonus e diarias
    public int getSalario() {
        int salarioBase = super.getSalario();
        int salarioProfessor = salarioBase;

        switch (classe) {
            case "A":
                salarioProfessor += 3000;
                break;
            case "B":
                salarioProfessor += 5000;
                break;
            case "C":
                salarioProfessor += 7000;
                break;
            case "D":
                salarioProfessor += 9000;
                break;
            case "E":
                salarioProfessor += 11000;
                break;
            default:
                throw new MsgException("fail: classe de professor inválida");
        }

        return salarioProfessor;
    }

    public String toString() {
        return "prof:" + nome + ":" + classe + ":" + getSalario();
    }
}