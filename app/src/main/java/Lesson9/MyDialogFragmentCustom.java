package Lesson9;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.michailkuzhlev.lesson_6.R;

public class MyDialogFragmentCustom extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            View view = getLayoutInflater().inflate(R.layout.dialog_custom, null);
            AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                    .setTitle("AlertDialog")
                    .setMessage("AlertDialog message")
                    .setView(view)
                    .show();
            view.findViewById(R.id.btnCustomView).setOnClickListener(view1 -> {
                EditText editText = view.findViewById(R.id.ediTextCustomView);
                showToast(editText.getText().toString());
                alertDialog.dismiss();
            });
        return alertDialog;
    }
    void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }
}
