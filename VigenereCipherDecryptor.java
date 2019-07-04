/**********************************************************************
 *Information Assurance and Cryptography
 *Title: Vigenere Cipher Decryptor
 
 *Description: This program helps in Vigenere Cipher decoding by calculating the index 
  of coincidence (IC). It takes a Vigenere cipher text as an input from user and 
  calculates the IC for that cipher text. More information on how to decrypt a vigenere
  cipher can be found at : http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-vigenere-cipher/.

 *Author: Moumita Kamal
 *********************************************************************/

import java.util.*;
import static java.lang.System.*;

public class VigenereCipherDecryptor {
    public static void main(String[]args) {
        Scanner keyboard = new Scanner (System.in);
        
        out.println("Enter cipher text:");
        String cipherText = keyboard.nextLine().toUpperCase();              //takes string ciphertext as input and converts to uppercase
        double indexOfCoincidence = Math.round(ICCalculator(cipherText)*1000);//calls ICCalculator method to calculate IC and rounds off the result
        out.println("index of coincidence for the given cipher text is: " + indexOfCoincidence/1000);//prints Index of Coincidence
    }
    
    public static double ICCalculator( String cipherText) {
        String cText = cipherText;
        char [] char_array = cipherText.toCharArray();                      //converts the string to char array
        int [] int_values = new int [char_array.length];
        int [] num_occurences = new int [26];
        int f = 0, n = 0;
        double IC = 0.0;                                                    // IC = index of coincidence
        
        for(int x=0; x< int_values.length; x++) {
            int_values[x] = char_array[x];                                  //converts the char values to corresponding ASCII
            if (int_values[x] >= 65){
                n++;                                                        //alphabet count to find n (exclusive of spaces)
                int_values[x] = (int_values[x]-65);                         //converts ASCII alphabets into 0-25 range
                num_occurences[int_values[x]]++;                            //calculates the number of occurance for each alphabet
            }
        }
        
        for(int i = 0; i < num_occurences.length; i++) {
            f = f + (num_occurences[i]*(num_occurences[i]-1));              //calculates summation of f(f-1)
        }
        out.println("\nn: " + n + "\nf: " + (double)f + "\nn(n-1): " + ((double)n*((double)n-1)));
        IC = (1/((double)n*((double)n-1)))*(double)f;                       //formula to calculate IC
        
        return IC;
    }
}