/***********************************************************
 *Information Assurance and Cryptography
 *Title: Caeser Cipher Decryptor 

 *Description: This code takes in a caesar cipher text from user as an input and 
  calculates the best possible keys to decrypt the cipher and prints out the plaintexts 
  obtained from each keys. Chances are one of the plain text would be the right one.
 
 *Author: Moumita Kamal
 ***********************************************************/

import java.util.*;
import static java.lang.System.*;

public class CaeserCipherDecryptor {
    public static void main (String[]args) {
        Scanner keyboard = new Scanner (System.in);
        
        double [] freq_chart = {0.080, 0.015, 0.030, 0.040, 0.130, 0.020, 0.015, 0.060,
            0.065, 0.005, 0.005, 0.035, 0.030, 0.070, 0.080, 0.020, 0.002, 0.065, 0.060,
            0.090, 0.030, 0.010, 0.015, 0.005, 0.020, 0.002};    //the frequency chart
        double [] correlation = new double [26], num_occurences = new double [26];
        out.println("Enter cipher text:");
        String cipher_text = keyboard.nextLine().toUpperCase();  //takes string ciphertext as input and converts to uppercase
        char [] char_array = cipher_text.toCharArray();          //converts the string to char array
        int [] int_values = new int [char_array.length];   
        int [] best_keys = new int [5];
        
        for(int x=0; x< int_values.length; x++) {
            int_values[x] = char_array[x];                       //converts the char values to corresponding ASCII
            if (int_values[x] >= 65){
                int_values[x] = (int_values[x]-65);              //converts ASCII alphabets into 0-25 range
                num_occurences[int_values[x]]++;                 //calculates the number of occurance for each alphabet
            }
        }
        
        for (int i=0; i<num_occurences.length; i++) {
            if(num_occurences[i] != 0){
                num_occurences[i] = num_occurences[i]/(double)char_array.length;//computes char frequency in cipher text-f(c)
            } 
        }
        
        for(int key = 0; key < 26; key++){
            for(int val = 0; val< num_occurences.length; val++){
                correlation[key] = correlation[key] + (num_occurences[val]*(freq_chart[((26+val-key)%26)]));//computes correlation frequency for each alphabet
            }
            correlation[key] = (Math.round((correlation[key])*10000.0))/10000.0 ;
        }
        
        out.println("best keys: ");
        for (int j = 0; j < best_keys.length; j++) {              //finds the best five keys
            double max = correlation[0];
            int index = 0;
            for (int i = 1; i < correlation.length; i++) {
                if (max < correlation[i]) {
                    max = correlation[i];
                    index = i;
                }
            }
            best_keys[j] = index;
            correlation[index] = Integer.MIN_VALUE;
            out.print(best_keys[j]+" ");
        }out.println("\n");
        
        for(int k = 0; k < best_keys.length; k++){
            decipher(int_values, best_keys[k]);                   //calls decipher method using the best 5 keys
        }
    }
    
    public static void decipher (int[] values, int keySize) {      
        String p_text; 
        int [] i = new int [values.length];
        char [] c = new char[values.length];
        
        for(int x=0; x< i.length; x++) {
            i[x]=values[x];
            if (i[x] <= 25){
                i[x] = ((26+(i[x])-keySize)%26)+65;              //deciphers with key size using formula and converts to ASCII value
            }
            c[x] = (char)i[x];                                   //converts ASCII to char
        }
        p_text = new String (c);                                 //converts char to string
        out.println("Plain text for key = " + keySize + " is: " + p_text);//prints plain text
    }
}