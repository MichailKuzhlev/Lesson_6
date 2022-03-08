package Lesson9;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                    .setTitle("AlertDialog")
                    .setMessage("AlertDialog message")
                    .setPositiveButton("Да", (dialogInterface, i) -> {
                        showToast("Да");
                    }).setNegativeButton("Нет", (dialogInterface, i) -> {
                showToast("Нет");
            }).setNeutralButton("ай До Но", (dialogInterface, i) -> {
                showToast("ай До Но");
            }).show();
        }

    void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }

    }

