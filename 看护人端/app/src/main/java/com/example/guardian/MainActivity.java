package com.example.guardian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private EditText ET1,ET2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        ET1 = findViewById(R.id.ET1);
        ET2 = findViewById(R.id.ET2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("leo", ET1.getText().toString() + ": " + ET2.getText().toString());
                if(true){
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Main_menu.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
}