package com.example.estandarterizaliannaquiz4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Activity3 extends AppCompatActivity {

    TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        txtEmail = findViewById(R.id.tvEmail);
        FileInputStream fis = null;
        StringBuffer buffer = new StringBuffer();
        int letter = 0;
        try {
            File file = new File(getExternalCacheDir(),"user4.txt");
            fis = new FileInputStream(file);
            while ((letter = fis.read()) != -1) {
                buffer.append((char)letter);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        txtEmail.setText(buffer.substring(buffer.indexOf(",")));
    }

    public void Logout(View v) {
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }
}