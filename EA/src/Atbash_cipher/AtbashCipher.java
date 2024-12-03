package Atbash_cipher;

public class AtbashCipher {

    public static String encrypt(String userInput){

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0 ; i < userInput.length() ; i++){

            char characterAt = userInput.charAt(i);

            if(Character.isLetter(characterAt)){

                if(Character.isUpperCase(characterAt)){

                    char mapToChar = (char) ('Z' - (characterAt - 'A'));
                    stringBuilder.append(mapToChar);

                }else if(Character.isLowerCase(characterAt)){

                    char mapToChar = (char) ('z' - (characterAt - 'a'));
                    stringBuilder.append(mapToChar);

                }
            }else {
                stringBuilder.append(characterAt);
            }
        }
        return stringBuilder.toString();
    }

    public static String deCrypt(String encryptedUserInput) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0 ; i < encryptedUserInput.length() ; i++){

            char characterAt = encryptedUserInput.charAt(i);

            if(Character.isLetter(characterAt)){

                if(Character.isUpperCase(characterAt)){

                    char mapToChar = (char) ('Z' - (characterAt - 'A'));
                    stringBuilder.append(mapToChar);

                }else if(Character.isLowerCase(characterAt)){

                    char mapToChar = (char) ('z' - (characterAt - 'a'));
                    stringBuilder.append(mapToChar);

                }
            }else {
                stringBuilder.append(characterAt);
            }
        }
        return stringBuilder.toString();
    }
}
