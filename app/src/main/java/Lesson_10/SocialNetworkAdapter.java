package Lesson_10;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SocialNetworkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] data;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView textView = (TextView) itemView;
        }
        public void bindontentithItemView(String content){
            textView.setText(content);//
        }
    }
}
