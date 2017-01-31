/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import ca.pfv.spmf.algorithms.classifiers.decisiontree.id3.AlgoID3;
import ca.pfv.spmf.algorithms.classifiers.decisiontree.id3.DecisionTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mamémoirers.Filme;
import mamémoirers.QuelleGenreDeFilme;
import mamémoirers.RecherchUserInfo;

/**
 *
 * @author Acer
 */
public class TryQuelleGenre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
  /*      BufferedReader br=new BufferedReader(new FileReader("Data/ToutGenre.txt"));
        LinkedList<String> Toutgenre=new LinkedList<>();
       LinkedList<Filme> ListFilme=new LinkedList<Filme>();
       DecisionTree TreeProfil=new DecisionTree();
       AlgoID3 algo = new AlgoID3();
       try {
            br = new BufferedReader(new FileReader("Data/ToutGenre.txt"));
            String line;
            try {
                while((line=br.readLine())!=null){
                Toutgenre.addLast(line);
                }
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
          //  JOptionPane.showMessageDialog(null, "Fichier "+FichierEntre+" Introuvable.");
        }
        try {
            TreeProfil= algo.runAlgorithm("Data/MovieBinaireFinalModfUnSeulGenre.txt", "Like/Dislike", " ");
        } catch (IOException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }
                            algo.printStatistics();
                           TreeProfil.print();
                           for(int i=0;i<Toutgenre.size();i++){       
                           String [] inst={"Adulte","M","writer",Toutgenre.get(i),null,"jeudi","Normal","Hiver","ApréMidi"};
                           System.out.println(Toutgenre.get(i)+" : "+TreeProfil.predictTargetAttributeValue(inst));
                           }*/
        
        
        
        BufferedWriter bw=new BufferedWriter(new FileWriter("Data/ListFilm.txt",true));
        String line ;
       // for(int i=1;i<3;i++){
            BufferedReader br=new BufferedReader(new FileReader("Data/u.data"));
        bw.write(new RecherchUserInfo().rechrchUserParID(String.valueOf(i))  +" ");
            while((line=br.readLine())!=null){
                String [] values=line.split("\\t",-1);
              
                if(/*String.valueOf(i)*/"1".equalsIgnoreCase(values[0])){
                     System.out.println("1"+" "+values[1]);
                    bw.write(/*new RecherchUserInfo().rechrchUserParID(String.valueOf(1))+*/" "+values[1]+" ");
                    
                }//bw.write("\n");
                
            }
            br.close();
       // }
        bw.close();
        
     /*     DecisionTree TreeProfil=new DecisionTree();
       AlgoID3 algo = new AlgoID3();
       TreeProfil=algo.runAlgorithm("Data/ListFilm.txt", "Filme"," ");
       TreeProfil.print();*/
        
    }
    
}
