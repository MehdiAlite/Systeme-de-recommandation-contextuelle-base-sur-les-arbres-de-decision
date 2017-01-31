/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mamémoirers;

/**
 *
 * @author Acer
 */
public class Filme {
    public String Nom;
    public String Date;
    public String Id;
    public int Note;    
    
    public void affich(){
         System.out.println("Id : "+Id+" Nom Du filme : "+Nom+"| Date : "+Date+"\n");
    }
    
    public String affich2(){
        String k=("Id: "+Id+" | Nom Du filme: "+Nom+" | Date: "+Date+" | Nbr De Vu: "+ Note +"\n");
        return k;
    }
}
