import java.util.Scanner;

class Aluno
{
    String nome;
    float notas[];

    void ler()
    {
        Scanner ler = new Scanner(System.in);
        nome = ler.nextLine();
        notas = new float[3];
        for(int i = 0; i < 3; ++i){
            notas[i] = Float.parseFloat(ler.nextLine());
        }
    }

    void imprimir()
    {
        float media = 0;
        for(float nota : notas){
            media += nota;
        }
        System.out.printf("%.2f", media/3);
    }
}

class NovaMedia {
    public static void main(String[] arg)
    {
        Aluno alu = new Aluno();
        alu.ler();
        alu.imprimir();
    }    
}
