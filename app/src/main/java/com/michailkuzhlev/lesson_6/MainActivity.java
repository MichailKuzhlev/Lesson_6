package com.michailkuzhlev.lesson_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import Lesson9.LessonNinthFragment;

public class MainActivity extends AppCompatActivity {
public void onDialogResult(String message){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            /*NoteFragment noteFragment = NoteFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.notes, noteFragment).commit();*/

            LessonNinthFragment lessonNinthFragment = LessonNinthFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.notes, lessonNinthFragment).commit();

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Notes defaultNotes = new Notes(0);
                NoteContentFragment noteContentFragment = NoteContentFragment.newInstance(defaultNotes);
                getSupportFragmentManager().beginTransaction().replace(R.id.note_content, noteContentFragment).commit();
            }
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Выйти из приложения?")
                .setMessage("Вы действительно хотите выйти?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, (arg0, arg1) ->
                        MainActivity.super.onBackPressed()).create().show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_about): {
                getSupportFragmentManager().beginTransaction().replace(R.id.notes, new AboutFragment()).addToBackStack(" ").commit();
                return false;
            }
            case (R.id.action_exit): {
                finish();
                return false;
            }
        }
        return super.onOptionsItemSelected(item);
    }



    protected void onResume() {
        super.onResume();
        Fragment bacStackFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.notes);
        if (bacStackFragment != null && bacStackFragment instanceof NoteContentFragment) {
            onBackPressed();
        }
    }
}