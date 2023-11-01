package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity implements ExerciseRVAdapter.ExerciseClickInterface {
    private RecyclerView exerciseRV;
    private ArrayList<ExerciseRVModel> exerciseRVModalArrayList;
    private ExerciseRVAdapter exerciseRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        exerciseRV = findViewById(R.id.idRVExercise);
        exerciseRVModalArrayList = new ArrayList<>();
        exerciseRVAdapter = new ExerciseRVAdapter(exerciseRVModalArrayList,this,this::onExerciseClick);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        exerciseRV.setLayoutManager(manager);
        exerciseRV.setAdapter(exerciseRVAdapter);
        addData();
    }

    private void addData(){
        exerciseRVModalArrayList.add(new ExerciseRVModel("Side Plank",getResources().getString(R.string.side_plank),"https://lottie.host/04c6014f-819f-4a24-87cf-4bb602d4900b/DJUepPASeM.json",20,10));
        exerciseRVModalArrayList.add(new ExerciseRVModel("Crunches",getResources().getString(R.string.abs_crunches),"https://lottie.host/ca728173-a853-4286-8494-fe987ad248b4/tn7YmTPxAq.json", 10 , 10));
        exerciseRVModalArrayList.add(new ExerciseRVModel("Lunges",getResources().getString(R.string.lunges),"https://lottie.host/74186b45-8dad-495b-b5a4-cc047574224e/eRdka4XnIt.json", 10 , 10));
        exerciseRVModalArrayList.add(new ExerciseRVModel("Push Ups",getResources().getString(R.string.push_ups),"https://lottie.host/f9b271e3-58bf-44b2-9b9f-dac25d518e3f/V9fCxfy2Ot.json", 10 , 10));
        exerciseRVModalArrayList.add(new ExerciseRVModel("High Stepping",getResources().getString(R.string.stepping),"https://lottie.host/b5ce8969-d612-4f15-9287-ee54c20c4b68/SNhYhL4ML5.json", 10 , 10));
        exerciseRVAdapter.notifyDataSetChanged();
    }
    @Override
    public void onExerciseClick(int position) {
        Intent i = new Intent(ExerciseActivity.this, ExerciseDetailActivity.class);
        i.putExtra("exerciseName", exerciseRVModalArrayList.get(position).getExerciseName());
        i.putExtra("imgurl", exerciseRVModalArrayList.get(position).getImgurl());
        i.putExtra("time", exerciseRVModalArrayList.get(position).getTime());
        i.putExtra("calories", exerciseRVModalArrayList.get(position).getCalories());
        i.putExtra("desc", exerciseRVModalArrayList.get(position).getExerciseDescription());
        startActivity(i);
    }

}