package Vigenere_cipher;

import java.util.HashMap;

public class VigenereCipher {

    private static final HashMap<Character, Integer> upperCase = new HashMap<>();
    private static final HashMap<Integer, Character> upperCase2 = new HashMap<>();
    private static final HashMap<Character, Integer> lowerCase = new HashMap<>();
    private static final HashMap<Integer, Character> lowerCase2 = new HashMap<>();

    public static void setData() {

        for (char c = 'A'; c <= 'Z'; c++) {
            upperCase.put(c, c - 'A');
            upperCase2.put(c - 'A',c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            lowerCase.put(c, c - 'a');
            lowerCase2.put(c - 'a',c);
        }

        System.out.println(upperCase);
        System.out.println(lowerCase);
        System.out.println(upperCase2);
        System.out.println(lowerCase2);
    }

    public static String generateKey(String userInput, String key) {

        //set the key into text length

        // userInput: "DANIDU THARUKA"
        // key: "LEMON"

        // new KEY = LEMONLEMONLEM
        StringBuilder newKey = new StringBuilder();

        int i = 0;

        while (i < userInput.length()) {

            if (Character.isLetter(userInput.charAt(i))) {
                newKey.append(key.charAt(i % key.length()));
            } else if (!Character.isLetter(userInput.charAt(i))) {
                newKey.append(userInput.charAt(i));
            }
            i++;
        }

        return newKey.toString();
    }

    public static String encrypt(String userInput, String key) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < userInput.length(); i++) {

            if (Character.isLetter(userInput.charAt(i)) && Character.isLetter(key.charAt(i))) {

                if (Character.isUpperCase(userInput.charAt(i))) {

                    int charValue = upperCase.get(userInput.charAt(i));
                    int keyValue = upperCase.get(key.charAt(i));
                    int encryptedValue = (charValue + keyValue) % 26;
                    char c = upperCase2.get(encryptedValue);
                    stringBuilder.append(c);

                } else if (Character.isLowerCase(userInput.charAt(i))) {

                    int charValue = lowerCase.get(userInput.charAt(i));
                    int keyValue = upperCase.get(key.charAt(i));
                    int encryptedValue = (charValue + keyValue) % 26;
                    char c = lowerCase2.get(encryptedValue);
                    stringBuilder.append(c);
                }

            } else if (!Character.isLetter(userInput.charAt(i)) && !Character.isLetter(key.charAt(i))) {

                stringBuilder.append(userInput.charAt(i));

            }
        }
        return stringBuilder.toString();
    }

    public static String deCrypt(String encryptedUserInput, String key) {

        System.out.println(encryptedUserInput);
        System.out.println(key);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < encryptedUserInput.length(); i++) {

            if (Character.isLetter(encryptedUserInput.charAt(i)) && Character.isLetter(key.charAt(i))) {

                if (Character.isUpperCase(encryptedUserInput.charAt(i))) {

                    int charValue = upperCase.get(encryptedUserInput.charAt(i));
                    int keyValue = upperCase.get(key.charAt(i));


                    int encryptedValue = (charValue - keyValue + 26)%26;

                    char c = upperCase2.get(encryptedValue);
                    stringBuilder.append(c);

                } else if (Character.isLowerCase(encryptedUserInput.charAt(i))) {

                    int charValue = lowerCase.get(encryptedUserInput.charAt(i));
                    int keyValue = upperCase.get(key.charAt(i));

                    int encryptedValue = (charValue - keyValue + 26)%26;

                    char c = lowerCase2.get(encryptedValue);
                    stringBuilder.append(c);
                }

            } else if (!Character.isLetter(encryptedUserInput.charAt(i)) && !Character.isLetter(key.charAt(i))) {

                stringBuilder.append(encryptedUserInput.charAt(i));

            }
        }
        return stringBuilder.toString();
    }
}