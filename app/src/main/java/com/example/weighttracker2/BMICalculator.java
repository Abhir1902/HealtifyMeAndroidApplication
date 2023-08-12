package com.example.weighttracker2;

import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);
        // Get the references to the widgets
        final EditText e1 = (EditText) findViewById(R.id.weightText);
        final EditText e2 = (EditText) findViewById(R.id.heightText);
        final TextView tv4 = (TextView) findViewById(R.id.displayBmi);
        final TextView tv5 = (TextView) findViewById(R.id.displaytargetWeight);


        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be emp
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }

//Get the user values from the widget reference
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;

//Calculate BMI value
                float bmiValue = calculateBMI(weight, height);

//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);

                tv4.setText(String.valueOf(bmiValue + "\n" + bmiInterpretation));
                tv5.setText(" Ideal Weight : "+String.valueOf(calculateTarget(weight,height)));
                //tv4.setText(String.valueOf(weight+ "\n" + height));

            }
        });

    }

    //Calculate BMI
    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }
    private float calculateTarget (float weight,float height)
    {
        float bmi=calculateBMI(weight,height);
        float target= (float) ((2.2*bmi)+(3.5*bmi)*(height-1.3));
        return target;
    }


    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {


            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
