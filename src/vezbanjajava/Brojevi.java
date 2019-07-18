/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezbanjajava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.w3c.dom.ranges.RangeException;

/**
 *
 * @author Korisnik
 */
public class Brojevi {
    
    public static void main(String[] args) {
        
          int[] nizA = {5,6,7,8,8,8,77};
        savrseniBrojevi(28);
        suma(6);
    try{
         skratiRazlomak(0, 25);
    }catch(ArithmeticException e){
        System.out.println(e.getMessage());
    } 
    try{
        nzs(5, 65);
    }catch(RuntimeException e){
        System.out.println(e.getMessage());
    }    
     try{
          kubovi(3,222);
     }catch(RuntimeException e){
         System.out.println(e.getMessage());
         
     }
          daLiJeProst(23);
          rastaviNaFaktore(658);
          uredjeneCifre(5, 4);
          blizanci(55);
//          pojedinaSlova("Trazi nekooo * Sa zvezdom");
//          razlicitiElementi(nizA);
//          ciklicnoPomeranje(nizA, 3);
          prijateljskiBroj(300);
//          pojedinaSlovaII("Trazi nekooo * Sa zvezdom");
//          otpor(3, 4);
    }
    // 1. 
    public static void savrseniBrojevi(int m){ // tacno savrseni broj
        int br = 1;
        for(int i = 2; i<=m; i++){
            for(int j = 2; j<i; j++){
                if(i%j==0){
                   br = br + j; 
                }
            }if(br==i){
                System.out.print(": "+i);
            }
            br = 1;
        }
    }
    // 2.
    public static void suma(int n){// mislim da je sad dobro
        double faktor = 1;
        double suma = 3; 
        for(int i = 1; i<=n; i++){
            double pom = (int)Math.pow(-1, n+1)*(n*3);
            for(int j = 1; j <= Math.abs(pom); j++){
               faktor = faktor*j;
            }if(pom>0){
                suma = suma + faktor;
            }else{
                suma = suma - faktor;
            }
        }
        System.out.println("\nvezbanjajava.Brojevi.suma() >> "+suma);
    }
    // 3.
    public static void skratiRazlomak(int m, int n)throws ArithmeticException{
        if(n==0){
            throw new ArithmeticException("Nije moguce deljenje sa nulom");
        }
        int brojilac = m;
        int imenilac = n;
        for(int i = Math.min(m, n); i>0; i--){
           if(m%i==0 && n%i==0){
                brojilac = m/i;
                imenilac = n/i;
                break;
            }
        }
        if(brojilac == m && imenilac == n){
            System.out.println("\nnije moguce skratiti ovaj razlomak >> brojilac: "+brojilac+" imenilac: "+imenilac);  
        }else{
        System.out.println("Skraceni razlomak je >> brojilac: "+brojilac+" imenilac: "+imenilac);
        }
    } 
    // 4.
    public static void nzs(int m, int n) throws RuntimeException{// sada radi  UUUUU
        if(m==0||n==0){
            throw new RuntimeException("Brojevi moraju biti razliciti od 0");
        }
        int nzd = 1;
        int nzs = 1;
        for(int i = Math.min(m, n); i>0; i--){
            if(m%i==0 && n%i==0){
                nzd = i;
                break;
            }      
        }
        nzs = m*n/nzd;   //obratiti paznju da ovo stoju IZVAN for petlje
        System.out.println("NZS za brojeve >> "+m+ " i "+n+" je "+nzs);
    }
    // 5.
    public static void kubovi(int m, int n) throws RuntimeException{// radi dobro
        if(m<3||n<3||m==0||n==0){ //zasto mora biti veci od 2 
            throw new RuntimeException("Broj mora biti veci od 2");
        }if(n<m){
            throw new RuntimeException("Prvi broj mora biti manji od drugog");
        }
        List<Integer> lista = new ArrayList<>();
        double broj = 0;
        for(int i = m; i<n; i++){
            broj = Math.pow(i, 3); 
            if(broj%100==96){
                lista.add(i);
            }
        }if(lista.isEmpty()){
            System.out.println("Nema brojeva koji zadovoljavaju uslov");
        }else{
            System.out.println("Lista brojeva ciji kub se zavrsava sa 96 -- "+lista);
        }
        
        
    }
    // 6.
    public static void otpor(int brGr, int brOtp){//radi odlicno
        Scanner in = new Scanner(System.in);
        double re = 0;
        Map<Integer,Double> mapa = new HashMap<>();
        for(int i = 0; i<brGr; i++){
                System.out.println("unesite vrednosti za otpornike - "+(i+1)+" grane");
                for(int j = 0; j<brOtp; j++){
                    re = re + in.nextDouble();
                } 
                mapa.put(i, re);
                re = 0;
        }
        Collection<Double> vrednosti = mapa.values();
        double pom = 0;
        for(Double i : vrednosti){
             pom = pom +(1/i);
        }
        double ekvivalentniOtpor = 1/pom; 
        System.out.println("ekvivalentan otpor je -- "+ekvivalentniOtpor);
   
    
    }
    // 7.
    public static boolean daLiJeProst(int broj){// jos malo poboljsati na primer da se stampaju prosti brojevi
        boolean jeste = true;
        for(int i = 2; i < broj; i++){
            if(broj%i==0){
                jeste = false;
                break;
            }
        }
        if(jeste){
           // System.out.println("Broj: "+broj+" je prost");
            return jeste;
        }else{
            //System.out.println("Broj: "+broj+" nije prost");
            return jeste;
        }
       
    }
    // 8. 
    public static void rastaviNaFaktore(int broj){//ovo ne radi jos malo popraviti
        System.out.print("Broj "+broj+" rastavljen na faktore je -- ");
        List<Integer> faktori = new ArrayList<>();
        faktori.add(1);
        int faktor=2;
        while(broj>1){
            if(broj%faktor==0){
                broj=broj/faktor;
                faktori.add(faktor);
            }else{
                faktor++;
            }
        }
        System.out.println(faktori);
    }
    // 9.
    public static void uredjeneCifre(int broj, int stepen){// ne moze sa parsiranjem stringa  ili sa Integer.ValueOf()
        for(int i = 1; i<=broj; i++){
            Double st = Math.pow(i, stepen);
            String sb = st.toString();
            char[] cifre = sb.toCharArray();
            if(cifre.length==1){//mozda ovaj deo ni ne treba proveriti posle
                System.out.println(sb);
            }else{
            boolean rastuci = true;
            
            for(int j = 0; j< sb.length()-1; j++){
                // mora preko karaktera tj. Character.getNumericvalue() ZAPAMTI
                if((Character.getNumericValue(cifre[j])>Character.getNumericValue(cifre[j+1]))){
                    rastuci=false; 
                }
                if(rastuci==true){
                System.out.println(": "+sb);
                break;
                }
            }    
        }
        }
    }
    // 10.
    public static void blizanci(int broj){
        Map<Integer,Integer> mapa = new HashMap<>();
        for(int i = 1; i <= broj; i++){
            if(daLiJeProst(i) && daLiJeProst(i+2)){
                mapa.put(i, i+2);
            }
        }
         System.out.println("Brojevi blizanci -- "+mapa);
    }
    
    // 11.
    public static void prijateljskiBroj(int broj){
        Map<Integer,Integer> mapa = new HashMap<>();
        for(int i = 2; i<broj; i++){
            int blizanac = deliociSuma(i);
            for(int j = 2; j < broj; j++){
                if(j == blizanac && deliociSuma(j)== i && j!=i){
                    if(mapa.containsKey(j)){ // da ne dodje do ponavljanja
                        continue;
                    }
                    mapa.put(i, j);
                }
            }
        }
        System.out.println("Prijateljski brojevi su -- "+mapa);
        }
        
        
    
    public static int deliociSuma(int broj){
        int suma = 0;
        for(int i = 1; i<broj; i++){
            if(broj%i==0){
                suma = suma + i;
            }
        }
        return suma;
    }
    
    // 12.
    public static void pojedinaSlova(String text){//nesto slicno obavezno popraviti sutra
        char[] niz = text.toLowerCase().toCharArray();
        Map<Character,Integer> mapa = new HashMap<>();
        for(char c: niz){
            int br = 0;
            for(int i = 0; i < niz.length; i++){
               if(niz[i]==c){
                   br++;
               }
                mapa.put(c, br);
            }
        }
        System.out.println("Broj pojavljivanja slova do * -- "+mapa);
    }
    
    public static void pojedinaSlovaII(String text){//radi kako treba
        int br = text.indexOf("*");
        String novi = text.substring(0, br).toLowerCase();
        Map<Character,Integer> mapa = new HashMap<>();
        for(int i = 0; i < novi.length(); i++){
            if(novi.substring(i, i+1).equals(" ")){
                break;
            }
            int brojac = 0;
            for(int j = 0; j<novi.length(); j++){
                if(novi.substring(i, i+1).equals(novi.substring(j, j+1))){
                    brojac++;
                }
            }
            mapa.put(novi.charAt(i), brojac);
        }
        System.out.println("Broj pojavljivanja na drugi nacin -- "+mapa);
    }
    
    
    // 13.
    public static void razlicitiElementi(int[] A){
        Set<Integer> brojevi = new HashSet<>();
        for(int i = 0; i<A.length; i++){
            brojevi.add(A[i]);
        }
        System.out.println("Razliciti elementi niza su -- "+brojevi.toString()+" ukupno -- "+brojevi.size());
        }
      

    // 14.
    public static void ciklicnoPomeranje(int[] niz, int br){
        if(niz.length<2){
            System.out.println("Potrebno je da niz ima bar dva clana");
        }
        if(br>=niz.length){
            System.out.println("Broj pomeraja mora biti manji od duzine niza");
        }
        if(br<niz.length){              // ovo sa if uslovima treba malo srediti
        int[] novi = new int[niz.length];
        int index = 0;
        for(int i = br; i<niz.length; i++){
            novi[index]=niz[i];
            index++;  
        }
        for(int j = 0; j<br; j++){
            novi[index]=niz[j];
            index++;  
            
        }
        System.out.println("Ciklicno pomeren niz "+Arrays.toString(niz)+" --- "+Arrays.toString(novi));
    }
    
    // 15. nisam ni razmotrila sta znaci    
    } 
    
   
    
}

