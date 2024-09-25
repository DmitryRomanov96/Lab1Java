package ru.mpei.MyCalculator;

import java.util.Objects;

public class RomanCalcs extends Calculations{

    String[] numbers;
    String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "L", "M"};
    int[] arabNumbers = {0, 0};
    String numberOneRoman, numberTwoRoman;

    public RomanCalcs(OperationType operation, String expression) {
        this.numbers = expression.split(operation.getOperation());
        this.numberOneRoman = numbers[0];
        this.numberTwoRoman = numbers[1];
        this.toArabic();
        if (operation == OperationType.addition){
            addition();
        }
        else if (operation == OperationType.subtraction){
            subtraction();
        }
        else if (operation == OperationType.multiplication){
            multiplication();
        }
        else if (operation == OperationType.division) {
            division();
        }
    }

    @Override
    public void addition() {
        int result = this.arabNumbers[0] + this.arabNumbers[1];
        System.out.println(toRomanSecond(result));
    }

    @Override
    public void subtraction() {
        int result = this.arabNumbers[0] - this.arabNumbers[1];
        System.out.println(toRomanSecond(result));
    }

    @Override
    public void multiplication() {
        int result = this.arabNumbers[0] * this.arabNumbers[1];
        System.out.println(toRomanSecond(result));
    }

    @Override
    public void division() {
        int result = this.arabNumbers[0] / this.arabNumbers[1];
        System.out.println(toRomanSecond(result));
    }

    private void toArabic(){
        for (int i = 0; i < this.romanNumbers.length; i++) {
            if (Objects.equals(this.numberOneRoman, this.romanNumbers[i])){
                this.arabNumbers[0] = i + 1;
                break;
            }
        }
        for (int i = 0; i < this.romanNumbers.length; i++) {
            if (Objects.equals(this.numberTwoRoman, this.romanNumbers[i])){
                this.arabNumbers[1] = i + 1;
                break;
            }
        }
    }

    private String toRoman(int result){
        if (result <= 0){
            return "No positive result";
        }
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (result >= values[i]) {
                result -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        return roman.toString();

    }

   public static String toRomanSecond(int result){
        if (result <= 0){
            return "No positive result";
        }
        String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int nTimesLit = 0;

        StringBuilder roman = new StringBuilder();

        nTimesLit = result / 100;
        roman.append(romanLiterals[0].repeat(Math.max(0, nTimesLit)));
        result = result - nTimesLit * 100;
        nTimesLit = result / 90;
        roman.append(romanLiterals[1].repeat(Math.max(0, nTimesLit)));
        result = result - nTimesLit * 90;
        nTimesLit = result / 50;
        roman.append(romanLiterals[2].repeat(Math.max(0, nTimesLit)));
        result = result - nTimesLit * 50;
        nTimesLit = result / 40;
        roman.append(romanLiterals[3].repeat(Math.max(0, nTimesLit)));
        result = result - nTimesLit * 40;
        nTimesLit = result / 10;
        roman.append(romanLiterals[4].repeat(Math.max(0, nTimesLit)));
        result = result - nTimesLit * 10;
        nTimesLit = result / 9;
        roman.append(romanLiterals[5].repeat(Math.max(0, nTimesLit)));
        result = result - nTimesLit * 9;
        nTimesLit = result / 5;
        roman.append(romanLiterals[6].repeat(Math.max(0, nTimesLit)));
        result = result - nTimesLit * 5;
        nTimesLit = result / 4;
        roman.append(romanLiterals[7].repeat(Math.max(0, nTimesLit)));
        result = result - nTimesLit * 4;
        roman.append(romanLiterals[8].repeat(Math.max(0, result)));

        return roman.toString();

    }
}
