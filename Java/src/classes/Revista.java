package classes;

public class Revista extends Material{
    private String numeroEdicao;
    private String mesPublicacao;

    public Revista(String titulo, String numeroEdicao, String mesPublicacao) {
        super(titulo);
        this.numeroEdicao = numeroEdicao;
        this.mesPublicacao = mesPublicacao;
    }

    public String getNumeroEdicao() {
        return numeroEdicao;
    }

    public String getMesPublicacao() {
        return mesPublicacao;
    }


}
