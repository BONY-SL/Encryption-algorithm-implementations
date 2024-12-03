package Caesar_cipher;

import util.UserInput;

import java.util.Scanner;

public class DemoRunCaesar_cipher {
    public static void main(String[] args) {

        UserInput userInput = new UserInput();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your String Input : ");
        userInput.setUserInput(scanner.nextLine());

        String encryptedUserInput = CaesarCipher.encrypt(userInput.getUserInput());

        System.out.println("User Entered Input is : " +userInput.getUserInput());
        System.out.println("Encrypted Key is : "+encryptedUserInput);

        String decryptedResult = CaesarCipher.deCrypt(encryptedUserInput);
        System.out.println("Decrypted Result : "+decryptedResult);

        if(userInput.getUserInput().equalsIgnoreCase(decryptedResult)){
            System.out.println("Your Implementation is Correct....");
        }else {
            System.out.println("Your Implementation is Wrong....");
        }
    }
}
