package ROT13;

import java.util.HashMap;
import java.util.Map;

public class ROT13 {

    //Define the Hash Maps For The Character Values
    static Map<Character,Integer> dictForUppercase = new HashMap<>();
    static Map<Integer,Character> dictForUppercaseShiftedValues = new HashMap<>();
    static Map<Character,Integer> dictForLowercase = new HashMap<>();
    static Map<Integer,Character> dictForLowercaseShiftedValues = new HashMap<>();
    private final static int valueShift= 13;

    static void createDicts(){

        for(int a = 1 ; a < 27 ; a++){

            dictForUppercase.put((char)(64+a),a);
            dictForLowercase.put((char)(96+a),a);
        }

        dictForUppercaseShiftedValues.put(0,'Z');
        dictForLowercaseShiftedValues.put(0,'z');

        for(int b = 1 ; b < 26 ; b ++){

            dictForUppercaseShiftedValues.put(b,(char)(64+b));
            dictForLowercaseShiftedValues.put(b,(char)(96+b));
        }

        System.out.println(dictForUppercase);
        System.out.println(dictForUppercaseShiftedValues);

        System.out.println(dictForLowercase);
        System.out.println(dictForLowercaseShiftedValues);

    }

    public static String encrypt(String userInput){

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < userInput.length(); i++){

            char characterAt = userInput.charAt(i);

            if(!Character.isLetter(characterAt)){

                stringBuilder.append(characterAt);
            }
            else if(Character.isUpperCase(characterAt)){

                int value = ((dictForUppercase.get(characterAt) + valueShift)) % 26;
                stringBuilder.append(dictForUppercaseShiftedValues.get(value));

            }else if(Character.isLowerCase(characterAt)){

                int value = ((dictForLowercase.get(characterAt) + valueShift)) % 26;
                stringBuilder.append(dictForLowercaseShiftedValues.get(value));

            }
        }

        return stringBuilder.toString();
    }

    public static String deCrypt(String encryptedValue){

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < encryptedValue.length(); i++){

            char characterAt = encryptedValue.charAt(i);

            if(!Character.isLetter(characterAt)){

                stringBuilder.append(characterAt);
            }
            else if(Character.isUpperCase(characterAt)){

                int getValue = dictForUppercase.get(characterAt);

                int value;
                if(getValue < valueShift){

                    value = (valueShift + getValue) % 26;
                }else {
                    value = (dictForUppercase.get(characterAt) - valueShift) % 26;
                }
                stringBuilder.append(dictForUppercaseShiftedValues.get(value));

            }else if(Character.isLowerCase(characterAt)){

                int getValue = dictForLowercase.get(characterAt);

                int value;
                if(getValue < valueShift){

                    value = (valueShift + getValue) % 26;
                }else {
                    value = (dictForLowercase.get(characterAt) - valueShift) % 26;
                }
                stringBuilder.append(dictForLowercaseShiftedValues.get(value));

            }
        }

        return stringBuilder.toString();
    }

}
