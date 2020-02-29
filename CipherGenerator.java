/****************************** 
  Title: Cipher Generator
  Description: This code takes a plain text as input and generates different kinds of cipher (as per user chioce).
  Author: Moumita Kamal
  ********************************/

import java.util.*;

public class CipherGenerator {
    public static void main(String[]args) {
        Scanner keyboard = new Scanner (System.in);
        String p_text;                                  //string to store the plain text
        int cipher = 0;
        while(cipher != 4) {
            System.out.println("\nEnter number to select:\n1. Atbash Cipher\n2. Caeser Cipher\n3. Vigenere Cipher\n4. Exit program");
            cipher = keyboard.nextInt();             //user choice input
            
            if (cipher != 1 && cipher != 2 && cipher != 3 && cipher != 4) {// checking to see if user opted out before asking for plain text input
                System.err.println("Invalid entry! Please try again.");
            }else if (cipher != 4){
                System.out.println("Enter text to encrypt: ");
                keyboard.nextLine();
                p_text = keyboard.nextLine().toUpperCase(); //plain text input converted to upper case
                
                if(cipher == 1) {                       //Atbash cipher
                    System.out.println("The Atbash cipher is a type of monoalphabetic substitution cipher \nformed by taking the alphabet and mapping it to its reverse, so \nthat the first letter becomes the last letter, the second letter \nbecomes the second to last letter (i.e. A <-> Z, B <-> Y etc.), \nand so on.\n");
                    System.out.println("The atbash cipher for " + p_text + " is: " + atbashCipher(p_text));
                }else if(cipher == 2) {                 //Caeser cipher
                    System.out.println("The Caesar cipher is a substitution cipher that takes in a number \nand the plain text as input. The cipher alphabet is the plain alphabet \nrotated left or right by the number of positions (as per user input). \nFor example, with a left shift of 3, D would be replaced by A, E would become B, etc.\n");
                    System.out.println("Enter key(integer value): ");
                    int key = keyboard.nextInt();       //user preferred key (integer value)
                    System.out.println("The caeser cipher for " + p_text + " is: " + caeserCipher(p_text, key));
                }else if(cipher == 3) {                 //Vigenere cipher
                    System.out.println("The Vigenère cipher takes in the plain text and a string vale (key). \nIt is a combination of  several Caesar ciphers in sequence with \ndifferent shift values.\n");
                    System.out.println("Enter key(string value): ");
                    String key = keyboard.nextLine().toUpperCase();//user preferred string key to upper case
                    System.out.println("The vigenere cipher for " + p_text + " is: " + vigenereCipher(p_text, key));
                }
            }else {
                System.out.println("Have a nice day! :D");
            }
        }
    }
    
    public static String atbashCipher (String p_text) {
        char [] c = p_text.toCharArray();           //converting string to character array
        int [] i = new int [c.length];
        
        for(int x=0; x< c.length; x++) {           //swapping characters 
            i[x] = c[x];
            if (i[x] >= 65){
                i[x] = 155-i[x];
            }
            c[x] = (char)i[x];
        }
        
        p_text = new String (c);                //storing the new ciphertext in p_text
        
        return p_text;
    }
    
    public static String caeserCipher (String p_text, int key) {
        char [] c = p_text.toCharArray();          //converting string to character array
        int [] i = new int [c.length];
        
        for(int x=0; x< c.length; x++) {          //rotating characters by the key
            i[x] = c[x];
            if (i[x] >= 65){
                i[x] = (((i[x]-65)+key)%26)+65;
            }
            c[x] = (char)i[x];
        }
        
        p_text = new String (c);            //storing the new ciphertext in p_text
        
        return p_text;
    }
    
    public static String vigenereCipher (String p_text, String key) {
        /*************************************************************
          Learn more about encrypting and decrypting Vigenere cipher at:
          https://www.dcode.fr/vigenere-cipher
          **************************************************************/
        
        char [] plain = p_text.toCharArray();           //converting plain text string to character array
        int [] plainInt = new int [plain.length];       //array to store integer value of the plain text characters
        
        char [] keyArr = key.toCharArray();             //converting key string to character array
        int [] keyInt = new int [keyArr.length];        //array to store integer value of the key characters
        for(int i = 0,j=0; i< plain.length; i++) {
            plainInt[i] = plain[i];
            if(plainInt[i] >=65) {                      //ignoring the spaces and other special characters
                if(j < keyArr.length) {
                    keyInt[j] = keyArr[j];              //storiing the characters in an int array to get their ascii values
                    keyInt[j] = keyInt[j]-65;           //subtracting 65 from each to get 0-26 numeric values for each characters
                    j++;
                }
                plainInt[i] = plainInt[i]-65;
            }
        }
        
        int count = 0;
        for (int i = 0; i < plain.length; i++) {
            if(plainInt[i] < 26) {                     //ignoring the spaces and other special characters
                plainInt[i] = plainInt[i] + keyInt[count % keyInt.length]; //adding values of each plain text characters to their correspoding key character values
                plainInt[i] = (plainInt[i] % 26)+65;   //gets the rank of the ciphered letter and converts it to its ASCII value
                plain[i] = (char)plainInt[i];          //ciphered letter saved to the char array
                count++;
            }
        }
        
        p_text = new String (plain);                  //storing the new ciphertext in p_text
        
        return p_text;
    }
}
