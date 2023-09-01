class Animal {
    private String especie;
    private String barulho;
    private int estagio;

    public Animal(String especie, String barulho) {
        this.especie = especie;
        this.barulho = barulho;
        this.estagio = 0;
    }

    public String fazerBarulho() {
        if (estagio == 0) {
            return "---";
        }
        if (estagio == 4) {
            return "RIP";
        }
        return this.barulho;
    }

    public void envelhecer(int nivel) {
        estagio += nivel;
        if (estagio >= 4) {
            System.out.printf("warning: %s morreu%n", especie);
            estagio = 4;
        }
    }

    public String toString() {
        return String.format("%s:%d:%s", especie, estagio, barulho);
    }
}