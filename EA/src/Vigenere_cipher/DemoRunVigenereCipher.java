package Vigenere_cipher;

import util.UserInput;

import java.util.Scanner;

public class DemoRunVigenereCipher {

    public static void main(String[] args) {

        String key = "LEMON";

        VigenereCipher.setData();

        System.out.println();

        UserInput userInput = new UserInput();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your String Input : ");
        userInput.setUserInput(scanner.nextLine());

        String updatedKey = VigenereCipher.generateKey(userInput.getUserInput(),key);

        String encryptedUserInput = VigenereCipher.encrypt(userInput.getUserInput(),updatedKey);

        System.out.println("User Entered Input is : " +userInput.getUserInput());
        System.out.println("Encrypted Key is : "+encryptedUserInput);

        String decryptedResult = VigenereCipher.deCrypt(encryptedUserInput,updatedKey);
        System.out.println("Decrypted Result : "+decryptedResult);

        if(userInput.getUserInput().equalsIgnoreCase(decryptedResult)){
            System.out.println("Your Implementation is Correct....");
        }else {
            System.out.println("Your Implementation is Wrong....");
        }
    }
}
