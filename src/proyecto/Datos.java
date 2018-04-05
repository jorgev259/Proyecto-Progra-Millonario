/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author laboratorio
 */
public class Datos {
    public String[] preguntas;
    public String[] respuestas;
    public String[] correctas;
    
    public Datos(){
        this.preguntas = new String[15];
        this.respuestas = new String[15];
        this.correctas = new String[15];
        
        try{
            int i = 0;
            File file = new File("src/proyecto/preguntas.txt");
            Scanner s = new Scanner(file);
            
            while (s.hasNextLine()){
                preguntas[i] = s.nextLine();
                i++;
            }
            s.close();
            
            i = 0;
            int num_pregunta = 0;
            Scanner s2 = new Scanner(new File("repuestas.txt"));
            while (s2.hasNextLine()){
                respuestas[i] = s2.nextLine();
                if(i % 3 == 0){
                    correctas[num_pregunta] = respuestas[i];
                    num_pregunta += 1;
                }
            }
            s2.close();          
        } catch (FileNotFoundException exception) {}  
    }
    
}
