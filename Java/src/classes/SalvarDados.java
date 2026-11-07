package classes;
import java.util.ArrayList;

public class SalvarDados {
    private static ArrayList<Material> materiais = new ArrayList<>();

    public static void carregarDadosTeste(){
        materiais.add(new Livro("Clean Code", "Robert C. Martin", "464"));
        materiais.add(new Livro("O Senhor dos Aneis", "J.R.R. Tolkien", "1178"));
        materiais.add(new Livro("Dom Casmurro", "Machado de Assis", "256"));
        materiais.add(new Revista("Superinteressante", "450", "Janeiro"));
        materiais.add(new Revista("National Geographic", "312", "Marco"));
        materiais.add(new Revista("Veja", "2900", "Agosto"));
        System.out.println("Dados de teste carregados: " + materiais.size() + " materiais.\n");
    }

    public static void salvarMaterial(Material material){
        for(Material m : materiais){
            if(m.getTitulo().equals(material.getTitulo())){
                System.out.println("Não foi possível salvar o material.");
                return;
            }
        }
        materiais.add(material);
        System.out.println("Material salvo com sucesso.");
    }

    public static Material buscarMaterialPorId(Integer id){
        for(Material m : materiais){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public static void excluirPorId(Integer id){
        for(Material m : materiais){
            if(m.getId() == id){
                materiais.remove(m);
                System.out.println("Material excluído com sucesso.");
                return;
            }
        }
        System.out.println("Material não encontrado.");
    }

    public static void listarMateriais(){
        if(materiais.isEmpty()){
            System.out.println("Nenhum material cadastrado.");
            return;
        }
        System.out.println("Lista de materiais cadastrados:");
        for(Material m : materiais){
            System.out.println(m);
        }
    }

    public static Material buscarMaterialPorTitulo(String titulo){
        titulo = titulo.trim().toUpperCase();
        for(Material m : materiais){
            if(m.getTitulo().equals(titulo)){
                return m;
            }
        }
        return null;
    }

}
