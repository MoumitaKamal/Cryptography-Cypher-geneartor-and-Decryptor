/****************************** 
Title: Cipher Generator

Description: This code takes a plain text as input and generates different kinds of cipher (as per user chioce).

Author: Moumita Kamal
********************************/

import java.util.*;

public class CipherGenerator {
    public static void main(String[]args) {
        Scanner keyboard = new Scanner (System.in);
        String p_text;							//string to store the plain text
        int cipher = 0;
		while(cipher != 4) {
		    System.out.println("Enter number to select:\n1. Atbash Cipher\n2. Caeser Cipher\n3. Vigenere Cipher\n4. Exit program");
		    cipher = keyboard.nextInt();	//user choice input

            if (cipher != 1 && cipher != 2 && cipher != 3 && cipher != 4) {                  // checking to see if user opted out before asking for plain text input
                System.err.println("Invalid entry! Please try again.");
            }else if (cipher != 4){
                System.out.println("Enter plain text: ");
                keyboard.nextLine();
                p_text = keyboard.nextLine().toUpperCase(); //plain text input converted to upper case
                
                if(cipher == 1) {                   //Atbash cipher
                    System.out.println("The atbash cipher for " + p_text + " is: " + atbashCipher(p_text));
                }else if(cipher == 2) {             //Caeser cipher
                    System.out.println("Enter key(integer value): ");
                    int key = keyboard.nextInt();   //user preferred key (integer value)
                    System.out.println("The caeser cipher for " + p_text + " is: " + caeserCipher(p_text, key));
                }else if(cipher == 3) {             //Vigenere cipher
                    /********************
                    //Yet to be completed
                    *********************/  

                    /*System.out.println("Enter period(integer value): ");
                    int period = keyboard.nextInt();*/
                    System.out.println("Enter key(string value): ");
                    String key = keyboard.next();
                    System.out.println("The vigenere cipher for " + p_text + " is: " + vigenereCipher(p_text, key));
                }
            }
		}
	}

	public static String atbashCipher (String p_text) {
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
    
    public static String vigenereCipher (String p_text, String key) {
        /**************************
        //this method is unfinished
		***************************/
		char [] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        p_text = p_text.toUpperCase();
        char [] plain = p_text.toCharArray();
        int [] i = new int [plain.length];
        //int [] keys = new int [period];
        
        /*for(int x=0; x< c.length; x++) {
            i[x] = c[x];
            if (i[x] >= 65){
                i[x] = (((i[x]-65)+key)%26)+65;
            }
            c[x] = (char)i[x];
        }*/
        
        p_text = new String (plain);
        
        return p_text;
    }
}

    
