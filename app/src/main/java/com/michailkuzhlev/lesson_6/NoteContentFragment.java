package com.michailkuzhlev.lesson_6;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class NoteContentFragment extends Fragment {


    public static final String ARG_NOTES = "notes";
    private Notes notes;


    public static NoteContentFragment newInstance(Notes notes) {
        NoteContentFragment fragment = new NoteContentFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTES, notes);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_content, container, false);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        notes = getArguments().getParcelable(ARG_NOTES);
        ImageView imageView = view.findViewById(R.id.imageView);
        TypedArray images = getResources().obtainTypedArray(R.array.notes_content);
        imageView.setImageResource(images.getResourceId(notes.getIndex(),R.drawable.note1));
    }
}