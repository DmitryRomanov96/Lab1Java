package ru.mpei.MyCalculator;

public enum OperationType {
    addition("\\+"),
    subtraction("-"),
    multiplication("\\*"),
    division("/"),
    noOperation(" ");

    public final String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation(){
        return this.operation;
    }
}
