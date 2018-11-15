package com.example.user.bmiapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final EditText height_space = findViewById(R.id.height);
        final EditText weight_space = findViewById(R.id.weight);

        final Context ctx = MainActivity.this;
        final TextView result_space = findViewById(R.id.result);

        findViewById(R.id.resBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmi=0.0;
                double height = Double.parseDouble(height_space.getText().toString());
                double weight = Double.parseDouble(weight_space.getText().toString());

                //BMI = Kg / m * m 이다. 현재 사용자에게 입력받은 키값은 cm단위이다.
                double height_meter = height/100;
                bmi = weight/ (height_meter * height_meter);
                Log.d("bmi : ",bmi+"");

                String res="";
                if(bmi>=40.0) res="고도비만";
                else if(bmi>=35.0) res="중등도비만";
                else if(bmi>=30.0) res="경도비만";
                else if(bmi>=25.0) res="과체중";
                else if(bmi>=18.5) res="정상";
                else res="저체중";
                //한국 체질량지수 척도

                result_space.setText("결과 : "+res+"입니다.");
                Toast.makeText(ctx, "결과가 나왔습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        /*
            어제의 계산기앱은 =버튼을 누를 때까지 이전에 입력한 값을 어딘가에서 유지해야했으므로 클래스를 외부에 하나 만들어서
            그곳에 값을 계속 저장시켰다. 그러고서는 =버튼을 누르면 값을 계산해서 출력되도록 만들었다. 하지만 이 경우에는 값을 유지시킬 필요가
            없으므로 별도의 클래스는 만들지 않았다.
         */


    }
}
