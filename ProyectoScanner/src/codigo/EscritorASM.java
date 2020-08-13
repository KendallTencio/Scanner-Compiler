package codigo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorASM {    
    
    File archivoASM;
    FileWriter flwriter = null;
    
    public EscritorASM(){
        String currentDirectory = System.getProperty("user.dir");
        String ruta = currentDirectory+"/src/codigo/codigo.asm";
        archivoASM = new File(ruta);
        try
        {         
            if (archivoASM.exists()){                
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivoASM));
                bw.write("");
                bw.close();
            }else{
                archivoASM.createNewFile();
            }   
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoASM));
            bw.write(";Código TASM\n\n"
                    + ".MODEL small\n\n"
                    + ".STACK 200h\n\n"
                    + ".DATA\n\n"                    
                    + ".CODE\n"
                    + "\t.STARUP\n"
                    + "mov ax,@data\n"
                    + "mov ds,ax\n"
                    + "mov es,ax\n"
                    +"\n"
                    + "\t.EXIT\n\n"
                    + "END");
            bw.close();
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }

}
