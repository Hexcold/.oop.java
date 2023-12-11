import java.util.HashMap;
import java.util.Map;

public class ExemploMapa {
    public static void main(String[] args) {
        // Criando um HashMap que mapeia strings para inteiros
        Map<String, Integer> mapa = new HashMap<>();

        // Adicionando pares chave-valor ao mapa
        mapa.put("Chave1", 10);
        mapa.put("Chave2", 20);
        mapa.put("Chave3", 30);

        // Acessando valores através das chaves
        int valor = mapa.get("Chave2");
        System.out.println("Valor associado à Chave2: " + valor);

        // Iterando sobre as chaves do mapa
        for (String chave : mapa.keySet()) {
            int valorAtual = mapa.get(chave);
            System.out.println("Chave: " + chave + ", Valor: " + valorAtual);
        }
    }
}

