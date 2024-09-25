package ru.mpei.MyCalculator;

import java.util.Arrays;
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
        if (operation == OperationType.subtraction){
            subtraction();
        }
        if (operation == OperationType.multiplication){
            multiplication();
        }
        if (operation == OperationType.division) {
            division();
        }
    }

    @Override
    public void addition() {
        int result = this.arabNumbers[0] + this.arabNumbers[1];
        System.out.println(toRoman(result));
    }

    @Override
    public void subtraction() {
        int result = this.arabNumbers[0] - this.arabNumbers[1];
        System.out.println(toRoman(result));
    }

    @Override
    public void multiplication() {
        int result = this.arabNumbers[0] * this.arabNumbers[1];
        System.out.println(toRoman(result));
    }

    @Override
    public void division() {
        int result = this.arabNumbers[0] / this.arabNumbers[1];
        System.out.println(toRoman(result));
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
    }

