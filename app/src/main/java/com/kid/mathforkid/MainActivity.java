package com.kid.mathforkid;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void gotoAdd(View view){
        Intent x = new Intent(this, MainActivity2.class);
        startActivity(x);
    }
    public void gotoSub(View view){
        Intent x = new Intent(this, sub.class);
        startActivity(x);
    }
    public void gotoMul(View view){
        Intent x = new Intent(this, mul.class);
        startActivity(x);
    }
    public void gotoDiv(View view){
        Intent x = new Intent(this, divide.class);
        startActivity(x);
    }
}