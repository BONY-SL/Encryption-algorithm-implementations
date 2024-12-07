package Caesar_cipher;

import java.util.HashMap;

public class CaesarCipher {

    private static final HashMap<Character,Integer> upperCase = new HashMap<>();
    private static final HashMap<Integer,Character> upperCase2 = new HashMap<>();
    private static final HashMap<Character,Integer> lowerCase = new HashMap<>();
    private static final HashMap<Integer,Character> lowerCase2 = new HashMap<>();


    public static void setData(){

        for (char c = 'A';c<='Z';c++){
            upperCase.put(c,c-'A');
            upperCase2.put(c-'A',c);
        }

        for (char c = 'a';c<='z';c++){
            lowerCase.put(c,c-'a');
            lowerCase2.put(c-'a',c);
        }

        System.out.println(upperCase);
        System.out.println(lowerCase);
    }


    public static String encrypt(String plainText,int key){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {

            char charAt = plainText.charAt(i);

            if(Character.isLetter(plainText.charAt(i))){

                if(Character.isUpperCase(plainText.charAt(i))){


                    int shiftedVale = ((upperCase.get(charAt)+key) % 26);
                    char c = upperCase2.get(shiftedVale);
                    stringBuilder.append(c);



                } else if (Character.isLowerCase(plainText.charAt(i))) {

                    int shiftedVale = ((lowerCase.get(charAt)+key) % 26);
                    char c = lowerCase2.get(shiftedVale);
                    stringBuilder.append(c);

                }

            } else if (!Character.isLetter(plainText.charAt(i))) {

                stringBuilder.append(charAt);

            }

        }
        return stringBuilder.toString();
    }

    public static String deCrypt(String cipherText,int key){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {

            char charAt = cipherText.charAt(i);

            if(Character.isLetter(cipherText.charAt(i))){

                if(Character.isUpperCase(cipherText.charAt(i))){

                    int shiftedVale = ((upperCase.get(charAt)-key) % 26);
                    if(shiftedVale < 0){
                        shiftedVale = shiftedVale + 26;
                    }
                    char c = upperCase2.get(shiftedVale);
                    stringBuilder.append(c);

                } else if (Character.isLowerCase(cipherText.charAt(i))) {

                    int shiftedVale = ((lowerCase.get(charAt)-key) % 26);
                    if(shiftedVale < 0){
                        shiftedVale = shiftedVale + 26;
                    }
                    char c = lowerCase2.get(shiftedVale);
                    stringBuilder.append(c);

                }

            } else if (!Character.isLetter(cipherText.charAt(i))) {

                stringBuilder.append(charAt);

            }

        }
        return stringBuilder.toString();
    }
}
