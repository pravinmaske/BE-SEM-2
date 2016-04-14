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
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class Protector 
{

   // private static final String ALGORITHM = "AES";
    private static final int ITERATIONS = 2;
    private static final byte[] keyValue =  new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

    public static String encrypt(String value, String salt) throws Exception
    {
        Key key = generateKey();//1
        Cipher c = Cipher.getInstance("AES");//2  
        c.init(Cipher.ENCRYPT_MODE, key);//2
  
        for (int i = 0; i < ITERATIONS; i++) 
        {
           String valueToEnc = salt + value;
            byte[] encValue = c.doFinal(valueToEnc.getBytes());//3. Encrypts or decrypts data in a single-part operation, or finishes a multiple-part operation
            value = new BASE64Encoder().encode(encValue);//4. This class implements an encoder for encoding byte data using the Base64 encoding scheme.
        }
        return value;
    }

   /* public static String decrypt(String value, String salt) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
  
        String dValue = null;
        String valueToDecrypt = value;
        for (int i = 0; i < ITERATIONS; i++) {
            byte[] decryptValue = new BASE64Decoder().decodeBuffer(valueToDecrypt);
            byte[] decValue = c.doFinal(decordedValue);
            dValue = new String(decValue).substring(salt.length());
            valueToDecrypt = dValue;
        }
        return dValue;
    }
*/
    private static Key generateKey() throws Exception
    {
        Key key = new SecretKeySpec(keyValue, "AES");
        // SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        // key = keyFactory.generateSecret(new DESKeySpec(keyValue));
        return key;
    }
}
