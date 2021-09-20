package com.kid.mathforkid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class mul extends AppCompatActivity {
    int size = 1;
    int hs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mul);
        generate();
    }

    public void gotoMain(View view){
        Intent x = new Intent(this, MainActivity.class);
        startActivity(x);
    }

    public void generate(){
        Random random = new Random();
        TextView q1 = findViewById(R.id.ques1);
        TextView q2 = findViewById(R.id.ques2);
        TextView ans = findViewById(R.id.ans);
        TextView tick = findViewById(R.id.tick);
        int a = Integer.parseInt(String.format("%03d",random.nextInt(1000)));
        int b = Integer.parseInt(getDigit());
        if(a>=b){
            q1.setText(a+"");
            q2.setText(b+"");
            ans.setText("");
        }
        else {
            generate();
        }

    }
    public String getDigit(){
        Random random = new Random();
        String str = "";
        switch (size){
            case 1:
                str = String.format("%01d",random.nextInt(10));
                break;
            case 2:
                str = String.format("%02d",random.nextInt(100));
                break;
            case 3:
                str = String.format("%03d",random.nextInt(1000));
                break;
        }

        return str;
    }

    public void check(View view){
        if ((view.getTag().toString()).equals("check")){
            TextView a = findViewById(R.id.ques1);
            TextView b = findViewById(R.id.ques2);
            TextView c = findViewById(R.id.ans);
            TextView textView = findViewById(view.getId());
            int sum = Integer.parseInt(a.getText().toString())* Integer.parseInt(b.getText().toString());

            if(!(c.getText().toString()).equals("")) {
                if (sum == Integer.parseInt(c.getText().toString())) {
                    textView.setBackgroundColor(Color.GREEN);
                    textView.setText("RIGHT");
                    generate();
                    hs += 2;
                    TextView vvv = findViewById(R.id.highscore);
                    vvv.setText("HS : "+hs);
                } else {
                    textView.setBackgroundColor(Color.RED);
                    textView.setText("WRONG");
                    hs -= 1;
                    TextView vvv = findViewById(R.id.highscore);
                    vvv.setText("HS : "+hs);
                }
                c.setText("");
            }
        }
    }


    public void changeSize(View view){
        if ((view.getTag().toString()).equals("size")){
            Button btn2 = findViewById(R.id.btn2);
            Button btn3 = findViewById(R.id.btn3);
            Button btn4 = findViewById(R.id.btn4);
            btn2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            btn3.setBackgroundColor(Color.parseColor("#FFFFFF"));
            btn4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Button btn = findViewById(view.getId());
            btn.setBackgroundColor(Color.parseColor("#FFEB3B"));
            size = Integer.parseInt(btn.getText().toString());
            generate();
        }
    }


    public void write(View view){
        if((view.getTag().toString()).equals("num")){
            TextView ans = findViewById(R.id.ans);
            String str = ans.getText().toString();
            TextView text = findViewById(view.getId());
            str = text.getText().toString()+str;
            ans.setText(str);
            TextView v = findViewById(R.id.tick);
            v.setBackgroundColor(Color.parseColor("#00BCD4"));
            v.setText("CHECK");
        }
        if((view.getTag().toString()).equals("erase")){
            TextView textView = findViewById(R.id.ans);
            String str = textView.getText().toString();
            if(!str.equals("")){
                textView.setText("");
            }
        }
    }
}