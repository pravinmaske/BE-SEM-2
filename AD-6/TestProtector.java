/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprotector;

/**
 *
 * @author PRAVIN
 */
public class TestProtector
{

    public static void main(String[] args) throws Exception 
    {
        String password = "Pravin";
        String salt = "this is a simple clear salt";
        String passwordEnc = Protector.encrypt(password, salt);
     //  String passwordDec = Protector.decrypt(passwordEnc, salt);
        System.out.println("Salt Text : " + salt);
        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted : " + passwordEnc);
       // System.out.println("Decrypted : " + passwordDec);
    }
}