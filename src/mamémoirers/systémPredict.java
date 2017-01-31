/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import sun.security.util.Length;

/**
 *
 * @author Acer
 */
public class systémPredict {
    
    public DefaultTableModel tb;
    
    public void SystémTrain(String File, String Target, String Regx) throws FileNotFoundException, IOException{
        int ColumnTarget=-1;
         BufferedReader br = new BufferedReader(new FileReader(File));
         String [] l=br.readLine().split(Regx);
         String line;
         System.out.println("\n\n Systém Train...");
         
         // Pour obtenire l'emplacement du target
         for(int i=0;i<l.length;i++) if(l[i].equalsIgnoreCase(Target)) ColumnTarget=i;
         
         // Créés les collonnes de notre table
    DefaultTableModel tablen=new DefaultTableModel();
      tablen.setColumnIdentifiers(l);
      
         while((line=br.readLine())!=null){
             String [] values=line.split(Regx);
             if(tablen.getRowCount()==0)
                 tablen.addRow(values);
             else {
                MisAjourTable(tablen, values, ColumnTarget);
             }
         }
         br.close();
         
         System.out.println("Systém Train Finish.");
         tb=tablen;
    }
    
    public void MisAjourTable(DefaultTableModel table,String [] t2,int ColumnTarget){
        boolean tr=false,br=true;
        int NumLigne=-1,cpt=0;
       // System.out.print("\n Table :"+"\n");
        for(int i=0;i<table.getRowCount();i++){
         for(int j=0;j<table.getColumnCount();j++){
            System.out.println(i);
      //  System.out.print(table.getValueAt(i,j).toString()+" VS "+t2[j]+"\n");
         if(table.getValueAt(i,j).toString().equalsIgnoreCase(t2[j])) {/*System.out.println(table.getValueAt(i,j).toString()+" Amie "+t2[j]+"\n");*/tr=true;cpt+=1;}
         else tr=false;
        if(tr=true && cpt==8) {/*System.out.println("in If 1 : Num ligne = "+NumLigne);*/NumLigne=i; break;}
         }
         if(cpt==8) break;
       //  System.out.println(tr+" "+cpt+" "+NumLigne+"\n");
        
         cpt=0;
         tr=false;
        } 
        if(NumLigne>-1){//System.out.println("in If ;)  Num ligne = : "+NumLigne+"\n");
          double res=(Double.parseDouble(table.getValueAt(NumLigne, ColumnTarget).toString())+Double.parseDouble(t2[ColumnTarget]))/2;
                    table.setValueAt(res, NumLigne, ColumnTarget);
                            }
         else {/*System.out.println("In Else ;) ");*/table.addRow(t2);/*break;*/}
                    
            }
    
    public String SytémPredict(DefaultTableModel tab,String [] ins){
        double res=0.0,calc=0.0;
        int cpt=0;
        String k="";
        String Note = null;
        for(int i=0;i<tab.getRowCount();i++){
        if(tab.getValueAt(i,0).toString().equalsIgnoreCase(ins[0])) {res=res+0.15;}
        if(tab.getValueAt(i,1).toString().equalsIgnoreCase(ins[1])) {res=res+0.15; }
        if(tab.getValueAt(i,2).toString().equalsIgnoreCase(ins[2])) {res=res+0.15; }
        if(tab.getValueAt(i,4).toString().equalsIgnoreCase(ins[4])) {res=res+0.15; }
        if(tab.getValueAt(i,3).toString().equalsIgnoreCase(ins[3])) {res=res+0.2;}
        if(tab.getValueAt(i,5).toString().equalsIgnoreCase(ins[5])) {res=res+0.1; }
        if(tab.getValueAt(i,6).toString().equalsIgnoreCase(ins[6])) {res=res+0.05; }
        if(tab.getValueAt(i,8).toString().equalsIgnoreCase(ins[8])) {res=res+0.05; }
        if(res>calc){
            calc=res;
            Note=tab.getValueAt(i,4).toString();
          //  k="Note : "+calc+" | "+tab.getValueAt(i,0).toString()+" "+tab.getValueAt(i,1).toString()+" "+tab.getValueAt(i,2).toString()+" "+tab.getValueAt(i,3).toString()+" "+tab.getValueAt(i,4).toString() +" "+tab.getValueAt(i,5).toString()+" "+tab.getValueAt(i,6).toString()+" "+tab.getValueAt(i,7).toString()+" "+tab.getValueAt(i,8).toString();
        res=0;
        }
       // System.out.println(i+" : "+k);
        //k="";
        res=0;
        }
       // System.out.println("le plus similaire est : "+k);
        return Note;
    }
        
    
    
    
    
}
