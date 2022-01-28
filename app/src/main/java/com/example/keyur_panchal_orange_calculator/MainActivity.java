package com.example.keyur_panchal_orange_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean startNewNumber = true;
    boolean acceptingDigit = true;

    CalculatorModel calculatorModel = new CalculatorModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(android.view.View view) {
        Log.i("Button","Button CLicked for Testing");

        // which button was pressed
        Button btn = (Button) view;
        String btnTxt = btn.getText().toString();

        Log.i("Button","Button Clicked: " + btnTxt);

        //what was the number being displayed at the time of button press
        TextView txtView = (TextView) findViewById(R.id.numberDisplay);
        String currentNumber = txtView.getText().toString();

         switch (btnTxt) {
             case "1":
             case "2":
             case "3":
             case "4":
             case "5":
             case "6":
             case "7":
             case "8":
             case "9":
             case "0":
             case ".":
                 //Deal with the digit or .
                 if(startNewNumber){
                     if(btn.equals(".")){
                         currentNumber = "0.";
                     } else {
                         currentNumber = btnTxt;
                     }
                     startNewNumber=false;
                 }else {
                     if(btnTxt.equals(".") && currentNumber.contains(".")){
                         //do nothing, already contains.
                     } else {
                         currentNumber = currentNumber + btnTxt;
                     }
                 }
                 break;

             case "+":
             case "-":
             case "*":
             case "/":
             case "^":
             case "%":
                 if (calculatorModel.firstNumberSet && calculatorModel.operatorSet && !startNewNumber) {
                     double secondNumber = Double.parseDouble(currentNumber);
                     calculatorModel.setSecondNumber(secondNumber);
                     String result = resultoString(calculatorModel.getResult());
                     currentNumber = result;
                 }

                 double firstNumber = Double.parseDouble(currentNumber);
                 calculatorModel.setFirstNumber(firstNumber);

                 calculatorModel.setOperator(btnTxt);
                 startNewNumber = true;
                 break;

             case "=":
                 if (calculatorModel.firstNumberSet) {
                     double secondNumber = Double.parseDouble(currentNumber);
                     calculatorModel.setSecondNumber(secondNumber);

                     String result = resultoString(calculatorModel.getResult());
                     currentNumber = result;
                     startNewNumber = true;
                 }
                 break;

             case "C":
                 calculatorModel.clear();
                 currentNumber = "0.";
                 startNewNumber = true;
                 break;

         }

         txtView.setText(currentNumber);

    }

    public  String resultoString(double num) {
        int numInt = (int) num;

        if(num == numInt){
            return Integer.toString(numInt);
        }else{
            return Double.toString(num);
        }
    }

}