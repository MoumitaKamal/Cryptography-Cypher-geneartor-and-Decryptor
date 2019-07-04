# Cryptography-Fun-Stuff
This repository contains a few codes to generate, encrypt, and decrypt cyphers and plaintexts. Each code is independent of one another and does not need any additional file or data to be used. There are currently three cipher generator and decryptor codes in the repository. 

######CipherGenerator

  This code takes a plain text as input and generates Atbash cipher, Caesar ciphere, or Vigenere cipher (as per user chioce). The vigenere cipher generation part of the code is currently incomplete.

######CaesarCipherDecryptor

  This code takes in a caesar cipher text from user as an input and calculates the best possible keys to decrypt the cipher and prints out the plaintexts obtained from each keys. Chances are one of the plain text would be the right one.

######VigenereCipherDecryptor

  This program helps in Vigenere Cipher decoding by calculating the index of coincidence (IC). It takes a Vigenere cipher text as an input from user and calculates the IC for that cipher text. More information on how to decrypt a vigenere cipher can be found at : http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-vigenere-cipher/.
