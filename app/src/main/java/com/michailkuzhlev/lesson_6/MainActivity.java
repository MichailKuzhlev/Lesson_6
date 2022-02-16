package com.michailkuzhlev.lesson_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
             NoteFragment noteFragment = NoteFragment.newInstance();
             getSupportFragmentManager().beginTransaction().replace(R.id.notes,noteFragment).commit();
             if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                 Notes defaultNotes = new Notes(0);
                 NoteContentFragment noteContentFragment = NoteContentFragment.newInstance(defaultNotes);
                 getSupportFragmentManager().beginTransaction().replace(R.id.note_content,noteContentFragment).commit();
             }
        }
    }
    protected void onResume(){
        super.onResume();
        Fragment bacStackFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.notes);
        if (bacStackFragment!=null&&bacStackFragment instanceof NoteContentFragment){
            onBackPressed();
        }
    }
}