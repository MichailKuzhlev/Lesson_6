package com.michailkuzhlev.lesson_6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class NoteFragment extends Fragment {

    public static NoteFragment newInstance() {
        NoteFragment fragment = new NoteFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }
    private void initView (View view){
        String[] notes = getResources().getStringArray(R.array.notes);
        for (int i = 0; i < notes.length; i++) {
            String noteName = notes[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(30f);
            textView.setText(noteName);
            ((LinearLayout)view).addView(textView);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Notes notes = new Notes(finalI);
                    if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                        ShowLand(notes);
                    }else {ShowPort(notes);
                    }

                }
            });
        }
    }
    private void ShowLand (Notes notes){
        NoteContentFragment noteContentFragment = NoteContentFragment.newInstance(notes);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.note_content,noteContentFragment).commit();

    }
    private void ShowPort (Notes notes){
        NoteContentFragment noteContentFragment = NoteContentFragment.newInstance(notes);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.notes,noteContentFragment).addToBackStack("").commit();
    }
}