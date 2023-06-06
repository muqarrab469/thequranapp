package com.example.thequran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;

public class SurahText extends AppCompatActivity {

    TextView surah, ayats;
    EditText ayatNum;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_text);
        surah = findViewById(R.id.surah_name);
        ayats = findViewById(R.id.surah_ayat);
        search = findViewById(R.id.search);
        ayatNum = findViewById(R.id.ayat);

        Intent mIntent = getIntent();
        int surahNumber = mIntent.getIntExtra("surahNum",0);
        String surahName = mIntent.getStringExtra("surahName");
        surah.setText(surahName);

        QuranArabicText text=new QuranArabicText();
        String[] surahText = text.QuranArabicText;

        QDH dataQuran=new QDH();
        int surahVerses = dataQuran.getSurahVerses(surahNumber);
        int surahStart = dataQuran.getSurahStart(surahNumber);
        int sToE= (surahStart+surahVerses);

        String surahAyats="";
        for(int j = surahStart;j<sToE;j++)
        {
        surahAyats+=surahText[j];
        }

        ayats.setText(surahAyats);

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            int aNUm = Integer.parseInt(ayatNum.getText().toString());
            ayats.setText(surahText[surahStart+aNUm]);
            }
        });

    }
}