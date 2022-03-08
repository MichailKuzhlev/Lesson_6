package Lesson9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        view.findViewById(R.id.btnToast).setOnClickListener(view1 -> showToast());
    }
    void showToast(){
        Toast.makeText(requireContext(),"Toast работает",Toast.LENGTH_LONG).show();
    }
}
