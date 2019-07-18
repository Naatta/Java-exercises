/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezbanjajava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Korisnik
 */
public class PretvaranjeDatuma {
    
    public static void main(String[] args) {
        
        LocalDateTime now  = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY. - HH:mm ");
        System.out.println("LocalDateTime je: "+now.format(formatter));
        
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("E dd/MM/yy H:mm:ss a");
        System.out.println("LocalDate je: " + dateFormat.format(date));
        
        ocenaBroj();
        }
    
    public static void ocenaBroj(){ // metoda za vezbu ali ne radi dobro
        String[] niz = new String[11];
        for(int j = 0; j<11; j++){ // mozda ovo moze i drugacije da sa resi 
            niz[j]="";
        }
        boolean jos = true;
        while(jos){
            Scanner in = new Scanner(System.in);
            System.out.println("Unesi neku ocenu od 0 do 10");
            String ocena = in.next();
            try{
                int intOcena = Integer.parseInt(ocena);
                if(intOcena>10 | intOcena<0){
                    System.out.println("Pogresan unos broj mora biti izmedju 0 i 10");
                }else{
                    for(int i = 0; i<niz.length; i++){
                        if(i == intOcena){
                            niz[i] = niz[i]+"X";
                        }
                    }
                }    
            }catch(NumberFormatException e){
                jos = false;
            }    
        }
        System.out.println("Prikaz ocena je ----- ");
        for(int j = 0; j<niz.length; j++){
            System.out.println(j+" - "+ niz[j]);
        }
    }    
        
    }

