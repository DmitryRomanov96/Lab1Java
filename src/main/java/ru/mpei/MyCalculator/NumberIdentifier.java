package ru.mpei.MyCalculator;

import java.util.Arrays;

public class NumberIdentifier {

    public static boolean isArabicNumber(String number){
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    public static boolean isRomanNumber(String number){
        char[] checkString = {'I', 'V', 'X'};
        boolean checkFlag = false;
        for (int i = 0; i < number.length(); i++) {
            for (char ch: checkString) {
                if (ch == number.charAt(i)){
                    checkFlag = true;
                    break;
                }
                else {checkFlag = false;}
            }
        }
        return checkFlag;
    }

}
