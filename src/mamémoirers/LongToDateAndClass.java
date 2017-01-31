/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class LongToDateAndClass {
    long time; 
    Instant instant;
    Date date;
    String [] dateString;
   public  String Jour,TypeJr="Normal",TempHeur,Saison;
    public LongToDateAndClass(){
        
    }
    
    public void AfficheDateString(){
        for(int i=0;i<dateString.length;i++)
            System.out.println(dateString[i]);
    }
    
    public void classificationUtilisantUnINstant(long time){
       // String dt= dateString[1]+"/"+dateString[2];
         this.time=time;
        instant=java.time.Instant.ofEpochSecond(time); // jdk 8 pour convertir ce temp since 1970 to instant
        date=Date.from(instant); // instant on le convertit on date pour le format béh apré ntésté 3la les jrs
        DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); // type de date li fihe les jrs 
        dateString= fullDateFormat.format(date).toString().split(" "); // on  co,nverti notre date en String et on le metttre dans un tableau
    
        int t=Integer.parseInt(dateString[1]); // 
       System.out.println(TypeJr);
       
        if(dateString[0].equalsIgnoreCase("vendredi") || dateString[0].equalsIgnoreCase("samedi")) {TypeJr="Vacance";} 
            if(15<=t && t<=30){
                 if (dateString[2].equalsIgnoreCase("novembre") || dateString[2].equalsIgnoreCase("mars")) {TypeJr="Vacance";}
                             }
        if(dateString[2].equalsIgnoreCase("décembre") || dateString[2].equalsIgnoreCase("janvier") || dateString[2].equalsIgnoreCase("février")){Saison="Hiver";}
        if(dateString[2].equalsIgnoreCase("mars") || dateString[2].equalsIgnoreCase("avril") || dateString[2].equalsIgnoreCase("mai")){Saison="Printemp";}
        if(dateString[2].equalsIgnoreCase("juin") || dateString[2].equalsIgnoreCase("juillet") || dateString[2].equalsIgnoreCase("août")){Saison="été";TypeJr="Vacance";}
        if(dateString[2].equalsIgnoreCase("septembre") || dateString[2].equalsIgnoreCase("octobre") || dateString[2].equalsIgnoreCase("novembre")){Saison="Automne";}
        Jour=dateString[0];
        TempHeur=dateString[4]+dateString[5];
        System.out.print("Jour : "+Jour+"\n Type du Jour : "+TypeJr+"\n Saison : "+Saison+"\n Temp : "+TempHeur+"\n");
                
    }
    
    public void classificationUtilisantUneDate(String[] date){
        this.dateString=date;
        // String dt= dateString[1]+"/"+dateString[2];
        int t=Integer.parseInt(dateString[1]); // 
       //System.out.println(TypeJr);
       
        if(dateString[0].equalsIgnoreCase("vendredi") || dateString[0].equalsIgnoreCase("samedi")) {TypeJr="Vacance";} 
            if(15<=t && t<=30){
                 if (dateString[2].equalsIgnoreCase("novembre") || dateString[2].equalsIgnoreCase("mars")) {TypeJr="Vacance";}
                             }
        if(dateString[2].equalsIgnoreCase("décembre") || dateString[2].equalsIgnoreCase("janvier") || dateString[2].equalsIgnoreCase("février")){Saison="Hiver";}
        if(dateString[2].equalsIgnoreCase("mars") || dateString[2].equalsIgnoreCase("avril") || dateString[2].equalsIgnoreCase("mai")){Saison="Printemp";}
        if(dateString[2].equalsIgnoreCase("juin") || dateString[2].equalsIgnoreCase("juillet") || dateString[2].equalsIgnoreCase("août")){Saison="été";TypeJr="Vacance";}
        if(dateString[2].equalsIgnoreCase("septembre") || dateString[2].equalsIgnoreCase("octobre") || dateString[2].equalsIgnoreCase("novembre")){Saison="Automne";}
        Jour=dateString[0];
        TempHeur=dateString[4]+dateString[5];
        System.out.print("Jour : "+Jour+"\n Type du Jour : "+TypeJr+"\n Saison : "+Saison+"\n Temp : "+TempHeur+"\n");
       
    }
}
