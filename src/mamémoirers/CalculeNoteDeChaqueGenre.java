/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Acer
 */
public class CalculeNoteDeChaqueGenre {
    
    public static void main(String...Arg) throws FileNotFoundException, IOException{
       /* BufferedWriter bw = new BufferedWriter(new FileWriter("Data/ToutGenreAvecNote.txt",true)); 
         BufferedReader brr=new BufferedReader(new FileReader("Data/ToutGenre.txt"));
         double note = 0;
        String linef1,linef2;
        int cpt=0,cpt2=0;
         while((linef1 = brr.readLine()) != null) {
            System.out.println("Cpt 1 : "+cpt);
             BufferedReader br = new BufferedReader(new FileReader("Train&Test/u1DataTrain.txt"));
       
             while((linef2 = br.readLine()) != null){
                 System.out.println("Cpt 2 : "+cpt2);
                String [] values=linef2.split("\\ ");
                if(linef1.equalsIgnoreCase(values[3])){
                    if(note==0) note=Double.parseDouble(values[4]);
                    else 
                   note=(note+Double.parseDouble(values[4]))/2; 
                }
                cpt2+=1;
             }
             br.close();
             bw.write(linef1+" "+String.valueOf(note)+"\n");
         note=0;
         cpt+=1;
         cpt2=0;
         }
         brr.close();
         bw.close();
    }*/
     System.out.println(new QuelleGenreDeFilme().ReuturnNoteDuGenre("Comedy|Romance|"));
    }
       
       
}
