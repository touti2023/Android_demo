package com.example.helloworld.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.helloworld.R;

public class MainActivity extends AppCompatActivity {
    private Button btnOne, btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_test2);
//        btnOne = (Button) findViewById(R.id.btnOne);
//        btnTwo = (Button) findViewById(R.id.btnTwo);
//        btnTwo.setOnClickListener(v -> {
//            if (btnTwo.getText().toString().equals("按钮不可用")){
//                btnOne.setEnabled(false);
//                btnTwo.setText("按钮可用");
//            } else {
//                btnOne.setEnabled(true);
//                btnTwo.setText("按钮不可用");
//            }
//        });
    }
}