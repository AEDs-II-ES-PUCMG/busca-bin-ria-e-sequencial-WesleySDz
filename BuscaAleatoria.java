
import java.time.Duration;
import java.time.LocalDateTime;

public class BuscaAleatoria<T> implements IBuscador<T> { //Recebe um array de dados, e tenta localizar o elemento passado como parâmetro, retornando o elemento encontrado ou null caso não encontre. O método buscar deve registrar o número de comparações realizadas e o tempo gasto para realizar a busca.

    private long comparacoes;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private T[] dados;

    public BuscaAleatoria(T[] dados) {
        this.dados = dados;
    }

    @Override
    public long getComparacoes() {
        return comparacoes;
    }

    @Override
    public double getTempo() {
        if (inicio == null) {
            throw new IllegalStateException("Não foi feita nenhuma busca.");
        }

        return Duration.between(inicio, fim).toNanos();
    }

    @Override
    public T buscar(T dado) {
        comparacoes = 0;
        int pos = (int) (Math.random() * dados.length);
        inicio = LocalDateTime.now();
        while (!dados[pos].equals(dado)) {
            pos = (int) (Math.random() * dados.length);
            comparacoes++;
        }
        fim = LocalDateTime.now();
        return dados[pos];
    }

}
