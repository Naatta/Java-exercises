/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezbanjajava;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Korisnik
 */
public class VezbanjaJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int[][] matrica = new int[10][10];
//        for(int i = 0; i<10; i++){
//            for(int j = 0; j<10; j++){
//                int slucajan = (int)(Math.random()*100);
//                matrica[i][j]= slucajan;
//            }
//        }
        

    }
    public static void stampajMatricu(int[][] matrica){
        System.out.println("Matrica >>> ");
         for(int i = 0; i<matrica.length; i++){
            for(int j = 0; j<matrica[i].length; j++){
                System.out.print(matrica[i][j]+",");
            }
             System.out.println("");
        }
    
}
    public static void stampajNiz(int[] niz){
            System.out.println("Niz je >>>");
            for(int n: niz){
                 System.out.print(n+"");
            }
                System.out.println("");
    }
            
    
    public static int[] minRed(int[][] matrica){
        int[] minimumi= new int[10];
        int index = 0;
        for(int i = 0; i<matrica.length; i++){
            int minimum = matrica[i][0];
            for(int j = 0; j<matrica[i].length; j++){
                if(matrica[i][j]< minimum){
                    minimum = matrica[i][j];
                }
            }
            minimumi[index++]=minimum;
        }
        return minimumi;
    }
    
    public static int[] maxRed(int[][] matrica){
        int[] maximumi= new int[10];
        int index = 0;
        for(int i = 0; i < matrica.length; i++){
            int maximum = matrica[i][0];
            for(int j = 0; j<matrica[i].length; j++){
                if(matrica[i][j]>maximum){
                    maximum = matrica[i][j];
                }
            }
            maximumi[index++]=maximum;
        }
        return maximumi;
    }
    
    public static int[] razlikaNizova(int[] niz1, int[] niz2){
        int[] razlika= new int[10];
        for(int i = 0; i<niz1.length; i++){
            razlika[i]=Math.abs(niz1[i]-niz2[i]);
        }
        return razlika;
    }
   
    public static Map<Integer, Integer> mapaPojavljivanja(int[][] matrica){
        Map<Integer, Integer> mapaPojavljivanja=new HashMap<>();
        int br=0;
        int m = 0;
        for(int[] i: matrica){
            for(int j:i){
                if(mapaPojavljivanja.get(j)==null){
                    br++; m=j;
                }
            }
            mapaPojavljivanja.put(m, br);
        }
        return mapaPojavljivanja;
    }
    
}
