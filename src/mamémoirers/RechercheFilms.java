/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class RechercheFilms {
    
    public String RechrcheParId(String Id){
        String film = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Data/Filme.txt"));
            String line;
            try {
                while((line=br.readLine())!=null){
                     String[] values=line.split("\\/",-1);
                     if(values[0].equalsIgnoreCase(Id)) {film=values[1]+" "+values[2]+" "+values[4];/*System.out.println(film);*/break;}
                 }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RechercheFilms.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RechercheFilms.class.getName()).log(Level.SEVERE, null, ex);
        }
          return film;  
    }
    
    public Filme RechercheParId(String Id){
        Filme f=new Filme();
         try {
            BufferedReader br = new BufferedReader(new FileReader("Data/Filme.txt"));
            String line;
            try {
                while((line=br.readLine())!=null){
                     String[] values=line.split("\\/",-1);
                     if(values[0].equalsIgnoreCase(Id)) {f.Id=values[0];f.Nom=values[1];f.Date=values[2];f.Note=Integer.parseInt(values[4]);/*System.out.println(film);*/break;}
                 }
              //  br.close();
            } catch (IOException ex) {
                Logger.getLogger(RechercheFilms.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RechercheFilms.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return f;
    }
    
    public LinkedList<String> ListDesFilmesLesMieuxNotéDunUser(String IdUser) throws FileNotFoundException, IOException{
        LinkedList<String> l=new LinkedList<>();
         BufferedReader br = new BufferedReader(new FileReader("Data/u.data"));
         String line;
         while((line = br.readLine()) != null) {
                    String[] values = line.split("\\t", -1);
         if(IdUser.equalsIgnoreCase(values[0])){
             if(values[2].equalsIgnoreCase("4") || values[2].equalsIgnoreCase("5")) 
                 l.addLast(values[1]);
         }
         }br.close();
         return l;
    }
    
    public int RetourNoteDeFilmeParId(String Id){
         String film = null;
         int res=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Data/Filme.txt"));
            String line;
            try {
                while((line=br.readLine())!=null){
                     String[] values=line.split("\\/",-1);
                     if(values[0].equalsIgnoreCase(Id)) {res=Integer.parseInt(values[4]);break;}
                 }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RechercheFilms.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RechercheFilms.class.getName()).log(Level.SEVERE, null, ex);
        }
          return res;  
    }
    
}
