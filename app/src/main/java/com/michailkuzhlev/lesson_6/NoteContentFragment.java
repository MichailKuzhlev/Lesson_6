package com.michailkuzhlev.lesson_6;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;


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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.my_fragment_notes,menu);
        menu.findItem(R.id.action_about).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.action_toast):{
                Toast.makeText(requireContext()," Вы нажали на кнопку, она бесполезная:)",Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return super.onOptionsItemSelected(item);
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
        setHasOptionsMenu(true);
        assert getArguments() != null;
        notes = getArguments().getParcelable(ARG_NOTES);
        getChildFragmentManager().beginTransaction().replace(R.id.container_child,NoteContentChildFragment.newInstance(notes)).commit();


        ((Button)view.findViewById(R.id.btn_Back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
                FragmentManager fragmentManager =  requireActivity().getSupportFragmentManager();
                List<Fragment>list=fragmentManager.getFragments();
                for (Fragment one:list) {
                    if (one instanceof NoteContentFragment){
                        requireActivity().getSupportFragmentManager().beginTransaction().remove(one).commit();
                    }

                }
            }
        });
    }
}