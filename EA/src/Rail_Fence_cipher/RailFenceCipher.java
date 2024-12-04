package Rail_Fence_cipher;

import java.util.Arrays;

public class RailFenceCipher {


    public static String encrypt(String userInput, int keySize) {

        char[][] matrix = new char[keySize][userInput.length()];

        for (int i = 0; i < keySize; i++) {

            Arrays.fill(matrix[i],'\n');
        }

        boolean upAndDown = false;

        int row = 0 , cols = 0;

        for (int i = 0; i < userInput.length(); i++) {

            if((row == 0) || (row == keySize - 1)){

                upAndDown = !upAndDown;
            }

            matrix[row][cols++] = userInput.charAt(i);

            if(upAndDown){
                row++;
            }else {
                row--;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < keySize; i++) {

            for (int j = 0; j < userInput.length(); j++) {

                if(matrix[i][j] != '\n'){

                    stringBuilder.append(matrix[i][j]);
                }
            }
        }

        return stringBuilder.toString();

    }


    public static String deCrypt(String encryptedInput, int keySize) {

        char[][] matrix = new char[keySize][encryptedInput.length()];

        for (int i = 0; i < keySize; i++) {

            Arrays.fill(matrix[i],'\n');
        }

        boolean upAndDown = true;

        int row = 0 , cols = 0;

        for (int i = 0; i < encryptedInput.length(); i++) {

            if (row == 0){
                upAndDown = true;
            }
            if (row == keySize - 1){
                upAndDown = false;
            }

            matrix[row][cols++] = '*';

            if (upAndDown){
                row++;
            }
            else{
                row--;
            }

        }

        int index = 0;

        for (int i = 0; i < keySize; i++) {

            for (int j = 0; j < encryptedInput.length(); j++) {

                if(matrix[i][j] == '*' && index < encryptedInput.length()){

                    matrix[i][j] = encryptedInput.charAt(index++);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        row = 0;
        cols = 0;

        for (int j = 0; j < encryptedInput.length(); j++) {

            if(row == 0){
                upAndDown = true;
            }if(row == keySize -1) {
                upAndDown = false;
            }

            if(matrix[row][cols] != '*'){

                stringBuilder.append(matrix[row][cols++]);
            }

            if(upAndDown){

                row++;
            }else {
                row--;
            }

        }

        return stringBuilder.toString();

    }
}
