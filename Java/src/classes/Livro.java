package classes;
import java.util.ArrayList;

public class Livro extends Material{
    private String autor;
    private String numPaginas;

    public Livro(Integer id, String titulo, boolean situacao, String autor, String numPaginas) {
        super(id, titulo, situacao);
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }


    @Override
    public String toString() {
        return "Livro{" +
                "id=" + getId() +
                ", titulo='" + getTitulo() + '\'' +
                ", situacao=" + isSituacao() +
                ", autor='" + autor + '\'' +
                ", numPaginas='" + numPaginas + '\'' +
                '}';
    }
}
