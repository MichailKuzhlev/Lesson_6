package com.michailkuzhlev.lesson_6;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;


public class NoteContentChildFragment extends Fragment {


    public static final String ARG_NOTES = "notes";
    private Notes notes;


    public static NoteContentChildFragment newInstance(Notes notes) {
        NoteContentChildFragment fragment = new NoteContentChildFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTES, notes);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_content_child, container, false);
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

       /* view.findViewById(R.id.btn_anchor).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), view);
                requireActivity().getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case (R.id.action_popup_clear): {
                                imageView.setImageAlpha(0);
                                return false;
                            }
                            case (R.id.action_popup_exit): {
                                ;
                                return false;
                            }
                        }
                        return false;
                    }
                });
                popupMenu.show();
                return false;
            }
        });*/
    }
}