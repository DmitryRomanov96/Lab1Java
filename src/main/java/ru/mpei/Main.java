package ru.mpei;

import ru.mpei.MyCalculator.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter operation: ");
        Scanner scanner = new Scanner(System.in);
        String userExpression = scanner.nextLine();
        OperationType userOperation = Inspector.inspectOperationType(userExpression);
        if (userOperation == OperationType.noOperation) {
            System.out.println("Unknown operation type or no operation");
            System.exit(0);
        }
        NumberType userNumberType = Inspector.inspectNumbers(userExpression, userOperation);
        if (userNumberType == NumberType.incorrectType) {
            System.out.println("Wrong number format type");
            System.exit(0);
        }
        if (userNumberType == NumberType.arabic) {
            ArabicCalcs arab = new ArabicCalcs(userOperation, userExpression);
        }
        if (userNumberType == NumberType.roman){
            RomanCalcs rom = new RomanCalcs(userOperation, userExpression);
        }
    }
}