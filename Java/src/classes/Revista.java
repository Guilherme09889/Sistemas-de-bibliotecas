package classes;

public class Revista extends Material{
    private String numeroEdicao;
    private String mesPublicacao;

    public Revista(Integer id, String titulo, boolean situacao, String numeroEdicao, String mesPublicacao) {
        super(id, titulo, situacao);
        this.numeroEdicao = numeroEdicao;
        this.mesPublicacao = mesPublicacao;
    }

    public void criarRevista(Integer id, String titulo, boolean situacao, String numeroEdicao, String mesPublicacao){
        Revista revista = new Revista(id, titulo, situacao, numeroEdicao, mesPublicacao);
    }

    public String getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(String numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    public String getMesPublicacao() {
        return mesPublicacao;
    }

    public void setMesPublicacao(String mesPublicacao) {
        this.mesPublicacao = mesPublicacao;
    }
}
