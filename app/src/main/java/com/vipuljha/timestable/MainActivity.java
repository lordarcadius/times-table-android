package com.vipuljha.timestable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SeekBar seekBar;
    ArrayAdapter<Integer> arrayAdapter;
    ArrayList<Integer> table;

    public void generateTable(int number){
        for (int i=1; i<=10; i++){
            table.add(i*number);
            listView.setAdapter(arrayAdapter);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);

        table = new ArrayList<Integer>();

        arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, table);
        generateTable(1);
        seekBar.setMin(1);
        seekBar.setMax(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                table.clear();
               generateTable(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}