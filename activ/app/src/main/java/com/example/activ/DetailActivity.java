package com.example.activ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WebView wb = findViewById(R.id.web);
        Intent i = getIntent();
        String resName = "n" + i.getIntExtra("title",0);
        Log.i("name",resName);
        Context c = getBaseContext();
        String text = readRawTextFile(c, getResources().getIdentifier(resName,"raw","com.example.activ"));
        wb.loadDataWithBaseURL(null,text,"text/html","en_US",null);
    }
    private String readRawTextFile(Context context, int resId){
        InputStream is = context.getResources().openRawResource(resId);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder b = new StringBuilder();
        String line;
        String n = "<br>";
        try{
            while ((line = br.readLine()) != null){
                b.append(line);
                b.append(n);
            }
        }catch (IOException e){
            return null;
        }
        return b.toString();
    }
}