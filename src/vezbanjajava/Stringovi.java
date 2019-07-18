/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezbanjajava;

/**
 *
 * @author Korisnik
 */
public class Stringovi {
    public static void main(String[] args) {
       //StringBuilder s = new StringBuilder("Mica i bata (Boca) idu na (more) letovanje");
        //System.out.println("String sa zagradama je: "+s);
        //System.out.println("String bez zagrada je: "+ukloniZagrade(s));
        //System.out.println("Uklonjene samo zagrade: "+ukloniSamoZagrade(s));
       // System.out.println("Samo tekst u zagradama: "+ostaviZagrade(s));
        String s1="string za sortiranje";
        System.out.println("string >> "+s1+ ": sortiran >> "+sortiraj(s1));
        String s3="Danas    je lep()   () dan";
        System.out.println("praznine >> "+s3+": broj praznina >> "+maxPraznine(s3));
        String s = "Hiabc";
      
    }
    
    public static StringBuilder ukloniZagrade(StringBuilder text){
        int otvori = 0;
        int zatvori = 0;
        while(text.indexOf("(")>0){
            otvori=text.indexOf("(");
            zatvori=text.indexOf(")");
            text.delete(otvori, zatvori+1);
        }
        
        return text;
    }
    
    public static StringBuilder ukloniSamoZagrade(StringBuilder text){
        int zagradaPr = 0;
        int zagradaDr = 0;
        while(text.indexOf("(")>0){
            zagradaPr=text.indexOf("("); 
            zagradaDr=text.indexOf(")");
            text.deleteCharAt(zagradaPr);
            text.deleteCharAt(zagradaDr-1);//jos malo proveriti sta radi
        }
        return text;
    }
    
    public static String ostaviZagrade(StringBuilder text){//ovo ne radi dobro ne znam zasto
        String novi = "";
        int prva = 0;
        int druga = 0;
        while(text.indexOf("(")>0){
          prva = text.indexOf("("); 
          druga = text.indexOf(")");
          novi = novi.concat(text.substring(prva, druga+1));
        }
         return novi;
    }
    
    public static String sortiraj(String text){// ovo je ustvari laka metoda
        String sortiran = "";
        char[] nizSlova=text.toCharArray();
        for(int i = 'a'; i<'z'; i++){   //prolazak kroz niz znakova po azbucnom redu 
            for(int j = 0; j<nizSlova.length; j++){
                if((char)i == nizSlova[j]){
                   sortiran = sortiran + nizSlova[j];
                }
            }
        }
         return sortiran;
    }
    
    public static int maxPraznine(String text){
        int max =0;
        int br = 0;
        for(int i = 0; i < text.length(); i++){//prolazimo kroz string mesto po mesto
            if(text.substring(i, i+1).equals(" ")){ // dok ne dodjemo do praznine 
                br++;
            }
            else{
                if(br>max){
                    max=br;
                    br=0;
                }
            }
        }
        return max-1;//mislim da treba ovako dodatiti -1;
    }
    
    
}
