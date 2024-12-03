package Caesar_cipher;

public class CaesarCipher {

    private static final int shiftValue = 3;

    public static String encrypt(String userInput) {

        StringBuilder getEncrypted = new StringBuilder();

        int j;

        for (j = 0 ; j < userInput.length() ; j ++){

            char characterAt = userInput.charAt(j);

            if (Character.isUpperCase(characterAt)) {

                char ch = (char) (((characterAt + shiftValue - 65) % 26) + 65);
                getEncrypted.append(ch);

            } else if (Character.isLowerCase(characterAt)) {

                char ch = (char) (((characterAt + shiftValue - 97) % 26) + 97);
                getEncrypted.append(ch);

            } else {

                getEncrypted.append(characterAt);
            }
        }
        return getEncrypted.toString();
    }

    public static String deCrypt(String encryptedValue){


        StringBuilder getEncrypted = new StringBuilder();

        int j;

        for (j = 0 ; j < encryptedValue.length() ; j ++){

            char characterAt = encryptedValue.charAt(j);

            if (Character.isUpperCase(characterAt)) {

                char ch = (char) (((characterAt - shiftValue - 65) % 26) + 65);
                getEncrypted.append(ch);

            } else if (Character.isLowerCase(characterAt)) {

                char ch = (char) (((characterAt - shiftValue - 97) % 26) + 97);
                getEncrypted.append(ch);

            } else {

                getEncrypted.append(characterAt);
            }
        }
        return getEncrypted.toString();
    }
}
