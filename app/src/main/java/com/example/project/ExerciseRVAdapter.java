package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class ExerciseRVAdapter extends RecyclerView.Adapter<ExerciseRVAdapter.ExerciseViewHolder> {

    private ArrayList<ExerciseRVModel> exerciseRVModalArrayList;
    private Context context;
    private ExerciseClickInterface exerciseClickInterface;

    public ExerciseRVAdapter(ArrayList<ExerciseRVModel> exerciseRVModalArrayList, Context context, ExerciseClickInterface exerciseClickInterface) {
        this.exerciseRVModalArrayList = exerciseRVModalArrayList;
        this.context = context;
        this.exerciseClickInterface = exerciseClickInterface;
    }


    @NonNull
    @Override
    public ExerciseRVAdapter.ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_rv_item, parent, false);
        return new ExerciseViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseRVAdapter.ExerciseViewHolder holder, int position) {
        holder.exerciseTV.setText(exerciseRVModalArrayList.get(position).getExerciseName());
        holder.exerciseLAV.setAnimationFromUrl(exerciseRVModalArrayList.get(position).getImgurl());

        String time = String.valueOf(exerciseRVModalArrayList.get(position).getTime()) + " MIN";
        holder.timeTV.setText(time);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();
                exerciseClickInterface.onExerciseClick(clickedPosition);
            }
        });
    }


    @Override
    public int getItemCount() {
        return exerciseRVModalArrayList.size();
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder {
        private TextView exerciseTV, timeTV;
        private LottieAnimationView exerciseLAV;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            exerciseTV = itemView.findViewById(R.id.idTVExerciseName);
            timeTV = itemView.findViewById(R.id.idTVExerciseTime);
            exerciseLAV = itemView.findViewById(R.id.idExerciseLAV);
        }
    }


    public interface ExerciseClickInterface {
        void onExerciseClick(int position);
    }

}

