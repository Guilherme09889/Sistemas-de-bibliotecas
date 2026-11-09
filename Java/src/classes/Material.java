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

    public boolean isSituacao() {
        return situacao;
    }

    private void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void ativar() {
        if(this.situacao == true){
            System.out.println("O material já está ativo.");
            return;
        }
        setSituacao(true);
    }

    public void inativar() {
        if(this.situacao == false){
            System.out.println("O material já está inativo.");
            return;
        }
        setSituacao(false);
    }

    public boolean emprestar() {
        if(this.situacao == false){
            System.out.println("Material indisponível, já está emprestado.");
            return false;
        }
        inativar();
        return true;
    }

    public boolean devolver() {
        if(this.situacao == true){
            System.out.println("Material não está emprestado.");
            return false;
        }
        ativar();
        return true;
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
