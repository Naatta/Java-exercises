/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Korisnik
 */
public class Z extends X{
    Y y = new Y();
    
    Z(){
        System.out.println("Z");  
    }
    
    public static void main(String[] args) {//ovaj primer jos malo pogledati
        new Z();
    }
}
