package com.josemillanes.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText display;
    private Button cButton;
    private Button ceButton;
    private Button delButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button zeroButton;
    private Button dotButton;
    private Button divButton;
    private Button multiButton;
    private Button sumButton;
    private Button restButton;
    private Button resultButton;
    private String displayText = "";
    private double firstNumber=0;
    private double secondNumber=0;
    private char operand;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (EditText) findViewById(R.id.display);
        oneButton = (Button) findViewById(R.id.one_button);
        oneButton.setOnClickListener(this);
        twoButton = (Button) findViewById(R.id.two_button);
        twoButton.setOnClickListener(this);
        threeButton = (Button) findViewById(R.id.three_button);
        threeButton.setOnClickListener(this);
        fourButton = (Button) findViewById(R.id.four_button);
        fourButton.setOnClickListener(this);
        fiveButton = (Button) findViewById(R.id.five_button);
        fiveButton.setOnClickListener(this);
        sixButton = (Button) findViewById(R.id.six_button);
        sixButton.setOnClickListener(this);
        sevenButton = (Button) findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(this);
        eightButton = (Button) findViewById(R.id.eight_button);
        eightButton.setOnClickListener(this);
        nineButton = (Button) findViewById(R.id.nine_button);
        nineButton.setOnClickListener(this);
        zeroButton = (Button) findViewById(R.id.zero_button);
        zeroButton.setOnClickListener(this);
        dotButton = (Button) findViewById(R.id.dot_button);
        dotButton.setOnClickListener(this);
        cButton = (Button) findViewById(R.id.c_button);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("0");
            }
        });
        ceButton = (Button) findViewById(R.id.ce_button);
        ceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber = 0;
                secondNumber = 0;
                operand = '=';
                display.setText("0");
            }
        });
        delButton = (Button) findViewById(R.id.del_button);
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayText = display.getText().toString();
                if(!displayText.equals("0")){
                   displayText = displayText.substring(0,displayText.length()-1);
                    if (displayText.equals("")) {
                        display.setText("0");
                    } else {
                        display.setText(displayText);
                    }
                }
            }
        });
        divButton = (Button) findViewById(R.id.div_button);
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayText = display.getText().toString();
                firstNumber = Double.parseDouble(displayText);
                operand = '/';
                displayText = "";
            }
        });
        multiButton = (Button) findViewById(R.id.multi_button);
        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayText = display.getText().toString();
                firstNumber = Double.parseDouble(displayText);
                operand = '*';
                displayText = "";
            }
        });
        sumButton = (Button) findViewById(R.id.sum_button);
        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayText = display.getText().toString();
                firstNumber = Double.parseDouble(displayText);
                operand = '+';
                displayText = "";
            }
        });
        restButton = (Button) findViewById(R.id.rest_button);
        restButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayText = display.getText().toString();
                firstNumber = Double.parseDouble(displayText);
                operand = '-';
                displayText = "";
            }
        });
        resultButton = (Button) findViewById(R.id.result_button);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!displayText.equals("")){
                    displayText = display.getText().toString();
                    secondNumber = Double.parseDouble(displayText);

                }
                switch (operand){
                    case '/':
                        if(secondNumber==0){
                            displayText="Error";
                        } else {
                            firstNumber = firstNumber / secondNumber;
                        }
                        break;
                    case '+':
                        firstNumber = firstNumber + secondNumber;
                        break;
                    case '-':
                        firstNumber = firstNumber - secondNumber;
                        break;
                    case '*':
                        firstNumber = firstNumber * secondNumber;
                        break;
                    default:
                        return;

                }
                displayText = "" + firstNumber;
                String decimal = displayText.substring(displayText.length()-2);
                if(displayText.length()>=11){
                    displayText = displayText.substring(0,11);

                }
                if(decimal.equals(".0")) {
                    displayText = displayText.substring(0,displayText.length()-2);
                }
                display.setText(displayText);
                displayText = "";
            }
        });

    }

        @Override
        public void onClick(View view) {

            Button tempButton = (Button) view;
            if(displayText.equals("") ){
                display.setText("0");
            }
            displayText = display.getText().toString();
            if(displayText.equals("0")){
                if (view.getId() == R.id.dot_button) {
                    display.setText("0" + tempButton.getText());
                } else {
                    display.setText(tempButton.getText());
                }
            } else if((!displayText.contains(".") || view.getId() != R.id.dot_button) && displayText.length() < 11){
                display.setText(displayText+ tempButton.getText());
            }

        }

}