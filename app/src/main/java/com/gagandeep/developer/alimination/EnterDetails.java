package com.gagandeep.developer.alimination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EnterDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);

        String name=getIntent().getExtras().getString("name");
        String editText11=getIntent().getExtras().getString("editText11");
        String phoneNumber=getIntent().getExtras().getString("phoneNumber");
        String editText13=getIntent().getExtras().getString("editText13");
        String editText12=getIntent().getExtras().getString("editText12");
    }
}
