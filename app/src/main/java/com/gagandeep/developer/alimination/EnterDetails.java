package com.gagandeep.developer.alimination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterDetails extends AppCompatActivity {

    //cn - contact person
    EditText name, cpOneName, cpOnePhone, cpTwoName, cpTwoPhone;
    Button getData;
    String nameString="", cpOneNameString="", cpOnePhoneString="", cpTwoNameString="", cpTwoPhoneString="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);

        name = (EditText) findViewById(R.id.name);
        cpOneName = (EditText) findViewById(R.id.cponename);
        cpOnePhone = (EditText) findViewById(R.id.cponephone);
        cpTwoName = (EditText) findViewById(R.id.cptwoname);
        cpTwoPhone = (EditText) findViewById(R.id.cptwophone);

        getData = (Button) findViewById(R.id.button);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameString = name.getText().toString();
                cpOneNameString = cpOneName.getText().toString();
                cpOnePhoneString = cpOnePhone.getText().toString();
                cpTwoNameString = cpTwoName.getText().toString();
                cpTwoPhoneString = cpTwoPhone.getText().toString();
            }
        });
    }
}
