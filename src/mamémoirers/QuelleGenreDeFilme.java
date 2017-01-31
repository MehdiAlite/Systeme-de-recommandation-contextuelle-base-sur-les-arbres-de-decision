
package mamémoirers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class QuelleGenreDeFilme {
    String idItem;
    
    public QuelleGenreDeFilme(){
        
    }
    
    public String ReturnUnSeulGenre(String idItem) throws FileNotFoundException, IOException{
        String result="";
         BufferedReader br = new BufferedReader(new FileReader("Data/u.item"));
         String line;
          String[] values=new String[161]; 
         while((line = br.readLine()) != null) {
                    
			values= line.split("\\|", -1);
                        if(values[0].equalsIgnoreCase(idItem)) break;
                       //	System.out.println("taille du tab = "+values.length+"\n");
         }
         for(int i=5;i<values.length;i++){ // Car la chaine 0|1|0... de u.genre commence a partir de la collone 5 de notre tableau
           //  System.out.println(values[i]);
             
             if(values[i].equalsIgnoreCase("1") && i==5) {result="Autre"; break;}
             if(values[i].equalsIgnoreCase("1") && i==6) {result="Action"; break;}
             if(values[i].equalsIgnoreCase("1") && i==7) {result="Adventure"; break;}
             if(values[i].equalsIgnoreCase("1") && i==8) {result="Animation"; break;}
             if(values[i].equalsIgnoreCase("1") && i==9) {result="Children's"; break;}
             if(values[i].equalsIgnoreCase("1") && i==10) {result="Comedy"; break;}
             if(values[i].equalsIgnoreCase("1") && i==11) {result="Crime";break;}
             if(values[i].equalsIgnoreCase("1") && i==12) {result="Documentary"; break;}
             if(values[i].equalsIgnoreCase("1") && i==13) {result="Drama"; break;}
             if(values[i].equalsIgnoreCase("1") && i==14) {result="Fantasy"; break;}
             if(values[i].equalsIgnoreCase("1") && i==15) {result="Film-Noir"; break;}
             if(values[i].equalsIgnoreCase("1") && i==16) {result="Horror"; break;}
             if(values[i].equalsIgnoreCase("1") && i==17) {result="Musical"; break;}
             if(values[i].equalsIgnoreCase("1") && i==18) {result="Mystery"; break;}
             if(values[i].equalsIgnoreCase("1") && i==19) {result="Romance"; break;}
             if(values[i].equalsIgnoreCase("1") && i==20) {result="Sci-Fi"; break;}
             if(values[i].equalsIgnoreCase("1") && i==21) {result="Thriller"; break;}
             if(values[i].equalsIgnoreCase("1") && i==22) {result="War"; break;}
             if(values[i].equalsIgnoreCase("1") && i==23) {result="Western"; break;}
         }
         br.close();
       //  System.out.println(result);
        return result;
    }
    
    public String Recherch(String idItem) throws FileNotFoundException, IOException{
        String result="";
         BufferedReader br = new BufferedReader(new FileReader("Data/u.item"));
         String line;
          String[] values=new String[161]; 
         while((line = br.readLine()) != null) {
                    
			values= line.split("\\|", -1);
                        if(values[0].equalsIgnoreCase(idItem)) break;
                       //	System.out.println("taille du tab = "+values.length+"\n");
         }
         for(int i=5;i<values.length;i++){ // Car la chaine 0|1|0... de u.genre commence a partir de la collone 5 de notre tableau
           //  System.out.println(values[i]);
             
             if(values[i].equalsIgnoreCase("1")) 
                 switch(i){
                     case 5: result=result+"Autre|";break;
                     case 6: result=result+"Action|";break; 
                     case 7: result=result+"Adventure|";break; 
                     case 8: result=result+"Animation|";break;
                     case 9: result=result+"Children's|";break;    
                     case 10: result=result+"Comedy|";break;     
                     case 11: result=result+"Crime|";break;
                     case 12: result=result+"Documentary|";break;    
                     case 13: result=result+"Drama|";break;    
                     case 14: result=result+"Fantasy|";break;    
                     case 15: result=result+"Film-Noir|";break;
                     case 16: result=result+"Horror|";break; 
                     case 17: result=result+"Musical|";break;    
                     case 18: result=result+"Mystery|";break;    
                     case 19: result=result+"Romance|";break;    
                     case 20: result=result+"Sci-Fi|";break;    
                     case 21: result=result+"Thriller|";break;
                     case 22: result=result+"War|";break;    
                     case 23: result=result+"Western|";break;    
                     
                   
                         
                 }
         }
         br.close();
       //  System.out.println(result);
        return result;
    } 
    
    public LinkedList<Filme> RecherchParGenre(String[] Genre) throws FileNotFoundException, IOException{
       LinkedList<Filme> ListFilme=new LinkedList<Filme>();
       
        String result ="";
        int cpt = 0;
        
         BufferedReader br = new BufferedReader(new FileReader("Data/Filme.txt"));
         String line;
         
         while((line = br.readLine()) != null) {
                    if(cpt!=0){
			 String[] values= line.split("\\/");
        // System.out.println(values[0]+" "+values[1]);
        // System.out.println(values[0]+" : "+result);
         String [] resultatTab=values[2].split("\\|");
         if(CompDeuxTab(resultatTab,Genre)==true){
             Filme filme=new Filme();
            filme.Id=values[0];
            filme.Nom=values[1];
            filme.Date=values[2];
            filme.Note=Integer.parseInt(values[4]);
            ListFilme.addLast(filme);
         }
         result="";
         }
                    cpt+=1;
         }
         br.close();
        // System.out.print("\n La liste des filmes dans ce genre est : \n\n");
        // for(int i=0;i<ListFilme.size();i++) ListFilme.get(i).affich();
        // AjoutNoteDansListDesFilm(ListFilme);
      //  TrieListeFilm(ListFilme);
         return ListFilme;
    }
    
   public String RechParNumeroDeLigne(int numLigne) throws FileNotFoundException, IOException{
       int cpt=0;
       BufferedReader br = new BufferedReader(new FileReader("Data/ToutGenre.txt"));
         String line;
      while((line = br.readLine()) != null) {
            cpt+=1;
            if(cpt==numLigne) break;
         }
       return line;
   }
    
    public boolean CompDeuxTab(String[] tab1,String[] tab2){
        int cpt=0;
        if(tab1.length<tab2.length || tab1.length>tab2.length) return false;
        else {
            for(int i=0;i<tab1.length;i++)
                for(int j=0;j<tab2.length;j++){
                    if(tab1[i].equalsIgnoreCase(tab2[j])) cpt=cpt+1;
                }
        }
        if(cpt==tab1.length)return true;
        else return false;
    }
    
    public void TrieListeFilm(LinkedList<Filme> l){
        Filme film;
        for(int i=0;i<l.size();i++)
            for(int j=i+1;j<l.size();j++)
              if(l.get(i).Note<l.get(j).Note){
                  film=l.get(i);
                  l.add(i, l.get(j));
                  l.add(j, film);
                  
              } 
    }
    
    public void AjoutNoteDansListDesFilm(LinkedList<Filme> l) throws FileNotFoundException, IOException{
       LinkedList<Filme> filme=new LinkedList<Filme>();
        BufferedReader br=new BufferedReader(new FileReader("Data/Filme.txt"));
         String line;
         while((line = br.readLine()) != null){
            String[] values= line.split("\\/", -1);
            Filme fi=new Filme();
           fi.Id=values[0];
           fi.Note=Integer.parseInt(values[4]);     
        filme.addLast(fi);
            }
        
           br.close();
        for(int i=0;i<l.size();i++){
          for(int j=0;j<filme.size();j++)  
           if(l.get(i).Id.equalsIgnoreCase(filme.get(j).Id)){
              l.get(i).Note=filme.get(j).Note;
              break;
           }  
        }
    }
    
    public String ReuturnNoteDuGenre(String Genre) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader("Data/ToutGenreAvecNote.txt"));
         String line,Note ="0";
         while((line = br.readLine()) != null){
            String[] values= line.split("\\ ", -1);
            if(values[0].equalsIgnoreCase(Genre)) {Note=values[1];break;}
            }
        return Note;
    }
}
