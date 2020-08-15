package codigo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EscritorASM {    
    
    public static File archivoASM;
    public static String ruta; 
    
    public static int contadorEtq = 0;
    public static int contadorTemp = 0;
    public static int varCont = 0;

    public void reiniciar(){    
        contadorEtq = 0;    
        contadorTemp = 0;    
    }
    public EscritorASM(){
        String currentDirectory = System.getProperty("user.dir");
        ruta = currentDirectory+"/src/codigo/codigo.asm";
        archivoASM = new File(ruta); 
        reiniciar();
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
                    + ".DATA\n"
                    +";dataFinal\n\n"                    
                    + ".CODE\n"
                    + "\t.STARUP\n"
                    + "mov ax,@data\n"
                    + "mov ds,ax\n"
                    + "mov es,ax\n"
                    +";codeFinal\n\n"
                    + "\t.EXIT\n\n"
                    + "END");
            bw.close();
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void agregaCodigo(String codigoASM, String lugar) {
        try {
            BufferedReader file = new BufferedReader(new FileReader(archivoASM));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();

            String inputStr = inputBuffer.toString();
            switch(lugar){
                case "data":
                    inputStr = inputStr.replace(";dataFinal", codigoASM+"\n;dataFinal");
                    break;
                case "code":
                    inputStr = inputStr.replace(";codeFinal", codigoASM+"\n;codeFinal");
                    break;
                default:
                    break;
            }
            
            FileOutputStream fileOut = new FileOutputStream(archivoASM);
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Trebor something does not exists");
        }
    }
    
    public static void escribeVariable(String id){
        agregaCodigo(""
                + "var" + id + " DW 1 DUP(0)", "data" );
    }
    
    public static void escribeExp(String ex1,String op,String ex2){

        switch(op){
            case "+":
                agregaCodigo(""
                + "mov " + "ax"+","+ex1+"\n"
                + "add " + "ax"+","+ex2+"\n"
                + "mov " + "t"+(contadorTemp)+ ","+"ax"
                , "code" );
                break;
            case "-":
                agregaCodigo(""
                + "mov " + "ax"+","+ex1+"\n"
                + "sub " + "ax"+","+ex2+"\n"
                + "mov " + "t"+(contadorTemp)+ ","+"ax"
                , "code" );
                break;
            case "=":
                agregaCodigo(""
                + "mov " + "ax"+","+ex2+"\n"
                + "mov " + ex1+","+"ax"
                , "code" );
                break;
            case "!=":
                agregaCodigo(""
                + "mov " + "ax"+","+ex2+"\n"
                + "cmp " + ex1+","+"ax"+"\n"
                + "je " + "label" + (contadorEtq)
                , "code" );
                break;
            case "==":
                agregaCodigo(""
                + "mov " + "ax"+","+ex2+"\n"
                + "cmp " + ex1+","+"ax"+"\n"
                + "jne " + "label" + (contadorEtq)
                , "code" );
                break;
            case "<":
                agregaCodigo(""
                + "mov " + "ax"+","+ex2+"\n"
                + "cmp " + ex1+","+"ax"+"\n"
                + "jae " + "label" + (contadorEtq)
                , "code" );
                break;
            case ">":
                agregaCodigo(""
                + "mov " + "ax"+","+ex2+"\n"
                + "cmp " + ex1+","+"ax"+"\n"
                + "jbe " + "label" + (contadorEtq)
                , "code" );
                break;
            case "<=":
                agregaCodigo(""
                + "mov " + "ax"+","+ex2+"\n"
                + "cmp " + ex1+","+"ax"+"\n"
                + "ja " + "label" + (contadorEtq)
                , "code" );
                break;
            case ">=":
                agregaCodigo(""
                + "mov " + "ax"+","+ex2+"\n"
                + "cmp " + ex1+","+"ax"+"\n"
                + "jb " + "label" + (contadorEtq)
                , "code" );
                break;
            case "ifExit":
                agregaCodigo(""
                + "label" + contadorEtq + ":"
                , "code" );
                break;
            case "ifEnd":
                agregaCodigo(""
                + "jump " + "label" + (contadorEtq+1)+"\n"
                + "label" + contadorEtq + ":"
                , "code" );
                break;
            case "elseEnd":
                agregaCodigo(""
                + "label" + contadorEtq + ":"
                , "code" );
                break;
            case "whileInit":
                agregaCodigo(""
                + "label" + contadorEtq + ":"
                , "code" );
                break;
            case "whileEnd":
                agregaCodigo(""
                + "label" + contadorEtq + ":"
                , "code" );
                break;
            default:
                break;
        }
    }
    
    public static String temp() {
        contadorTemp++;
        agregaCodigo("t" + contadorTemp + " DW 1 DUP(0)", "data" );
	return "t" + contadorTemp;        
    }
    public static String etiq() {
	return "label" + contadorEtq++;
    }
}
