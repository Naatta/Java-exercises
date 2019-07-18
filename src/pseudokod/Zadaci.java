/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudokod;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Korisnik
 */
public class Zadaci {
    
    public static void main(String[] args) {
        
        int[] niz1 = {3,6,9};
        int[] niz2 = {9,45,89};   
        String[] str1 = {"mama","bocauuu","boki"};
        String[] str2 = {"boca","maca","koca"};
        String str = "Učitati tekst i rastaviti ga na reči Zadatak27";
        int[] staz = {15,18,25,5};
        double[] plata ={35000.00, 36000.00, 38000.00, 30000.00};
        
        
    //    pojavljujeVisePuta();
    //    zbirNeparnihCifara();
    //    najvisePutaPojavljuje();
    //    nisuDeljiviSa3(niz1, niz2);
    //    veciOdMax(niz1, niz2);
    //    razlomak(niz1, niz2);
    //    spojNiz(str1, str2);
        samoglasnici(str1, str2);
    //    daLiJeSamoglasnik("misterija");
    //    5rastaviNaReciII(str);
    //    korekcijaPlate(staz, plata);
    //    System.out.println("Datum 15.06.2018. je "+datumPlacanja("2017-12-12"));
//       try{
//        ucitajNizZnakova();
//       }catch(NegativeArraySizeException e){
//           System.out.println(e.getMessage());
//       }
       
        System.out.println("\nNizovi su identicni -- "+daLiSuIdenticni(str1, str2));
        System.out.println("Nizovi su inverzni -- "+daLiSuInverzni(str1, str2));
    }
    

// 18. zadatak
    public static void pojavljujeVisePuta(){
        String[] znaci = new String[10];
        Scanner in = new Scanner(System.in);
        for(int i= 0; i<10; i++){
           System.out.print("unesi "+(i+1)+" znak -- ");
           znaci[i] = in.next();
        }
        System.out.print("\nunesi znak za pretragu -- ");
        String z = in.next();
        int br = 0;
        for(String s: znaci){
            if(s.equals(z)){
               br++;
            }
        }if(br<1){
            System.out.println("Nema trazenog znaka za pretragu");
        }else{
             System.out.println("Broj pojavljivanja znaka "+z+ " je "+br);
        }
    }
   
// 19. zadatak
    public static void zbirNeparnihCifara(){ // obraditi greske za varijante sa zancima ili sa nulom
        Scanner in = new Scanner(System.in);
        System.out.print("unesi prvi broj -- ");
        String pr = in.next();
        System.out.print("\nunesi drugi broj -- ");
        String dr = in.next();
        String prDr = pr.concat(dr);
        char[] cifre = prDr.toCharArray();
        int sum = 0;
        for(char c: cifre)
           if(Character.getNumericValue(c)%2!=0){
               sum = sum + Character.getNumericValue(c);
           }
        System.out.println("suma neparnih cifara za brojeve "+pr+ " i "+dr+ " je -- "+sum);
    }
    
// 20. zadatak
    public static void najvisePutaPojavljuje(){// takodje obraditi greske 
        Scanner in = new Scanner(System.in);
        System.out.print("unesi prvi broj -- ");
        String pr = in.next();
        System.out.print("\nunesi drugi broj -- ");
        String dr = in.next(); 
        String prDr = pr.concat(dr);
        char[] cifre = prDr.toCharArray();
        int max=0;
        char n = ' ';
        for(char c: cifre){//mnogo je lakse sa pomocnom metodom za prebrojavanje
            int br = 0;
            for(int i = 0; i<cifre.length-1;i++){
                if(c==cifre[i]){
                    br++; 
                }
            }
            if(br>max){// sta ako vise cifara imaju isti broj pojavljivanja
                max=br; 
                n = c;
            }
        }
        System.out.println("najvise puta se ponavlja -- "+n+":  puta -- "+max);
    }    

// 21. zadatak    
    public static void nisuDeljiviSa3(int[] niz1, int[] niz2){//preskocila sam ucitavanje
        if(niz1==null || niz2==null || niz1.length==0 || niz2.length==0){ 
            System.out.println("Nizovi nisu definisani");
        }else{
           
        int zbir = 0;
        for(int i: niz1){
            if(i%3!=0){
                zbir = zbir+i;
            }
        }
        for(int j : niz2){
            if(j%3!=0){
                zbir = zbir+j;
            }
        }
        if(zbir==0){
            System.out.println("nema brojeva koji nisu deljivi sa 3");
        }
        else{
           System.out.println("zbir brojeva koji nisu delivi sa 3 je -- "+zbir);  
        }
        }
    }
    
// 22. zadatak
    public static void veciOdMax(int[] niz1, int[] niz2){// ovo takodje moze da se doradi
        int max = 0;
        for(int n : niz1){
            if(n>max){
                max=n;
            }                    // da se na primer prikazu ti brojevi, ucita niz i sl.
        }
        int br = 0;
        for(int n: niz2){
            if(n>max){
                br++;
            }
        }
        System.out.println("Broj elemenata drugog niza kouji su veci od "+max+ " je -- "+br);
    }  
    
// 23. zadatak od dva niza napraviti razlomak
    public static void razlomak(int[] niz1, int[] niz2){
        double[] razlomci = new double[niz1.length];
        for(int i = 0; i< niz1.length; i++){
            razlomci[i]= (double)niz1[i]/niz2[i];
        }
        
            System.out.println("Niz razlomaka ie -- "+Arrays.toString(razlomci));
        
    }
    
// 24. zadatak    
    public static void spojNiz(String[] niz1, String[] niz2){
        if(niz1.length!=niz2.length){
            System.out.println("Potrebno je da oba niza budu iste duzine");
        }else{
            String[] spojeni = new String[niz1.length];
            for(int i = 0; i<niz1.length; i++){
                spojeni[i]=niz1[i]+niz2[i];
            }
            for(String s :spojeni){
                System.out.print(" - "+s);
            }
        }
    }
    
// 25. zadatak
    public static int prebrojZnak(char s, String[] niz){
        int br = 0;
        for(int i = 0; i < niz.length; i++){
            String p = niz[i];//.toLowerCase();
            char[] znaci = p.toCharArray();
                for(char c: znaci){
                    if(c == s)
                    br++;
                }
        }
        return br;
        }
        
    
    
    public static void samoglasnici(String[] niz1, String[] niz2){// ne razumem zasto ne radi
        int[] samoglasnici = new int[5];
        samoglasnici[0] = prebrojZnak('a', niz1) + prebrojZnak('a', niz2);
        samoglasnici[1] = prebrojZnak('e', niz1) + prebrojZnak('e', niz2);
        samoglasnici[2] = prebrojZnak('i', niz1) + prebrojZnak('i', niz2);
        samoglasnici[3] = prebrojZnak('o', niz1) + prebrojZnak('o', niz2);
        samoglasnici[4] = prebrojZnak('u', niz1) + prebrojZnak('u', niz2);
        System.out.print("broj pojavljivanja samoglasnika -a -e -i -o -u je ");
        for(int i: samoglasnici){
            System.out.print(" - "+i);
        }
        }
//26. zadatak 
    public static void daLiJeSamoglasnik(String text){
        String[] novi = new String[text.length()];
        char[] znaci = text.toCharArray();
        for(int i = 0; i<znaci.length; i++){  //obratiti paznju kod ovoga da ne napisem znaci.length-1
            if(znaci[i]=='a'||znaci[i]=='e'||znaci[i]=='i'||znaci[i]=='o'||znaci[i]=='u'){
                novi[i]="samoglasnik";
            }else{
                novi[i]="suglasnik";
            }
        }
        for(String s: novi){
            System.out.println(" - "+s);
        }
        
    }
// 27. zadatak
    public static void rastaviNaReci(String text){
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(text," ");
        while(st.hasMoreElements()){
            list.add((String)st.nextElement());
        }
        System.out.println("Tekst rastavljen na reci >> ");
        for(String s :list){
            System.out.println(" : "+s);
        }
    }
    
// 27. zadatak II nacin
    public static void rastaviNaReciII(String text){
       String[] nizReci = text.split(" ");
        System.out.println("Tekst rastavljen na reci je >> ");
       for(String s : nizReci){
           System.out.println(" - "+s);
       }
    }
    
// 28. zadatak
    public static void korekcijaPlate(int[] staz, double[] plata){
        double[] korPlata = new double[staz.length];
        for(int i = 0; i < staz.length; i++){
            korPlata[i] = plata[i]*(1+(double)staz[i]/100);
        }
        System.out.println("Korigovane plate u zavisnosti od godina staza su >> ");
        for(double d : korPlata){
            System.out.println(" - "+d);
        }
    }
// 29. zadatak
    public static String datumPlacanja(String datum){
        LocalDate dat = LocalDate.parse(datum);
        LocalDate polaGodine = LocalDate.of(dat.getYear(), Month.JUNE, 30); 
        if(dat.isBefore(polaGodine)){
            return "PRVA POLOVINA ";
        }
        else{
            return "DRUGA POLOVINA";
        }
    }// uraditi sa formatiranjem datuma
// 30. zadatak
    public static void ucitajNizZnakova() throws NegativeArraySizeException{
        Scanner in = new Scanner(System.in);
        System.out.println("Koliko znakova unosite");
        int br = in.nextInt();
        if(br<0){
            throw new NegativeArraySizeException ("Broj znakova ne moze biti manji od nule");
        }
        String[] nizZnakova = new String[br];
        for(int i = 0; i < br; i++){
            System.out.println("unesi "+(i+1)+" znak --- ");
            nizZnakova[i] = in.next();
        }
    }// uraditi da se vraca na pocetak sve dok se ne ukuca dobar broj
    
// 31. zadatak komplikovanije nego sto sam mislila
    public static boolean daLiSuIdenticni(String[] niz1, String[] niz2){
        if(niz1==null||niz2==null||niz1.length==0||niz2.length==0){
            System.out.println("niz nije definisan ili je prazan"); return false;
        }
        if(niz1.length!=niz2.length){
            System.out.println("Nizovi nisu iste duzine"); return false;
        }
        boolean jesu = true;
        if(niz1.length>0 && niz2.length>0 && (niz1.length==niz2.length)){
        for(int i = 0; i<niz1.length; i++){
            if(!niz1[i].equalsIgnoreCase(niz2[i])){
                 return false;
           }
        }   // ako bi se obradila greska ne bi doslo dalje do izvrsavanja programa
        }
        return jesu;
        } 
    
// 32. zadatak
    public static boolean daLiSuInverzni(String[] niz1, String[] niz2){
        if(niz1==null||niz2==null||niz1.length==0||niz2.length==0){
            System.out.println("niz nije definisan ili je prazan"); 
            return false;
        }
        if(niz1.length!=niz2.length){
            System.out.println("Nizovi nisu iste duzine"); 
            return false;
        }
        boolean inverzni = true;
        if(niz1.length>0 && niz2.length>0 && (niz1.length==niz2.length)){
            for(int i = 0; i < niz1.length; i++){
                if(niz1[i]!=niz2[niz2.length-i-1]){
                    return false;
                }
            }
        }
        return true;
     }
// 33. zadatak
    public static boolean daLiSeSadrze(String[] niz1, String[] niz2){
      
            
        return true;
    } 
    }

    
        
     
    
    
       

