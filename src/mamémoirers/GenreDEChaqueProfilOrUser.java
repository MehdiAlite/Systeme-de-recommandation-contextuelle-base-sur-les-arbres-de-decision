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
import java.util.LinkedList;

/**
 *
 * @author Acer
 */
public class GenreDEChaqueProfilOrUser {
    
    public void MoyenneNoteDuGenreAiméParChauqueProfil(String FileEntre,String FileSortie) throws FileNotFoundException, IOException{
        LinkedList<Genre> Genre=new LinkedList<Genre>();
        BufferedReader br = new BufferedReader(new FileReader(FileEntre)); //u.Data
          FileWriter fw=null;
           QuelleGenreDeFilme Ql;
           String line;
          fw=new FileWriter(FileSortie);
         BufferedWriter bw = new BufferedWriter(new FileWriter(FileSortie)); //toutGenre.txt
         int cpt=0;
         while((line = br.readLine()) != null) {
                 Ql=new QuelleGenreDeFilme();
                  System.out.println(cpt); 
                String[] Values =line.split("\\t",-1);
                
                
                String Genr=Ql.Recherch(Values[1]);
                String Profil=new RecherchUserInfo().rechrchUserParID(Values[0]);
                String Note=Values[2];
                Boolean tr=false; 
                Genre g=new Genre();
                //System.out.println("Dans le fichier | Profil : "+Profil+" Genre :  "+Genr+" Note : "+Note);
                if(Genre.isEmpty()) {/*System.out.println("if 1 ; Id : "+Profil+"| Genre : "+Genr+" | Note : "+Note);*/g.NomGenre=Genr;g.Profil=Profil;g.Note=Note;Genre.addLast(g);}
                else {
                for(int i=0;i<Genre.size();i++){
                   if(Genre.get(i).Profil.equalsIgnoreCase(Profil) && Genre.get(i).NomGenre.equalsIgnoreCase(Genr)){/*System.out.println("if 2 ; Id : "+Genre.get(i).Profil +"| Genre : "+Genre.get(i).NomGenre +" | Note : "+Genre.get(i).Note);*/tr=true;g.Profil=Profil;g.NomGenre=Genr;g.Note=String.valueOf((Double.parseDouble(Values[2])+Double.parseDouble(Genre.get(i).Note))/2);Genre.set(i, g);}
                }
                if(tr==false) {/*System.out.println("if 3 ; Id : "+Profil+"| Genre : "+Genr+" | Note : "+Note);*/g.NomGenre=Genr;g.Profil=Profil;g.Note=Note;Genre.addLast(g);}
                }
                cpt+=1;
                }
        br.close();
        for(int i=0;i<Genre.size();i++) fw.write(Genre.get(i).Profil +" "+Genre.get(i).NomGenre+" "+ Genre.get(i).Note +"\n");
       fw.close();
    
}
    
    public String PredictNote(String File,String Age,String Gender,String Proff,String Genre) throws IOException {
         BufferedReader br = new BufferedReader(new FileReader(File));
         String line;
         String Note = null;
         double t=0;
         double res = 0,cpt=0;
          while((line = br.readLine()) != null) {
              String [] values=line.split("\\ ");
              if(values[0].equalsIgnoreCase(Age))
                  if(values[1].equalsIgnoreCase(Gender))
                     if(values[2].equalsIgnoreCase(Proff)){
                       if(values[3].equalsIgnoreCase(Genre))  
                        cpt=CompDeuxGenre(values[3].split("\\|"), Genre.split("\\|"));
                         if(cpt!=0){
                             res=cpt;
                             t=(t+Double.parseDouble(values[4]))/2;
                            //Note=values[4]; 
                         }
                                 
                     }
             
              
          }
          br.close();
          return String.valueOf(t);
    }
    
    public Double CompDeuxGenre(String[] t1,String [] t2){
        double cpt=0;
        for(int i=0;i<t1.length;i++)
            for(int j=0;j<t2.length;j++){
                if(t1[i].equalsIgnoreCase(t2[j])) cpt+=1;
            }
        //if(cpt==t1.length || cpt==t2.length) cpt+=2;
        return cpt;
        
    }
    
    public static void main(String ...Arg) throws IOException{
           
      System.out.println(new GenreDEChaqueProfilOrUser().PredictNote("Train&Test/ToutGenreAvecNoteU1Train.txt","JeuneHomme" ,"M" ,"technician", "Drama|War|"));
   
    }
    
    
}
