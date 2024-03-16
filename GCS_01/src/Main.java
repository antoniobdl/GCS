import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        // criando lista com números aleatórios
        Random rand_num = new Random();
        int tamanhoLista = 10;
        for (int i = 0; i < tamanhoLista; i++) {
            // adiciona número aleatório entre 0 e 9 na lista
            lista.add(rand_num.nextInt(10));
        }
    }

    public static boolean hasRepeat(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            // compara o indice atual com o próximo
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).equals(lista.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

}
