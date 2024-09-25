package ru.mpei.MyCalculator;

public class ArabicCalcs extends Calculations{

    String[] numbers;
    int numberOne, numberTwo;

    public ArabicCalcs(OperationType operation, String expression) {
        String[] numbers = expression.split(operation.getOperation());
        this.numberOne = Integer.parseInt(numbers[0]);
        this.numberTwo = Integer.parseInt(numbers[1]);
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
        System.out.println(numberOne + numberTwo);
    }

    @Override
    public void subtraction() {
        System.out.println(numberOne - numberTwo);
    }

    @Override
    public void multiplication() {
        System.out.println(numberOne * numberTwo);
    }

    @Override
    public void division() {
        System.out.println(numberOne / numberTwo);
    }
}
