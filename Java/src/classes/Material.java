package classes;
import java.util.UUID;

public abstract class Material {
    private String id;
    private String titulo;
    private boolean situacao;

    public Material(String titulo) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo.toUpperCase();
        this.situacao = true;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.toUpperCase();
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}
