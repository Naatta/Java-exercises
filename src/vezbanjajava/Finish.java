/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezbanjajava;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Korisnik
 */
public class Finish {
    
    public static void main(String[] args) {
        int[] A = {7,45};
        short[] B = {1,2,3,5,8,13};
        try{
            System.out.println("Nizovi - "+Arrays.toString(A)+" - "+Arrays.toString(A)+" da li se sadrze -- "+daLiSeSadrze(A, A));
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
         System.out.println("vrati najveci -- "+najveciApsolutno(A));
         System.out.println("Vrati naredni -- "+vratiNaredni(B));
         System.out.println("Vrati kontrolnu cifru za broj - 200501879501L -- "+vratiKontrolnuCifru(200501879501L));
         pojavljujeVisePuta("mmmaaaCCCaklhg");
         System.out.println("Da li je rec palindrom --anaVoliMilovana-- "+daLiJePalindrom("anaVoliMilovana"));
         vracanjeKusura(1004, 1350);
    }
    
    
public static boolean daLiSeSadrze(int[] niz1, int[] niz2) throws RuntimeException, NullPointerException {
    if(niz1==null || niz2==null){
        throw new NullPointerException("Niz nije definisan");
    }
    if(niz1.length<2 || niz2.length<2){
        throw new RuntimeException("Niz ima manje od dva clana ili je prazan");
    }
    String stNiz1="";
    for(int i: niz1){
        stNiz1=stNiz1+" "+i;
    }
    String stNiz2="";
    for(int j: niz2){
        stNiz2=stNiz2+" "+j;
    }if(stNiz1.length()<stNiz2.length()){
        return stNiz2.contains(stNiz1);
    }else{
        return stNiz1.contains(stNiz2);
    }
    
}   


    public static int najveciApsolutno(int... brojevi){
        if(brojevi==null || (brojevi!=null && brojevi.length==0)){
            System.out.println("Nema najmanje dva elementa, pogresno definisano");
        }
        int min = brojevi[0];
        for(int i = 0; i < brojevi.length; i++){
            if(brojevi[i]<min){
                min=brojevi[i];
            }
        }
        int max = min;
        for(int i = 0; i < brojevi.length; i++){
            if(brojevi[i]>max){
                max=brojevi[i];
            }
        }
        if(Math.abs(max)== Math.abs(min)||Math.abs(max)>Math.abs(min)){
            return max;
        }else{
            return min;
        }
}
    
    public static short vratiNaredni(short[] elementi){
        if(elementi==null){
            System.out.println("Baci gresku");
        }
        if(elementi.length<2){
            System.out.println("niz nema dovoljno elemenata");
        }
        int rezultat = -1;
        for(int i = 1; i<elementi.length-1; i++){
            if(elementi[i+1] != elementi[i]+elementi[i-1]){
               break;
            }else{
              rezultat = elementi[elementi.length-2] + elementi[elementi.length-1];  
            }
        }
        return (short)rezultat;
}
    
    public static int vratiKontrolnuCifru(Long broj){//jos malo pogledati sutra
        if(broj==null){
            System.out.println("Broj nije dobro drfinisan");
        }
        char[] cifre = broj.toString().toCharArray();
        int mnozilac = 7;
        int suma = 0;
        for(char c: cifre){
            suma = suma + Character.getNumericValue(c)*mnozilac;
            mnozilac = mnozilac -1< 2 ? 7 : --mnozilac;
        }
        int kontrolniBroj  = 11-suma % 11;
        return kontrolniBroj > 9 ? 0 :kontrolniBroj;
    } 
    
// 16. svako slovo koje se pojavljuje vise puta    
    public static void pojavljujeVisePuta(String rec){
        char[] slova = rec.toLowerCase().toCharArray();
        Map<Character,Integer> proverena = new HashMap<>();
        for(char s :slova){
            if(proverena.containsKey(s)){
                continue;
            }
            int br = 0;
            for(char c : slova){
                if(s==c){
                    br++;
                }
            }
            if(br>1){
              proverena.put(s, br);  
            }
        }
        System.out.println("Vise puta se ponavljaju -- "+proverena);
    }
    
// 11. da li je palindrom 
    public static boolean daLiJePalindrom(String rec){
        char[] slova = rec.toLowerCase().toCharArray();
        boolean pal = true;
        for(int i = 0; i<slova.length; i++){
            if(slova[i]!=slova[slova.length-1-i]){
                pal = false;
            }
        }
        return  pal;
    }
     
// 15. vracanje kusura
   public static void vracanjeKusura(int racun, int iznos){//srediti
       Map<Integer,Integer> mapa = new HashMap<>();
       int kusur = iznos - racun;
       
       if(kusur == 0){
           System.out.println("Nema kusura");
       }
       if(kusur < 0){
           System.out.println("Niste dali dovoljno novca");
   }else{
       if(kusur>=100){
         kusur = kusur/100; 
         mapa.put(100, kusur);
         kusur = kusur-kusur*100;
       }
       if(kusur>=50){
         kusur = kusur/50;
         mapa.put(50, kusur);
         kusur = kusur-kusur*50;
       }
       if(kusur>=10){
         kusur = kusur/10;
         mapa.put(10, kusur);
         kusur = kusur-kusur*10;
         mapa.put(10, racun);
       }
       System.out.println("Vracen kusur je -- "+mapa);  
    }
   }
}
