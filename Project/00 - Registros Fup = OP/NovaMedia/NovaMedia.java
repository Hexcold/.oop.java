/*
O que fez?
    - Fiz tudo e passou em todos os testes
Com quem fez?
    - Fiz sozinho
O que aprendeu?
    - Aprendi mais sobre a sintaxe do Java
Quanto tempo levou?
    - 1 hora (isso é uma especulação)
*/

import java.util.Scanner;

class Aluno {
    String nome;
    float notas[];

    void ler() {
        Scanner ler = new Scanner(System.in);
        nome = ler.nextLine();
        notas = new float[3];
        for (int i = 0; i < 3; ++i) {
            notas[i] = Float.parseFloat(ler.nextLine());
        }
    }

    void imprimir() {
        float media = 0;
        for (float nota : notas) {
            media += nota;
        }
        System.out.printf("%.2f", media / 3);
    }
}

public class NovaMedia {
    public static void main(String[] args) {
        Aluno alu = new Aluno();
        alu.ler();
        alu.imprimir();
    }
}