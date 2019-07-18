/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMF;

import static java.lang.Character.isLowerCase;
import java.util.Scanner;

/**
 *
 * @author Korisnik
 */
public class Stringovi {
    public static void main(String[] args) {
        String neki = "Mica i?BOCA?";
        konvertuj(neki);
        try{
        niska("25.+-*");
        }catch (NumberFormatException e){
            System.out.println("Broj mora biti celobrojan -- ne moze - "+e.getMessage());
        }
        crtaj(3);
        dvaStringa();
        unesiString();
    }
    
    

public static void konvertuj(String tekst){
    String konvertovani = "";
    char[] slova = tekst.toCharArray();
    for(int i = 0; i<slova.length; i++){
        if(Character.isUpperCase(slova[i])){
            konvertovani  = konvertovani + Character.toLowerCase(slova[i]);
        }if(Character.isLowerCase(slova[i])){
            konvertovani  = konvertovani + Character.toUpperCase(slova[i]);
        }if(!Character.isLetter(slova[i])){
            konvertovani = konvertovani + slova[i];
        }
    }
    System.out.println("Konvertovani staring za tekst -- "+ tekst +", je -- "+ konvertovani);
}

public static void niska(String tekst){
    int broj = Integer.parseInt(tekst);
    int kvadrat = (int)Math.pow(broj, 2);
    System.out.println("Parsirani string je --- "+broj);
    System.out.println("Kvadrat tog broja je --- "+kvadrat);
}

public static void crtaj(int n){
    if(n <= 1){
        System.out.println("Greska");
    }
    for(int i = 0; i < n; i++){
        System.out.println("");
        for(int j = 0; j < n; j++){
            if(i==0 || j==0 || i==n-1 || j==n-1){
                System.out.print("+");
            }else{
                System.out.print(" ");
            }
        }
    }
}

public static void dvaStringa(){
    Scanner in = new Scanner(System.in);
    System.out.println("Ucitaj prvi string");
    String prvi = in.nextLine();
    System.out.println("Ucitaj drugi string");
    String drugi = in.nextLine();
    if(prvi.length()>drugi.length()){
        if(prvi.contains(drugi)){
            System.out.println(prvi);
            System.out.println(drugi);
            System.out.println("Sadrze se > "+prvi.indexOf(drugi));
        }
    }else if(drugi.length()> prvi.length()){
        if(drugi.contains(prvi)){
            System.out.println(prvi);
            System.out.println(drugi);
            System.out.println("Sadrze se > "+drugi.indexOf(prvi));
        }
     }else if(prvi.equals(drugi)){
            System.out.println(prvi);
            System.out.println(drugi);
            System.out.println("> Jednaki su");
    }else{
        System.out.println(prvi);
        System.out.println(drugi);
        System.out.println("> Ne sadrzi se");
    }
    }
      
    public static void unesiString(){
        String pocetni = "";
        Scanner in = new Scanner(System.in);
        while(!pocetni.contains("EXIT")){
            System.out.println("Unesi rec --");
            String unet = in.nextLine();
            if(unet.equals("EXIT")){
                break;
            }
            pocetni = pocetni +" "+unet;
        }
        konvertuj(pocetni);
    }
}