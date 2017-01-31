/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class RecherchUserInfo {
    
    public String rechrchUserParID(String Id){
        String User = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Data/u.user"));
            String line;
            try {
                while((line=br.readLine())!=null){
                     String[] values=line.split("\\|",-1);
                     if(values[0].equalsIgnoreCase(Id)) {User=IntervalAge(values[1])+" "+values[2]+" "+values[3];/*System.out.println(film);*/break;}
                 }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RechercheFilms.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RechercheFilms.class.getName()).log(Level.SEVERE, null, ex);
        }
          return User;  
    }
    
    public String IntervalAge(String Age){
        int i=Integer.parseInt(Age);
        if(10<=i && i<18) return "Adolescent";
                else if(18<=i && i<=30) return "JeuneHomme";
                else if (30<i && i<=40) return "Homme";
                else if(40<i && i<=70) return "Adulte";
                else return"Vieux";
    }
}
