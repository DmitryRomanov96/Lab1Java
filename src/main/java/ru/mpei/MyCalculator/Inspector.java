package ru.mpei.MyCalculator;

public class Inspector {

    public static OperationType inspectOperationType(String expression) {
        if (expression.contains("+")){
            return OperationType.addition;
        }
        if (expression.contains("-")){
            return OperationType.subtraction;
        }
        if (expression.contains("*")){
            return OperationType.multiplication;
        }
        if (expression.contains("/")){
            return OperationType.division;
        }
    return OperationType.noOperation;
    }

    public static NumberType inspectNumbers(String expression, OperationType operation) {
        String[] numbers;
        if (operation == OperationType.addition) {
            return checkType(expression, "\\+");
        }
        if (operation == OperationType.subtraction) {
            return checkType(expression, "-");
        }
        if (operation == OperationType.multiplication){
            return checkType(expression, "\\*");
        }
        return checkType(expression, "/");
    }

        public static NumberType checkType (String expression, String operation){
            String[] numbers = expression.split(operation);
            if (NumberIdentifier.isArabicNumber(numbers[0]) &&
                    NumberIdentifier.isArabicNumber(numbers[1])) {
                return NumberType.arabic;
            } else if (NumberIdentifier.isRomanNumber(numbers[0]) &&
                    NumberIdentifier.isRomanNumber(numbers[1])) {
                return NumberType.roman;
            }
            return NumberType.incorrectType;
        }
    }
