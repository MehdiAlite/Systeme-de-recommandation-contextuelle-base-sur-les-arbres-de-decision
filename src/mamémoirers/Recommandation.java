/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

import ca.pfv.spmf.algorithms.classifiers.decisiontree.id3.AlgoID3;
import ca.pfv.spmf.algorithms.classifiers.decisiontree.id3.DecisionTree;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class Recommandation {
    
    public int NumLigneAléatoir(String url) throws FileNotFoundException, IOException{
        int cpt=0,lign=4; String[] values = null;String line;
        BufferedReader br = new BufferedReader(new FileReader(url));
       while((line=br.readLine())!=null) {cpt+=1;/* values= line.split("\\|", -1);if(cpt==lign) break;*/}
      // System.out.print(values[1]);
       Random r = new Random();
       int valeur = 1 + r.nextInt(19-1); //int valeur = valeurMin + r.nextInt(valeurMax - valeurMin)
       System.out.print("\n cpt = "+cpt+" "+"random = "+valeur+"\n");
       return valeur;
       }
    
    public static void main(String...Arg) throws FileNotFoundException, IOException{
   /*     java.util.Date res =new java.util.Date();
       DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
       String [] tabDate= fullDateFormat.format(res).toString().split(" ");
        LongToDateAndClass lg=new LongToDateAndClass();
        lg.classificationUtilisantUneDate(tabDate);
        int genre=new Recommandation().NumLigneAléatoir("Data/ToutGenre.txt");
        System.out.print("1 "+null+" "+lg.Jour+" "+lg.TypeJr+" "+lg.Saison+" "+lg.TempHeur+" "+new QuelleGenreDeFilme().RechParNumeroDeLigne(genre)+"\n");
        String gnr=new QuelleGenreDeFilme().RechParNumeroDeLigne(genre);
        String [] instance={"1",null,lg.Jour,lg.TypeJr,lg.Saison,lg.TempHeur,gnr};
     */ 
        
        /*AlgoID3 algo = new AlgoID3();
      DecisionTree tree = algo.runAlgorithm("Data/MoviesBinaireModf.txt", "Like/Dislike", " ");
		algo.printStatistics();
               // tree.print();
                // instance :  Age; Sex; Occupation; IdFilm; Like/Dislike; Day; KindOfDay; Season; Time
                
                String [] instance2={"49","M","writer","1",null,"lundi","Normal","Hiver","16h"};
     String prediction = tree.predictTargetAttributeValue(instance2);
        try {
            if(prediction.equalsIgnoreCase("Yes"))
     System.out.println("\n The class that is predicted is: " + prediction);
        } catch (Exception e) {
            System.out.println("null");
        }*/
    
    
        
       // Pour Crée le fichier ToutGenre comme sa je donne une ligne aléatoire et je la recoammander pour un user
       //new ConvertAndModifData("Data/u.item","Data/ToutGenre.txt").CrationDataGenre(); 
        
        //Pour crée filme.txt
         // new ConvertAndModifData("Data/u.item","Data/Filme.txt").ModifiDataItemToFilme(); 
        
        //Pour  modifier U.user et aussi  crée le fichier profession pour qu'apré je mis son contenu dans jcombobox dans l'inscription
          //  new ConvertAndModifData("Data/u.user","Data/AllUser.txt").ModifDataUser();
        
        //Créé Data Train
    //    new ConvertAndModifData("Train&Test/u1test.txt","Train&Test/u1DataTrain.txt").CreatDataTrain(0,80000);
        
        // Crée Data Test
      //  new ConvertAndModifData("Train&Test/u1test.txt","Train&Test/u1testModf.txt").CreatDataTest(0,20000);
        
        //Crée Data Test Empty Target
     //   new ConvertAndModifData("Data/DataTest.txt","Data/DataTestEmptyTarget.txt").CreatDataTestEmptyTarget();
      
        //Créé Genre aimé PAr Chaque Profil;
     //   new GenreDEChaqueProfilOrUser().MoyenneNoteDuGenreAiméParChauqueProfil("Train&Test/u1.base", "Data/ToutGenreAvecNoteU1Train.txt");
            
       
      //      System.out.println(new GenreDEChaqueProfilOrUser().PredictNote("Train&Test/ToutGenreAvecNoteU1Train.txt", "JeuneHomme","M","technician","Crime|Thriller|")) ;
   // new ConvertAndModifData("Data/u.data", "Data/MovieBinaireFinalModfUnSeulGenre.txt").CreatDataTrain(0,10000);  
    
        //Création fichier similItem
    
    }
    
    
    
}
