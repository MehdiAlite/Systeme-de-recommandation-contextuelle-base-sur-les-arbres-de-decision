/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

import Interface.F2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.StringValueExp;
import javax.swing.table.DefaultTableModel;


public class CalculeSimil {
    
    public String UserSimil(String idUser) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("Data/SimilUser.txt"));
        String line,IdSimil = null;
     DefaultTableModel InfoFilmUser=ListInfoUserSimil(idUser);
       double Res=1;
       
        for(int i=1;i<=943;i++){
       if(idUser.equalsIgnoreCase(String.valueOf(i))==false){
            DefaultTableModel InfoDUser=ListInfoUserSimil(String.valueOf(i));  
         Double d=DistanceJaccard(InfoFilmUser, InfoDUser);
          System.out.println("Id User : "+idUser + "| Id Autre User : "+i+" | Sim = "+d+"\n");
            if(d<Res){Res=d;IdSimil=String.valueOf(i);}
          }
       
        }
        return IdSimil;
       
        
    }
    
    public String ItemSimil(String IdItem) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("Data/SimilUser.txt"));
        String line,IdSimil = null;
     DefaultTableModel InfoFilm=ListInfoItemSimil(IdItem);
     double Res=1;
     for(int i=1;i<=1682;i++){
         if(IdItem.equalsIgnoreCase(String.valueOf(i))==false && new RechercheFilms().RetourNoteDeFilmeParId(String.valueOf(i))>300){
              DefaultTableModel InfoDFilm=ListInfoItemSimil(String.valueOf(i));
             Double d=DistanceJaccard(InfoFilm, InfoDFilm);
            // System.out.println("Id Item : "+IdItem+" | Id Autre Item : "+i+"| Sim = "+d+"\n");
             if(d<Res){Res=d;IdSimil=String.valueOf(i);}
         }
     }
     return IdSimil;
    }
    
    public DefaultTableModel ListInfoUserSimil (String idUser) throws FileNotFoundException, IOException{
         BufferedReader br = new BufferedReader(new FileReader("Data/SimilUser.txt"));
        String line;
        DefaultTableModel InfoFilmUser=new DefaultTableModel();
       
           InfoFilmUser.setColumnIdentifiers(new String[]{"Id","Note","TypeJr","Temp"});
        while((line = br.readLine()) != null) {
            String[] values=line.split("\\ ");
            SimilInfo in=new SimilInfo();
            if(values[0].equalsIgnoreCase(idUser)) {
            InfoFilmUser.addRow(new Object[] 
                     {values[1],values[2],values[3],values[4]});
            }
        }
        br.close();
        return InfoFilmUser;
        
    }
    
    public double DistanceJaccard(DefaultTableModel f1,DefaultTableModel f2){
        double Res=0,cpt=0,Inter=0;
        int Intersection=0,Union=0;
        for(int i=0;i<f1.getRowCount();i++){
            for(int j=0;j<f2.getRowCount();j++){
               if(String.valueOf(f1.getValueAt(i,0)).equalsIgnoreCase(String.valueOf(f2.getValueAt(j,0).toString()))) {
                    if(f1.getValueAt(i,1).toString().equalsIgnoreCase(f2.getValueAt(j,1).toString())) cpt=cpt+0.5;
                    if(f1.getValueAt(i,2).toString().equalsIgnoreCase(f2.getValueAt(j,2).toString()))cpt=cpt+0.2;
                    if(f1.getValueAt(i,3).toString().equalsIgnoreCase(f2.getValueAt(j,3).toString())) cpt=cpt+0.3;
                    Intersection+=1;
                    Inter+=cpt;
                    cpt=0;
                    //System.out.println(f1.getValueAt(i,1)+" | ");
                }
            }
        }
        Union=(f1.getRowCount()+ f2.getRowCount())-Intersection;
       // System.out.println("Jaccard Distance : "+  (Union-Inter)/Union);
        return (Union-Inter)/Union;
    }
    
    public DefaultTableModel ListInfoItemSimil(String IdItem) throws FileNotFoundException, IOException{
         BufferedReader br = new BufferedReader(new FileReader("Data/SimilUser.txt"));
        String line;
        DefaultTableModel InfoFilmUser=new DefaultTableModel();
       
           InfoFilmUser.setColumnIdentifiers(new String[]{"Id","Note","TypeJr","Temp"});
        while((line = br.readLine()) != null) {
            String[] values=line.split("\\ ");
            SimilInfo in=new SimilInfo();
            if(values[1].equalsIgnoreCase(IdItem)) {
            InfoFilmUser.addRow(new Object[] 
                     {values[0],values[2],values[3],values[4]});
            }
        }
        br.close();
        return InfoFilmUser;
    }
    
    public static void main(String...Arg) throws IOException{
     // **********Création du fichiers Simil Item-Item
    
        /*   BufferedWriter bw=new BufferedWriter(new FileWriter("Data/SimilItemItem.txt",true));
        try {
          //  JOptionPane.showMessageDialog(null, new CalculeSimil().UserSimil(Id.getText()));  
            LinkedList<String> l=new LinkedList<>();
            for(int i=1;i<1683;i++){
                System.out.println(i);
                bw.write(i+" "+new CalculeSimil().ItemSimil(String.valueOf(i))+"\n");
            }
            bw.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        //*****************Création Du Fichier Simil User-User
        
         BufferedWriter bw=new BufferedWriter(new FileWriter("Data/SimilUserUser.txt",true));
        try {
          //  JOptionPane.showMessageDialog(null, new CalculeSimil().UserSimil(Id.getText()));  
            LinkedList<String> l=new LinkedList<>();
            for(int i=1;i<944;i++){
                System.out.println(i);
                bw.write(i+" "+new CalculeSimil().UserSimil(String.valueOf(i))+"\n");
            }
            bw.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
