/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.time.Instant;
import java.time.ZoneId;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class MaMémoireRs {

  
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        int t=679991129;
        Instant instant = java.time.Instant.ofEpochSecond(t); // jdk 8 pour convertir ce temp since 1970 to une date
        
        java.util.Date res =new java.util.Date(); //Date.from(instant); // instant on la convertit on date pour le format béh apré ntésté 3la les jrs
        
        DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); // type de date li fihe les jrs 
        
        //System.out.println(java.time.Instant.ofEpochSecond(879959583));
      // System.out.println(fullDateFormat.format(res).toString().split("")); // apré avoir notre date on lajuste leur format pr les jrs 
     //  String [] tr= fullDateFormat.format(res).toString().split(" ");
     //   for(int i=0;i<tr.length;i++) System.out.println(tr[i]);
        
      // new LongToDateAndClass(t).classification();
   //new ConvertAndModifData("Data/u.data","Data/moviesBinaire.csv").Convert();
    DecisionTreeForOneUser dc=new DecisionTreeForOneUser();
    // dc.creationDataText();
   dc.CreationDataOneUser("Train&Test/ua.est.txt","1");
    //dc.GenerateDecisionTree("Data/User1.txt");   
     
       // new ConvertAndModifData("Data/u.data","Data/SimilUser.txt").CréationDataPourcalculSimilUser();
                
       // new QuelleGenreDeFilme("2").Recherch();
        
        /*  pour recommender des genres */
   /*String[] tt=new DecisionTreeForOneUser().GenreRech();
   for(int i=0;i<tt.length;i++) System.out.print(tt[i]);*/
        
        /* recherch tout les filmes avec un genre donné*/
       // new QuelleGenreDeFilme().RecherchParGenre("|Action|Romance");
       /* System.out.println(k);
        String[] kk=k.split("|");
        for(int i=0;i<kk.length;i++){
            System.out.println(kk[i]);
        }*/
      
        //Pour Tester la fonction CompDeuxTab(filme1,filme2) comparaison du genre des deux filmes
        
         /*String[] filme1={"Comedy","Drama","Action"," "};
         String[] filme2={"Comedy","Action","Drama"," "};
        if(new QuelleGenreDeFilme().CompDeuxTab(filme1, filme2)) JOptionPane.showMessageDialog(null, "Le meme genre");
        else JOptionPane.showMessageDialog(null, "non c pas le méme genre");*/
        
      /*  String[] filme1Genre={"Drama"};
        new QuelleGenreDeFilme().RecherchParGenre(filme1Genre);*/
        
      //  System.out.println(new QuelleGenreDeFilme().ReturnUnSeulGenre("2"));
        
        
    }
    
}
