package classes;

public class Livro extends Material{
    private String autor;
    private String numPaginas;

    public Livro(String titulo, String autor, String numPaginas) {
        super(titulo);
        this.autor = autor.toUpperCase();
        this.numPaginas = numPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor.toUpperCase();
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return super.toString() + "Livro{" +
                "autor='" + autor + '\'' +
                ", numPaginas='" + numPaginas + '\'' +
                '}';
    }
}
