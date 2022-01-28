package com.example.keyur_panchal_orange_calculator;

public class CalculatorModel {

    double firstNumber = 0.0;
    double secondNumber = 0.0;
    double result = 0.0;

    boolean firstNumberSet = false;
    boolean secondNumberSet = false;
    boolean operatorSet = false;

    String operator = "";

    public void setFirstNumber(double num) {
        this.firstNumber = num;
        firstNumberSet = true;
    }

    public void setSecondNumber(double num) {
        this.secondNumber = num;
        secondNumberSet = true;
    }

    public double getResult() {
        computeResult();
        return result;
    }

    public void computeResult() {
        if (firstNumberSet && secondNumberSet && operatorSet) {
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                case "^":
                    result = (int)firstNumber ^ (int)secondNumber;
                    break;
                case "%":
                    result = firstNumber % secondNumber;
                    break;
            }
        } else {
            //do nothing
        }

    }

    public void setOperator(String op) {
        this.operator = op;
        operatorSet = true;
    }

    public void clear() {
        firstNumberSet = false;
        firstNumber = 0.0;
        secondNumberSet = false;
        secondNumber = 0.0;
        operatorSet = false;
        operator = "";
        result = 0.0;
    }
}
