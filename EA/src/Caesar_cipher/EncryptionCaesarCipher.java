package Caesar_cipher;

public class EncryptionCaesarCipher {

    private static final int shiftValue = 3;

    // Uppercase alphabet array
    private static final char[] alphabetUpper = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    // Lowercase alphabet array
    private static final char[] alphabetLower = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };


    public static String encrypt(String userInput) {

        StringBuilder getEncrypted = new StringBuilder();

        int j;
        for (j = 0 ; j < userInput.length() ; j ++){

            char characterAt = userInput.charAt(j);

            for (int i = 0 ; i < 26; i++){

                if(alphabetUpper[i] == characterAt){

                    char ch = (char)((((int)characterAt + shiftValue) - 65) % 26 + 65);
                    getEncrypted.append(ch);

                }else if(alphabetLower[i] == characterAt){

                    char ch = (char)((((int)characterAt + shiftValue) - 97) % 26 +97);
                    getEncrypted.append(ch);
                }

            }
        }
        return getEncrypted.toString();
    }

    public static String deCrypt(String encryptedValue){


        StringBuilder getEncrypted = new StringBuilder();

        int j;
        for (j = 0 ; j < encryptedValue.length() ; j ++){

            char characterAt = encryptedValue.charAt(j);

            for (int i = 0 ; i < 26; i++){

                if(alphabetUpper[i] == characterAt){

                    char ch = (char)((((int)characterAt - shiftValue) - 65) % 26 + 65);
                    getEncrypted.append(ch);

                }else if(alphabetLower[i] == characterAt){

                    char ch = (char)((((int)characterAt - shiftValue) - 97) % 26 +97);
                    getEncrypted.append(ch);
                }

            }
        }
        return getEncrypted.toString();
    }
}
