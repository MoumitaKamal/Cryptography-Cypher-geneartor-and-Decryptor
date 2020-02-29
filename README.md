# Cryptography-Fun-Stuff
This repository contains a few codes to generate, encrypt, and decrypt cyphers and plaintexts. Each code is independent of one another and does not need any additional file or data to be used. There are currently three cipher generator and decryptor codes in the repository. 

**CipherGenerator**

  This code takes a plain text as input and generates Atbash cipher, Caesar ciphere, or Vigenere cipher (as per user chioce). 

  ***Atbash cipher:***  A type of monoalphabetic substitution cipher formed by taking the alphabet and mapping it to its reverse, so that the first letter becomes the last letter, the second letter becomes the second to last letter (i.e. A <-> Z, B <-> Y etc.), and so on. [Source: Wikipedia]

  ***Caesar cipher:*** a.k.a Caesar's cipher, the shift cipher, Caesar's code or Caesar shift, is one of the simplest and most popular substitution cipher. In this encryption technique,  the cipher alphabet is the plain alphabet rotated left or right by some number of positions. For example, with a left shift of 3, D would be replaced by A, E would become B, and so on. The method is named after Julius Caesar, who used it in his private correspondence. [Source: Wikipedia]

  ***Vigenère cipher:*** A polyalphabetic substitution method used to encrypt text by using a series of interwoven Caesar ciphers, based on the letters of a keyword. The Vigenère cipher has several Caesar ciphers in sequence with different shift values. [Source: Wikipedia] To learn more about how to encrypt and decrypt a vigenere cypher go to [this link](https://www.dcode.fr/vigenere-cipher)

**CaesarCipherDecryptor**

  This code takes in a caesar cipher text from user as an input and calculates the best possible keys to decrypt the cipher and prints out the plaintexts obtained from each keys. Chances are one of the plain text would be the right one.

**VigenereCipherDecryptor**

  This program helps in Vigenere Cipher decoding by calculating the index of coincidence (IC). It takes a Vigenere cipher text as an input from user and calculates the IC for that cipher text. More information on how to decrypt a vigenere cipher can be found at the [Practical Cryptography](http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-vigenere-cipher/) website.
