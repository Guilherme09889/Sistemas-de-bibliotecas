package classes;

public class Utils {

    public static boolean validarString(String str){
        if(str == null || str.trim().isEmpty()){
            return false;
        }
        return true;
    }

    public static String padronizarString(String str){
        if(validarString(str)){
            return str.trim().toUpperCase();
        } else {
            System.out.println("Erro: String inválida.");
            return null;
        }
    }

}
