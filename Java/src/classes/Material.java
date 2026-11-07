package classes;


public abstract class Material {
    private static int contador = 0;
    private int id;
    private String titulo;
    private boolean situacao;

    public Material(String titulo) {
        this.id = ++contador;
        this.titulo = titulo.toUpperCase();
        this.situacao = true;
    }

    public int getId() {
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

    public void ativar() {
        if(this.situacao == true){
            System.out.println("O material já está ativo.");
            return;
        }
        this.situacao = true;
    }

    public void inativar() {
        if(this.situacao == false){
            System.out.println("O material já está inativo.");
            return;
        }
        this.situacao = false;
    }


    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", situacao=" + situacao +
                '}';
    }
}
