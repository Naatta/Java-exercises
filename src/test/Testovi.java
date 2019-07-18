/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Korisnik
 */
public class Testovi {
    static int count;
    int i =0;
    
    public void changeCount(){
        while(i<5){
            i++;
            count++;
        }
    }
    public static void main(String[] args) {
        int i;
        for(i = 0; i < 10;){
            System.out.println(i);
            i++;
        }
        StringBuilder ejg = new StringBuilder(10+2+"SUN"+4+5);//prvi deo sabere, posle dopise kao String
        System.out.println(ejg);
        
        double probaj = Math.hypot(3, 4);//koren zbira kvadrata tj. Pitagora
        System.out.println(probaj);
        
        String date = LocalDate.parse("2014-08-04").format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date);
        
        Testovi check1 = new Testovi();
        Testovi check2 = new Testovi();
        check1.changeCount();
        check2.changeCount();
        System.out.println(check1.count +" "+ check2.count);
        
//        String[] str = new String[2]; //izbacuje NullPointerException
//        int idx = 0;
//        for(String s:str){
//            str[idx].concat(" element"+idx);
//            idx++;
//        }
//        for(idx = 0; idx>str.length; idx++){
//            System.out.println(str[idx]);
//        }
        
        
        
        
        
    }
    
}
