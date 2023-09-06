/*
O que fez?
    - FIzemos tudo e passou em todos os testes
Com quem fez?
    - Foi feito em colaboração entre o Henrique Pires e a Taynara Ravette. A lógica principal da estruturação é completamente da Taynara. Henrique fez apenas uma refatoração no código adicionando os métodos get e set, construtor e algumas simplificações do código. 
O que aprendeu?
    - Aprendemos principalmente a sintaxe do java, pois a questão já tinha sido feita por nós em c
Quanto tempo levou?
    - 1 hora (isso é apenas uma especlação)
*/

import java.util.*;

class Ponto {
    private float x;
    private float y;

    public Ponto() {
        x = 0;
        y = 0;
    }

    public void ler() {
        x = QuantosDentro.input();
        y = QuantosDentro.input();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}

class Circulo {
    private Ponto centro;
    private float raio;

    public Circulo() {
        centro = null;
        raio = 0;
    }

    public void ler() {
        centro = new Ponto();
        centro.ler();
        raio = QuantosDentro.input();
    }

    public boolean estaDentro(Ponto ponto) {
        float distancia = (float) Math
                .sqrt(Math.pow(ponto.getX() - this.centro.getX(), 2) + Math.pow(ponto.getY() - this.centro.getY(), 2));
        return distancia <= this.raio;
    }

    public int contarPontos(Ponto[] pontos) {
        int cont = 0;
        for (Ponto ponto : pontos)
            if (estaDentro(ponto))
                cont++;
        return cont;
    }
}

public class QuantosDentro {
    public static void main(String[] arg) {
        int n = input.nextInt();
        Ponto[] vetor = new Ponto[n];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = new Ponto();
            vetor[i].ler();
        }

        Circulo circ = new Circulo();
        circ.ler();
        System.out.println(circ.contarPontos(vetor));
    }

    static Scanner input = new Scanner(System.in);

    public static Float input() {
        return input.nextFloat();
    }
}