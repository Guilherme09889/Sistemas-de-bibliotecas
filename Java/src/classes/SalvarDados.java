package classes;
import java.util.ArrayList;

public class SalvarDados {
    private static ArrayList<Livro> livros = new ArrayList<>();
    private static ArrayList<Revista> revistas = new ArrayList<>();

    public static void salvarLivro(Livro livro){
        livros.add(livro);
    }

    public static void salvarRevista(Revista revista){
        revistas.add(revista);
    }

    public static void buscarLivroPorId(Integer id){
        for(Livro livro : livros){
            if(livro.getId().equals(id)){
                System.out.println("Livro encontrado: " + livro);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public static void buscarRevistaPorId(Integer Id){
        for(Revista revista : revistas){
            if(revista.getId().equals(Id)){
                System.out.println("Revista encontrada: " + revista);
                return;
            } else {
                System.out.println("Revista não encontrada.");
            }
        }
    }

    public static void excluirLivroId(Integer id){
        for(Livro l : livros){
            if(l.getId().equals(id)){
                livros.remove(l);
                System.out.println("Livro excluído com sucesso.");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public static void excluirRevista(Integer id){
        for(Revista r : revistas){
            if(r.getId().equals(id)){
                revistas.remove(r);
                System.out.println("Revista excluída com sucesso.");
                return;
            } else {
                System.out.println("Revista não encontrada.");
            }
        }
    }
}
