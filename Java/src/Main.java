import java.util.Scanner;

import classes.Livro;
import classes.Material;
import classes.Revista;
import classes.SalvarDados;

import static classes.SalvarDados.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SalvarDados.carregarDadosTeste();

        int opcao;
        do{
            System.out.println("Escolha uma opção:\n" +
                    " 1 - Cadastrar Livro\n" +
                    " 2 - Cadastrar Revista\n" +
                    " 3 - Excluir Material por Id\n" +
                    " 4 - Listar Materiais\n" +
                    " 5 - Procurar Material por Título\n" +
                    " 6 - Procurar Material por Id\n" +
                    " 7 - Alterar Situação do Material por Id\n" +
                    " 0 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite o título do livro:");
                    String tituloLivro = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String autorLivro = scanner.nextLine();
                    System.out.println("Digite o número de páginas do livro:");
                    String numPaginasLivro = scanner.nextLine();
                    Livro livro = new Livro(tituloLivro, autorLivro, numPaginasLivro);
                    if(livro.getTitulo() != null
                            && livro.getAutor() != null && livro.getNumPaginas() != null){
                        SalvarDados.salvarMaterial(livro);
                    } else {
                        System.out.println("Erro ao salvar o material. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:

                    scanner.nextLine();
                    System.out.println("Digite o título da revista:");
                    String tituloRevista = scanner.nextLine();
                    System.out.println("Digite o número da edição da revista:");
                    String numeroEdicaoRevista = scanner.nextLine();
                    System.out.println("Digite o mês de publicação da revista:");
                    String mesPublicacaoRevista = scanner.nextLine();
                    Revista revista = new Revista(tituloRevista, numeroEdicaoRevista,
                            mesPublicacaoRevista);
                    if(revista.getTitulo() != null && revista.getNumeroEdicao()
                            != null && revista.getMesPublicacao() != null){
                        SalvarDados.salvarMaterial(revista);
                    } else {
                        System.out.println("Erro ao salvar o material. Verifique os dados e tente novamente.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID do material que deseja excluir:");
                    Integer idExcluir = scanner.nextInt();
                    excluirPorId(idExcluir);
                    break;
                case 4:
                    listarMateriais();
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Digite o título do material que deseja procurar:");
                    String tituloProcurar = scanner.nextLine();
                    procurarPorTitulo(tituloProcurar);
                    break;
                case 6:
                    System.out.println("Digite o ID do material que deseja procurar:");
                    Integer idProcurar = scanner.nextInt();
                    buscarPorId(idProcurar);
                    break;
                case 7:
                    System.out.println("Digite o ID do material:");
                    Integer idSituacao = scanner.nextInt();
                    Material material = buscarMaterialPorId(idSituacao);
                    if(material != null){
                        System.out.println("Situação atual: " + material.isSituacao());
                        System.out.println("1 - Ativar\n2 - Inativar");
                        if(scanner.nextInt() == 1){
                            material.ativar();
                        } else {
                            material.inativar();
                        }
                        System.out.println("Situação alterada: " + material);
                    } else {
                        System.out.println("Material não encontrado.");
                    }
                    break;
                case  0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }while (opcao != 0);

    }
}
