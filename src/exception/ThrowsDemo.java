/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Korisnik
 */
public class ThrowsDemo {
    static void throwMethod()throws IllegalAccessException{//bez ovog reda compilation error
        System.out.println("Unutar metode");
        throw new IllegalAccessException("demo");
    }
    
    public static void main(String[] args) {
        try{
            throwMethod();
        }
        catch(IllegalAccessException e){
            System.out.println("Uhvacen "+e);
        }
    }
}
