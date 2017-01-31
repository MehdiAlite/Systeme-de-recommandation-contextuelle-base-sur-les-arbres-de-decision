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
import java.util.LinkedList;

/**
 *
 * @author Acer
 */
public class DecisionTreeForOneUser {
    String IdUser;
    String UrlSortie;
    String File;
    public DecisionTreeForOneUser(){ 
        
    
    }
    
    public void CreationDataOneUser(String File,String IdUser) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(File));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Data/User"+IdUser+".txt"));
        String line;
        String[] values=new String[161];
        LongToDateAndClass ld;
        QuelleGenreDeFilme Ql;
		bw.write("IdUser"+" "+"GenreFilm"+" "+"Like/Dislike "+"Day "+"KindOfDay "+"Season "+"Time "+"\n");
		while((line = br.readLine()) != null) {
                   
                        
			values = line.split("\\t", -1);
                        
                        
                        if(values[0].equalsIgnoreCase(IdUser)) {
                            ld=new LongToDateAndClass();
                        Ql=new QuelleGenreDeFilme();
                        ld.classificationUtilisantUnINstant(Long.decode(values[3]));
                        if(values[2].equalsIgnoreCase("3") || values[2].equalsIgnoreCase("4") || values[2].equalsIgnoreCase("5") )
                     bw.write(values[0]+ " " +new QuelleGenreDeFilme().ReturnUnSeulGenre(values[1]) + " " +"Yes"+" "+ ld.Jour + " " + ld.TypeJr + " " + ld.Saison + " "+ new ConvertAndModifData("","").TempHeurToTemp(ld.TempHeur) +"\n");
                    else   bw.write(values[0] + " " +new QuelleGenreDeFilme().ReturnUnSeulGenre(values[1]) + " " +"No"+" "+ ld.Jour + " " + ld.TypeJr + " " + ld.Saison + " "+ new ConvertAndModifData("","").TempHeurToTemp(ld.TempHeur) +"\n");
                 //  bw.write(values[0]+ " " +new QuelleGenreDeFilme().ReturnUnSeulGenre(values[1]) + " " +values[2]+" "+ ld.Jour + " " + ld.TypeJr + " " + ld.Saison + " "+ new ConvertAndModifData("","").TempHeurToTemp(ld.TempHeur) +"\n");
                
                        }
                }
		       
		br.close();
		bw.close();
    }
    
    public void creationDataText() throws FileNotFoundException, IOException{
     BufferedReader br = new BufferedReader(new FileReader("Data/moviesBinaire.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Data/MoviesBinaireModf.txt"));
        String line;
        String[] values=new String[161];
		bw.write("Age "+"Sex "+"Occupation "+"IdFilm "+"Like/Dislike "+"Day "+"KindOfDay "+"Season "+"Time "+"Genre \n");
		while((line = br.readLine()) != null) {
                    
			values = line.split("\\,", -1);
                        bw.write(new RecherchUserInfo().rechrchUserParID(values[0])+" "+values[1]+" "+values[2]+" "+values[3]+ " " +values[4]+ " " + values[5] + " "+ values[6] +"\n");
                 
                       // if(values[2].equalsIgnoreCase("3")||values[2].equalsIgnoreCase("4")||values[2].equalsIgnoreCase("5"))
                        //else  bw.write(values[0] + "," + values[1] + "," + "No" + "," + ld.Jour + "," + ld.TypeJr + "," + ld.Saison + ","+ ld.TempHeur + "," + Ql.Recherch() +"\n");
                       
                }
		       
		br.close();
		bw.close();
       
    }
    
    public void GenerateDecisionTree(String Url) throws IOException{
        // Read input file and run algorithm to create a decision tree
		AlgoID3 algo = new AlgoID3();
		// There is three parameters:
		// - a file path
		// - the "target attribute that should be used to create the decision tree
		// - the separator that was used in the file to separate values (by default it is a space)
		DecisionTree tree = algo.runAlgorithm(Url, "Like/Dislike", " ");
		algo.printStatistics();
		
		// print the decision tree:
		tree.print();
		
		// Use the decision tree to make predictions
		// For example, we want to predict the class of an instance:
		//String [] instance = {"22",null, "jeudi", "Normal", "Hiver", "17h", "| Action| Adventure| Comedy| War"};
               String [] instance={"1",null,"lundi","Normal","Automne","08h","|Drama"};
		String prediction = tree.predictTargetAttributeValue(instance);
                for(int i=0;i<instance.length;i++)
                    System.out.print(instance[i]+" ");
		System.out.println("\n The class that is predicted is: " + prediction);
    }
    
   /* public String[] GenreRech() throws FileNotFoundException, IOException{
         BufferedReader br = new BufferedReader(new FileReader("Data/Genre.txt"));
         String line;
         String[] values = null;
		while((line = br.readLine()) != null) {
                values = line.split("\\ ", -1);
                }
        return values;
        
    }*/
    
}
