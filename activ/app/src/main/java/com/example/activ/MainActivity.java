package com.example.activ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String titles[] = {
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница",
            "Суббота",
            "Воскресенье",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.list);
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           public void onItemClick(AdapterView<?> a, View v, int position, long id){
               Intent i = new Intent();
               i.setClass(MainActivity.this, DetailActivity.class);
               i.putExtra("title",position);
               startActivity(i);
           }
        });
    }
}