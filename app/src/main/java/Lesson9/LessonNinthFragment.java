package Lesson9;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.michailkuzhlev.lesson_6.MainActivity;
import com.michailkuzhlev.lesson_6.NoteFragment;
import com.michailkuzhlev.lesson_6.Notes;
import com.michailkuzhlev.lesson_6.R;

public class LessonNinthFragment extends Fragment {

    public static LessonNinthFragment newInstance() {
        LessonNinthFragment fragment = new LessonNinthFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lesson_ninth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initView(view);
    }

    void initView(View view) {
        view.findViewById(R.id.btnToast).setOnClickListener(view1 -> showToast());
        view.findViewById(R.id.btnSnackBar).setOnClickListener(view1 -> showSnackBar(view));
        view.findViewById(R.id.btnSnackBarWithAction).setOnClickListener(view1 -> SnackBarWithAction(view));
        view.findViewById(R.id.btnAlertDialog).setOnClickListener(view1 -> AlertDialog());
        view.findViewById(R.id.btnAlertDialogCustom).setOnClickListener(view1 -> AlertDialogCustom());
        view.findViewById(R.id.btnDialogFragment).setOnClickListener(view1 -> DialogFragment());
        view.findViewById(R.id.btnDialogFragmentCustom).setOnClickListener(view1 -> DialogFragmentCustom());
        view.findViewById(R.id.btnBottomSheetDialogFragment).setOnClickListener(view1 -> BottomSheetDialogFragment());
        view.findViewById(R.id.btnPushNotification).setOnClickListener(view1 -> PushNotification());


    }

    void showToast() {
        Toast.makeText(requireContext(), "Toast работает", Toast.LENGTH_LONG).show();
    }

    void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }

    void showSnackBar(View view) {
        Snackbar.make(view, "SnackBar работает", Snackbar.LENGTH_LONG).show();
    }

    void SnackBarWithAction(View view) {

       {Snackbar.make(view, "SnackBarWithAction работает", Snackbar.LENGTH_LONG).setAction(
                "Попробовать еще раз", view1 -> {
                    showToast();
                }
        ).show();}


    }

    void AlertDialog() {
        new AlertDialog.Builder(requireContext())
                .setTitle("AlertDialog")
                .setMessage("AlertDialog message")
                .setPositiveButton("Да", (dialogInterface, i) -> {
                    showToast("Да");
                }).setNegativeButton("Нет", (dialogInterface, i) -> {
            showToast("Нет");
        }).setNeutralButton("Отмена", (dialogInterface, i) -> {
            showToast("Отмена");
        }).show();
    }

    void AlertDialogCustom() {
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
    }

    void DialogFragment() {
        new MyDialogFragment().show(getActivity().getSupportFragmentManager(), "123");

    }

    void DialogFragmentCustom() {
        new MyDialogFragmentCustom().show(getActivity().getSupportFragmentManager(), "123");
    }

    void BottomSheetDialogFragment() {
        new MyBottomSheetDialogFragment().show(getActivity().getSupportFragmentManager(), "123");
    }
    public final String CHANEL_ID = "1";
    void PushNotification() {
        NotificationManager notificationManager = (NotificationManager) requireActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANEL_ID, "Chanel1", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("Это канал для кто бы знал я не придумал");
            notificationManager.createNotificationChannel(notificationChannel);

        }
        Notification notification = new NotificationCompat.Builder(requireContext(),CHANEL_ID)
                .setContentTitle("Это заголовок пуша")
                .setContentText("Это текст пуша")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(Notification.PRIORITY_HIGH)
                .build();
        notificationManager.notify(1,notification);

    }

}
