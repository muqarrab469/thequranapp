package com.example.thequran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>();
    ListView surahList;
    //TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QDH dataQuran=new QDH();
        String[] surahNames = dataQuran.urduSurahNames;
        surahList = findViewById(R.id.surah_List);
        for(int i=0;i<surahNames.length;i++)
        {
            arrayList.add(surahNames[i]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        surahList.setAdapter(arrayAdapter);

        surahList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SurahText.class);
                intent.putExtra ("surahNum", position);
                intent.putExtra("surahName",surahNames[position]);
                startActivity(intent);
            }
        });

    }
}