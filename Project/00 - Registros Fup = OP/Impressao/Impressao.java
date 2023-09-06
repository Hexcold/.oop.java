/*
O que fez?
    - Fiz tudo e passou em todos os testes
Com quem fez?
    - Fiz sozinho
O que aprendeu?
    - Aprendi melhor sobre a sintaxe do Java
Quanto tempo levou?
    - 1 hora (isso é uma estimativa)
*/

import java.util.Scanner;

class Aluno {
    String nome;
    int matr;
    String disc;
    float nota;

    void ler() {
        Scanner in = new Scanner(System.in);
        nome = in.nextLine();
        matr = Integer.parseInt(in.nextLine());
        disc = in.nextLine();
        nota = Float.parseFloat(in.nextLine());
    }

    void imprimir() {
        System.out.println("Nome = " + nome);
        System.out.println("Matrícula = " + matr);
        System.out.println("Disciplina = " + disc);
        System.out.println("Nota = " + nota);
    }
}

class Impressao {
    public static void main(String[] arg) {
        Aluno alu = new Aluno();
        alu.ler();
        alu.imprimir();
    }
}