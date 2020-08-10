package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Principal {
    
    static TablaSimbolos tabla = new TablaSimbolos();
    
    public static void main(String[] args) throws Exception {
        String currentDirectory = System.getProperty("user.dir");
        String ruta1 = currentDirectory+"/src/codigo/Lexer.flex";
        String ruta2 = currentDirectory+"/src/codigo/LexerCup.flex";
        String[] rutaSin = {"-parser", "Sintax", currentDirectory+"/src/codigo/Sintax.cup"};
        generar(ruta1, ruta2, rutaSin);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutaSin) throws IOException, Exception{
        String currentDirectory = System.getProperty("user.dir");
        
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutaSin);
        
        Path rutaSym = Paths.get(currentDirectory+"/src/codigo/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(currentDirectory+"/sym.java"), 
                Paths.get(currentDirectory+"/src/codigo/sym.java")
        );
        Path rutaSintax = Paths.get(currentDirectory+"/src/codigo/Sintax.java");
        if(Files.exists(rutaSintax)){
            Files.delete(rutaSintax);
        }
        Files.move(
                Paths.get(currentDirectory+"/Sintax.java"), 
                Paths.get(currentDirectory+"/src/codigo/Sintax.java")
        );
    }
} 