/****************************** 
Title: Cipher Generator

Description: This code takes a plain text as input and generates different kinds of cipher (as per user chioce).

Author: Moumita Kamal
********************************/

import java.util.*;
//import static java.lang.System.*;

public class CipherGenerator {
    public static void main(String[]args) {
        Scanner keyboard = new Scanner (System.in);
        String p_text;							//string to store the plain text

		while(true) {
		    System.out.println("Enter number to select:\n1. Atbash Cipher\n2. Caeser Cipher\n3. Vigenere Cipher");
		    int cipher = keyboard.nextInt();	//user choice input

		    System.out.println("Enter plain text: ");
		    InputStream.skip()
		    p_text = keyboard.nextLine();		//plain text input

		    if(cipher == 1) {					//Atbash cipher
		        System.out.println("printing... " + atbashCipher(p_text));
		    }else if(cipher == 2) {				//Caeser cipher
		        System.out.println("Enter key(integer value): ");
		        int key = keyboard.nextInt();	//user preferred key (integer value)
		        System.out.println("printing... " + caeserCipher(p_text, key));
		    }else if(cipher == 3) {				//Vignere cipher
		    	/********************
		    	//Yet to be completed
		    	*********************/	
		    	
		        /*System.out.println("Enter period(integer value): ");
		        int period = keyboard.nextInt();
		        System.out.println("Enter key(string value): ");
		        String key = keyboard.next();
		        System.out.println("printing... " + vigenereCipher(p_text, period, key));*/
		    }else
		        System.err.println("Invalid entry! please try again.");
		}
	}

	public static String atbashCipher (String p_text) {
        p_text = p_text.toUpperCase();			//converting all characters to uppercase
        char [] c = p_text.toCharArray();		//converting string to character array
        int [] i = new int [c.length];
        
        for(int x=0; x< c.length; x++) {		//swapping characters 
            i[x] = c[x];
            if (i[x] >= 65){
                i[x] = 155-i[x];
            }
            c[x] = (char)i[x];
        }
        
        p_text = new String (c);				//storing the new ciphertext in p_text
        
        return p_text;
    }
    
    public static String caeserCipher (String p_text, int key) {
        p_text = p_text.toUpperCase();			//converting all characters to uppercase
        char [] c = p_text.toCharArray();		//converting string to character array
        int [] i = new int [c.length];
        
        for(int x=0; x< c.length; x++) {		//rotating characters by the key
            i[x] = c[x];
            if (i[x] >= 65){
                i[x] = (((i[x]-65)+key)%26)+65;
            }
            c[x] = (char)i[x];
        }
        
        p_text = new String (c);				//storing the new ciphertext in p_text
        
        return p_text;
    }
    
    public static String vigenereCipher (String p_text, int period, String key) {
        /**************************
        //this method is unfinished
		***************************/

        p_text = p_text.toUpperCase();
        char [] c = p_text.toCharArray();
        int [] i = new int [c.length];
        int [] keys = new int [period];
        
        /*for(int x=0; x< c.length; x++) {
            i[x] = c[x];
            if (i[x] >= 65){
                i[x] = (((i[x]-65)+key)%26)+65;
            }
            c[x] = (char)i[x];
        }*/
        
        p_text = new String (c);
        
        return p_text;
    }
}
}
    
