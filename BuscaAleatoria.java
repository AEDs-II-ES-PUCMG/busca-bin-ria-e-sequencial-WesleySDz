
import java.time.Duration;
import java.time.LocalDateTime;

public class BuscaAleatoria<T> implements IBuscador<T> {

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
        inicio = LocalDateTime.now();
        int posAleatoria = (int) (Math.random() * dados.length);
        T resultado = dados[posAleatoria];
        fim = LocalDateTime.now();
        return resultado;
    }

}
