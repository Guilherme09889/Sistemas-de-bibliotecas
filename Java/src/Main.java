import java.util.Scanner;

import classes.Livro;
import classes.Revista;
import classes.SalvarDados;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do{
            System.out.println("Escolha uma opção:\n" +
                    " 1 - Cadastrar Livro\n" +
                    " 2 - Cadastrar Revista\n" +
                    " 3 - Excluir Livro\n" +
                    " 4 - Excluir Revista\n" +
                    " 5 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    System.out.println("Cadastrar Livro selecionado.");
                    System.out.println("Digite o ID do livro:");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o título do livro:");
                    String tituloLivro = scanner.nextLine();
                    System.out.println("Digite a situação do livro (true para disponível, false para indisponível):");
                    boolean situacaoLivro = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String autorLivro = scanner.nextLine();
                    System.out.println("Digite o número de páginas do livro:");
                    String numPaginasLivro = scanner.nextLine();
                    Livro livro = new Livro(idLivro, tituloLivro, situacaoLivro, autorLivro, numPaginasLivro);
                    System.out.println("Livro cadastrado com sucesso: " + livro);
                    if(livro.getId() != null && livro.getTitulo() != null
                            && livro.getAutor() != null && livro.getNumPaginas() != null){
                        SalvarDados.salvarLivro(livro);
                        System.out.println("Livro salvo com sucesso!");
                    } else {
                        System.out.println("Erro ao salvar o livro. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:

                    System.out.println("Cadastrar Revista selecionado.");
                    System.out.println("Digite o ID da revista:");
                    int idRevista = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o título da revista:");
                    String tituloRevista = scanner.nextLine();
                    System.out.println("Digite a situação da revista (true para disponível, false para indisponível):");
                    boolean situacaoRevista = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.println("Digite o número da edição da revista:");
                    String numeroEdicaoRevista = scanner.nextLine();
                    System.out.println("Digite o mês de publicação da revista:");
                    String mesPublicacaoRevista = scanner.nextLine();
                    Revista revista = new Revista(idRevista, tituloRevista, situacaoRevista, numeroEdicaoRevista,
                            mesPublicacaoRevista);
                    System.out.println("Revista cadastrada com sucesso: " + revista);
                    if(revista.getId() != null && revista.getTitulo() != null && revista.getNumeroEdicao()
                            != null && revista.getMesPublicacao() != null){
                        SalvarDados.salvarRevista(revista);
                        System.out.println("Revista salva com sucesso!");
                    } else {
                        System.out.println("Erro ao salvar a revista. Verifique os dados e tente novamente.");
                    }
                    break;

                case 3:
                    System.out.println("Excluir Livro selecionado.");
                    break;
                case 4:
                    System.out.println("Excluir Revista selecionado.");
                    break;
                case 5:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }while (opcao != 5);

    }
}
