package Lesson9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.michailkuzhlev.lesson_6.MainActivity;
import com.michailkuzhlev.lesson_6.R;

public class MyBottomSheetDialogFragment extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_custom, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }
    void initView(View view){
        view.findViewById(R.id.btnCustomView).setOnClickListener(view1 -> {
            EditText editText = view.findViewById(R.id.ediTextCustomView);
            ((MainActivity) getActivity()).onDialogResult(editText.getText().toString());
            dismiss();
        });
    }
}

