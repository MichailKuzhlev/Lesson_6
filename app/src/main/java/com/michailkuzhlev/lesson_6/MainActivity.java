package com.michailkuzhlev.lesson_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
             NoteFragment noteFragment = new NoteFragment();
             getSupportFragmentManager().beginTransaction().replace(R.id.notes,noteFragment).commit();
             if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                 NoteContentFragment noteContentFragment = new NoteContentFragment();
                 getSupportFragmentManager().beginTransaction().replace(R.id.note_content,noteContentFragment).commit();
             }
        }
    }
}