/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author laboratorio
 */
public class Millonario {
    public String[] preguntas;
    public String[][] respuestas;
    public int preguntaActual = -1;
    public ArrayList preguntasUsadas;
    
    public Millonario(){
        this.preguntas = new String[15];
        this.respuestas = new String[15][4];
        this.preguntasUsadas = new ArrayList<>();
        
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
            File file2 = new File("src/proyecto/respuestas.txt");
            Scanner s2 = new Scanner(file2);
            while (s2.hasNextLine()){
                respuestas[num_pregunta][i] = s2.nextLine();
                if(i == 3){
                    num_pregunta += 1;
                    i = 0;
                }else{
                    i++;
                }               
            }
            s2.close();  
        } catch (FileNotFoundException exception) {}  
    }
    
    public void cambiarPregunta(){
        Random random = new Random();
        if(preguntaActual != -1)
            preguntasUsadas.add(preguntaActual);       
        do{
            preguntaActual = random.nextInt(15);
        }while(preguntasUsadas.contains(preguntaActual));  
    }    
}
