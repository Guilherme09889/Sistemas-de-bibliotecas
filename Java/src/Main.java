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
                    " 8 - Emprestar Material por Id\n" +
                    " 9 - Devolver Material por Id\n" +
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
                    SalvarDados.salvarMaterial(livro);
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
                    SalvarDados.salvarMaterial(revista);
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
                    Material materialTitulo = buscarMaterialPorTitulo(tituloProcurar);
                    if(materialTitulo != null){
                        System.out.println("Material encontrado: " + materialTitulo);
                    } else {
                        System.out.println("Material não encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Digite o ID do material que deseja procurar:");
                    Integer idProcurar = scanner.nextInt();
                    Material materialProcurar = buscarMaterialPorId(idProcurar);
                    if(materialProcurar != null){
                        System.out.println("Material encontrado: " + materialProcurar);
                    } else {
                        System.out.println("Material não encontrado.");
                    }
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
                case 8:
                    System.out.println("Digite o ID do material que deseja emprestar:");
                    Integer idEmprestar = scanner.nextInt();
                    Material materialEmprestar = buscarMaterialPorId(idEmprestar);
                    if(materialEmprestar != null){
                        if(materialEmprestar.emprestar()){
                            System.out.println("Material emprestado com sucesso: " + materialEmprestar);
                        }
                    } else {
                        System.out.println("Material não encontrado.");
                    }
                    break;
                case 9:
                    System.out.println("Digite o ID do material que deseja devolver:");
                    Integer idDevolver = scanner.nextInt();
                    Material materialDevolver = buscarMaterialPorId(idDevolver);
                    if(materialDevolver != null){
                        if(materialDevolver.devolver()){
                            System.out.println("Material devolvido com sucesso: " + materialDevolver);
                        }
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
