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
import javax.swing.JOptionPane;


public class ConvertAndModifData {
    String Entre,Sortie;
    
    public ConvertAndModifData(String entre,String Sortie){
        Entre=entre;
        this.Sortie=Sortie;
        
    }
    
    public void Convert() throws FileNotFoundException, IOException{
         BufferedReader br = new BufferedReader(new FileReader(Entre));
         BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
		LongToDateAndClass ld;
                QuelleGenreDeFilme Ql;
		String line;
                
		while((line = br.readLine()) != null) {
                    
			String[] values = line.split("\\t", -1);
                        ld=new LongToDateAndClass();
                        Ql=new QuelleGenreDeFilme();
                        ld.classificationUtilisantUnINstant(Long.decode(values[3]));
                        if(values[2].equalsIgnoreCase("3")||values[2].equalsIgnoreCase("4")||values[2].equalsIgnoreCase("5"))
                        bw.write(values[0] + "," + values[1] + "," + "Yes" + "," + ld.Jour + "," + ld.TypeJr + "," + ld.Saison + ","+ ld.TempHeur + "," + Ql.Recherch(values[1]) +"\n");
                        else  bw.write(values[0] + "," + values[1] + "," + "No" + "," + ld.Jour + "," + ld.TypeJr + "," + ld.Saison + ","+ ld.TempHeur + "," + Ql.Recherch(values[1]) +"\n");
                       
                }
		
		br.close();
		bw.close();
    }
    
    
    
    public void CrationDataGenre() throws FileNotFoundException, IOException{
         BufferedReader br = new BufferedReader(new FileReader(Entre));//u.item
          FileWriter fw=null;
          fw=new FileWriter(Sortie,true);
         BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));//toutGenre.txt
          QuelleGenreDeFilme Ql;
          String line,line2;
          LinkedList<String> Genre=new LinkedList<String>();
         	while((line = br.readLine()) != null) {
                   
                String[] Values =line.split("\\|");
                
                Ql=new QuelleGenreDeFilme();
                String Genr=Ql.Recherch(Values[0]);
                Boolean tr=false;
                if(Genre.isEmpty()) Genre.addLast(Genr);
                else {
                for(int i=0;i<Genre.size();i++){
                   if(Genre.get(i).equalsIgnoreCase(Genr)) tr=true;
                }
                if(tr==false) Genre.addLast(Genr);
                }
                
                }
        br.close();
       for(int i=0;i<Genre.size();i++) fw.write(Genre.get(i)+"\n");
       fw.close();
       // for(int i=0;i<Genre.size();i++) System.out.println(Genre.get(i));
    }
    
    public void ModifiDataItemToFilme() throws FileNotFoundException, IOException {
         BufferedReader br = new BufferedReader(new FileReader(Entre));
         BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
          String line,line2;
          QuelleGenreDeFilme Ql;
          int MieuNoté = 0,PlusVu=0;
          
         while((line=br.readLine())!=null){
             MieuNoté= 0;PlusVu=0;
             String[] Values=line.split("\\|",-1);
             Ql=new QuelleGenreDeFilme();
             String gnr=Ql.Recherch(Values[0]);
             BufferedReader brr=new BufferedReader(new FileReader("Data/MoviesBinaire.txt"));
             while((line2=brr.readLine())!=null){
                 String[] Values2=line2.split("\\ ",-1);
             
            if(Values[0].equalsIgnoreCase(Values2[0]) && Values2[1].equalsIgnoreCase("yes")) {PlusVu+=1;MieuNoté+=1;}
            else {PlusVu+=1;}
             }
              bw.write(Values[0]+"/"+Values[1]+"/"+gnr+"/"+PlusVu+"/"+MieuNoté+"\n");
         }
         bw.close();br.close();
    }
    
    public void ModifDataUser() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(Entre));
        BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
        String line;
        FileWriter fw=new FileWriter("Data/Proffession.txt",true);
        LinkedList<String> profession=new LinkedList<String>();
        boolean tr=false;
        while((line=br.readLine())!=null){
        tr=false;
        String[] values=line.split("\\|",-1);
        bw.write(values[0]+"|"+values[1]+"|"+values[2]+"|"+values[3]+"\n");
        if (profession.isEmpty()) profession.addLast(values[3]);
        else
        for(int i=0;i<profession.size();i++){
        if(profession.get(i).equalsIgnoreCase(values[3])) {tr=true;}
        }
        if(tr==false)profession.addLast(values[3]) ;
        }
        for(int i=0;i<profession.size();i++) fw.write(profession.get(i)+"\n");
       fw.close();
       bw.close();
       br.close();
    }
    
    public void CréationDataPourcalculSimilUser() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(Entre));
        BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
        String line;
        LongToDateAndClass ld = null;
        while((line = br.readLine()) != null) {
            String[] values = line.split("\\t", -1);
             ld=new LongToDateAndClass();
             ld.classificationUtilisantUnINstant(Long.decode(values[3]));
            if(values[2].equalsIgnoreCase("3")||values[2].equalsIgnoreCase("4")||values[2].equalsIgnoreCase("5"))
                        bw.write(values[0] + " " + values[1] + " " + "Yes"+" "+ld.TypeJr+" "+TempHeurToTemp(ld.TempHeur)+"\n");
                        else  bw.write(values[0] + " " + values[1] + " " + "No"+" "+ld.TypeJr+" "+TempHeurToTemp(ld.TempHeur)+"\n");
                       
        }
    }
    public String TempHeurToTemp(String tp){
        String []d=tp.split("h");
       if(5<Integer.parseInt(d[0]) && Integer.parseInt(d[0])<=12) return "Matin";
       else if(12<Integer.parseInt(d[0]) && Integer.parseInt(d[0])<=19) return "ApréMidi";
       else if(00<=Integer.parseInt(d[0]) && Integer.parseInt(d[0])<5) return "Nuit";
       else return "Soir";
    }
    
    
    public void CreatDataTrain(int From,int To) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(Entre));
         BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
		LongToDateAndClass ld;
                QuelleGenreDeFilme Ql;
		String line;
                int cpt=0;
		while((line = br.readLine()) != null) {
                    if(From<=cpt&&cpt<=To){
			String[] values = line.split("\\t", -1);
                        ld=new LongToDateAndClass();
                        Ql=new QuelleGenreDeFilme();
                        ld.classificationUtilisantUnINstant(Long.decode(values[3]));
                        
                        if(values[2].equalsIgnoreCase("3") || values[2].equalsIgnoreCase("4") || values[2].equalsIgnoreCase("5") )
                   bw.write(new RecherchUserInfo().rechrchUserParID(values[0]) + " " +new QuelleGenreDeFilme().ReturnUnSeulGenre(values[1]) + " " +"Yes"+" "+ ld.Jour + " " + ld.TypeJr + " " + ld.Saison + " "+ TempHeurToTemp(ld.TempHeur) +"\n");
                        else bw.write(new RecherchUserInfo().rechrchUserParID(values[0]) + " " +new QuelleGenreDeFilme().ReturnUnSeulGenre(values[1]) + " " +"No"+" "+ ld.Jour + " " + ld.TypeJr + " " + ld.Saison + " "+ TempHeurToTemp(ld.TempHeur) +"\n");
                    
                        // System.out.println("Id User : "+values[0]+"Id Item : "+values[1]);
                    } else break;
                    
                        cpt+=1;   
                }
		
		br.close();
		bw.close();
    }
    
    public void CreatDataTest(int From,int To) throws FileNotFoundException, IOException {
       BufferedReader br = new BufferedReader(new FileReader(Entre));
         BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
		LongToDateAndClass ld;
                QuelleGenreDeFilme Ql;
		String line;
                int cpt=0;
		while((line = br.readLine()) != null) {
                    if(From<cpt&&cpt<=To){
			String[] values = line.split("\\t", -1);
                        ld=new LongToDateAndClass();
                        Ql=new QuelleGenreDeFilme();
                        ld.classificationUtilisantUnINstant(Long.decode(values[3]));
                    
                        bw.write(new RecherchUserInfo().rechrchUserParID(values[0]) + " " + new QuelleGenreDeFilme().Recherch(values[1])+ " " + values[2]+ " " + ld.Jour + " " + ld.TypeJr + " " + ld.Saison + " "+ TempHeurToTemp(ld.TempHeur) +"\n");
                    } 
                    
                        cpt+=1;   
                }
		
		br.close();
		bw.close();
    }
    
    public void CreatDataTestEmptyTarget() throws FileNotFoundException, IOException{
         BufferedReader br = new BufferedReader(new FileReader(Entre));
         BufferedWriter bw = new BufferedWriter(new FileWriter(Sortie));
        String line;
        int cpt=0;
        while((line = br.readLine()) != null) {
            String[] values = line.split("\\ ", -1);
            bw.write(values[0]+" "+values[1]+" "+" "+" "+values[3]+" "+values[4]+" "+values[5]+" "+values[6]+"\n");
        }
        br.close();
        bw.close();
    }
}
