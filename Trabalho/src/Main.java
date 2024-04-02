import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
       try {
        File file = new File("c:/Users/pokem/OneDrive/Área de Trabalho/Trabalhos, Projetos de Programação/casos-de-teste-E/casoE100.txt");

        Scanner in = new Scanner(file);

        while(in.hasNextLine()){
            System.out.println(in.nextLine());
        }

        in.close();
        
        }catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
