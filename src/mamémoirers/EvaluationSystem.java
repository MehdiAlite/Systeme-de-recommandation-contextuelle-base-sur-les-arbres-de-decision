/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

import ca.pfv.spmf.algorithms.classifiers.decisiontree.id3.AlgoID3;
import ca.pfv.spmf.algorithms.classifiers.decisiontree.id3.DecisionTree;
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
public class EvaluationSystem {
    DecisionTree TreeProfil;
    
    public void CréationFichierEvaluation(String Train,String Test,String Sortie) throws IOException{
       
        //Train Mon Arbre
        AlgoID3 algo = new AlgoID3();
                  TreeProfil= algo.runAlgorithm(Train, "Note", " ");
                            algo.printStatistics();
                          // TreeProfil.print();
                           
       //Train Mon Systém
    //   systémPredict s=new systémPredict();
     //   s.SystémTrain(Train,"Note"," ");
                           
                           
       //Création du Fichier Détail Evaluation     
        BufferedReader br = new BufferedReader(new FileReader(Test));
         BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
        String line;
        int cpt=0;
        br.readLine();
        while((line = br.readLine()) != null) {
            String[] values = line.split("\\ ", -1);
           String [] instance2={values[0],values[1],values[2],values[3],null,values[5],values[6],values[7],values[8]};
                   //instance2[2]=null;
          
         //  String  Note=CalculMoyenDif(TreeProfil.predictTargetAttributeValue(instance2),new GenreDEChaqueProfilOrUser().PredictNote("Train&Test/ToutGenreAvecNoteU1Train.txt",values[0],values[1],values[2],values[3]));
                
            try {
                if(TreeProfil.predictTargetAttributeValue(instance2).equalsIgnoreCase("null")==false){
                    System.out.println(cpt);
                  //  Note=CalculMoyenDif(TreeProfil.predictTargetAttributeValue(instance2), new GenreDEChaqueProfilOrUser().PredictNote("Train&Test/ToutGenreAvecNoteU1Train.txt",values[0],values[1],values[2],values[3]));
               bw.write(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" "+values[6]+" "+values[7]+" "+values[8]+" "+TreeProfil.predictTargetAttributeValue(instance2)+"\n");
                }
            } catch (Exception e) {
           //     String idUser=new CalculeSimil().UserSimil(values[0]);
            //     String [] instance22={idUser,values[1],null,values[3],values[4],values[5],values[6]};
               //  System.out.println(cpt);
              //   bw.write(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" "+values[6]+" "+values[7]+" "+values[8]+" "+new GenreDEChaqueProfilOrUser().PredictNote("Train&Test/ToutGenreAvecNoteU1Train.txt",values[0],values[1],values[2],values[3]) +"\n");
        
           }
            cpt+=1;
             }
        br.close();
        bw.close();
       
     //  String [] instance22={"32","M","educator","Action|Adventure|Romance|Sci-Fi|War|",null,"vendredi","Vacance","Automne",""};
     //   String [] instance2={"30" ,"M", "student" ,"Drama|Musical|War|", null ,"vendredi", "Vacance" ,"Hiver" ,"06h"};
                       //   System.out.println("\n \n Note prédite : "+TreeProfil.predictTargetAttributeValue(instance2));
    }  
    
    public void CalculeErreur (String Fichier,int i,int j) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(Fichier));
        String line;
        int cpt=0;
        double RSE = 0,MAE=0;
        while((line = br.readLine()) != null) {
            String[] values = line.split("\\ ");
             System.out.println(values[i]+" | "+values[j]);
           if(cpt==0);
            else
            {  
                
                 
                try {
                    if(Double.parseDouble(values[i])>=Double.parseDouble(values[j])) {
                    RSE=RSE+Math.pow(Double.parseDouble(values[i])-Double.parseDouble(values[j]),2);
                    MAE=MAE+(Double.parseDouble(values[i])-Double.parseDouble(values[j]));
               }
                else {
                     RSE=RSE+Math.pow(Double.parseDouble(values[j])-Double.parseDouble(values[i]),2);
                    MAE=MAE+(Double.parseDouble(values[j])-Double.parseDouble(values[i]));
               }
               } catch (Exception e) {
                    RSE=RSE+Math.pow(Double.parseDouble(values[i])-3.5,2);
                    MAE=MAE+(Double.parseDouble(values[i])-3);
                }
                
            }
            cpt+=1;
            
            
        }
        br.close();
        //cpt=cpt+1;
       // System.out.println(cpt);
        System.out.println("cpt = "+cpt+" | MAE = "+MAE/cpt+" | RSE = "+Math.sqrt(RSE/cpt));
    }
    
    public static void main(String...Arg) throws IOException{
 
     //   new EvaluationSystem().CréationFichierEvaluation("Train&Test/uaBaseTrainModf.txt","Train&Test/uaBaseTestModf.txt","Train&Test/uaInfoEvaluation.txt"); 
       //System.out.println( new EvaluationSystem().Puis(3, 4));
   //  new EvaluationSystem().CalculeErreur("Train&Test/uaInfoEvaluation.txt",4,9);
     // new EvaluationSystem().CréationFichierEvaluationMonSystém("Data/DataTrain3.txt", "Data/DataTest3.txt", "Data/FichierEvaluationMnSys.txt");
    
        //Evaluation Pour Un seul User
    //    new EvaluationSystem().CréationFichierEvaluationForOneUser("Train&Test/User1TrainOneGenre.txt", "Train&Test/User1TestOneGenre.txt","Train&Test/EvaluationSystémForOneUserONeGenre.txt");
 //   new EvaluationSystem().CalculeErreur("Train&Test/EvaluationSystémForOneUserONeGenre.txt", 2,7 );
   
    }
    
public void CréationFichierEvaluationMonSystém(String Train,String Test,String Sortie) throws FileNotFoundException, IOException{
    systémPredict s=new systémPredict();
        s.SystémTrain(Train,"Note"," ");
        //Création du Fichier Détail Evaluation     
        BufferedReader br = new BufferedReader(new FileReader(Test));
         BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
        String line;
        int cpt=0;
        while((line = br.readLine()) != null) {
            String[] values = line.split("\\ ", -1);
           String [] instance2={values[0],values[1],values[2],values[3],null,values[5],values[6],values[7],values[8]};
         System.out.println();
               bw.write(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" "+values[6]+" "+values[7]+" "+values[8]+" "+s.SytémPredict(s.tb,instance2)+"\n");
        cpt+=1;
        }
        
        br.close();
        bw.close();
}

public String CalculMoyenDif(String NoteArbre,String NoteMonSys){
/*    double f1,f2,r;
    try {
        f1=Double.parseDouble(NoteArbre);
        try {
            f2=Double.parseDouble(NoteMonSys);
            r=(f2+f1)/2;
        } catch (Exception e) {
            r=f1;
        }
    } catch (Exception e) {
        try {
            f2=Double.parseDouble(NoteMonSys);
            r=f2;
        } catch (Exception ex) {
            r=3.5;
        }
    }*/
double r=(Double.parseDouble(NoteArbre)+(Double.parseDouble(NoteMonSys)))/2;
    return String.valueOf(r);
}

public void CréationFichierEvaluationForOneUser(String Train,String Test,String Sortie) throws IOException{
    
            //Train Mon Arbre
        AlgoID3 algo = new AlgoID3();
                  TreeProfil= algo.runAlgorithm(Train, "Like/Dislike", " ");
                            algo.printStatistics();
                            TreeProfil.print();
                            
                                                
       //Création du Fichier Détail Evaluation     
        BufferedReader br = new BufferedReader(new FileReader(Test));
         BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
        String line;
        int cpt=0;
        br.readLine();
        while((line = br.readLine()) != null) {
            String[] values = line.split("\\ ", -1);
           String [] instance2={values[0],values[1],null,values[3],values[4],values[5],values[6]};
        //try {
             //   if(TreeProfil.predictTargetAttributeValue(instance2).equalsIgnoreCase("null")==false){
                    System.out.println(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" "+values[6]+" "+TreeProfil.predictTargetAttributeValue(instance2));
                  //  Note=CalculMoyenDif(TreeProfil.predictTargetAttributeValue(instance2), new GenreDEChaqueProfilOrUser().PredictNote("Train&Test/ToutGenreAvecNoteU1Train.txt",values[0],values[1],values[2],values[3]));
               bw.write(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" "+values[6]+" "+TreeProfil.predictTargetAttributeValue(instance2)+"\n");
         //       }
          //  } catch (Exception e) {
           //     String idUser=new CalculeSimil().UserSimil(values[0]);
            //     String [] instance22={idUser,values[1],null,values[3],values[4],values[5],values[6]};
           //      System.out.println(cpt);
            //     bw.write(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" "+values[6]+" "+values[7]+" "+values[8]+" "+new GenreDEChaqueProfilOrUser().PredictNote("Train&Test/ToutGenreAvecNoteU1Train.txt",values[0],values[1],values[2],values[3]) +"\n");
        
           }bw.close();
        }
        
        

    
    }
    

