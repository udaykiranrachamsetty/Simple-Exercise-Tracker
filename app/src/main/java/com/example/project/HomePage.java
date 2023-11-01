package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class HomePage extends AppCompatActivity {

    private LinearLayout exerciseLL, stepCounterLL;
    private LottieAnimationView exerciseLAV, counterLAV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView name = (TextView) findViewById(R.id.idTVSubHeading);
        String user = getIntent().getStringExtra("username");
        name.setText("welcome "+user);
        exerciseLL = findViewById(R.id.idLLExercise);
        stepCounterLL = findViewById(R.id.idLLStepCounter);
        exerciseLAV = findViewById(R.id.idLAVExercise);
        counterLAV = findViewById(R.id.idLAVStepCounter);
        exerciseLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this,ExerciseActivity.class);
                startActivity(i);
            }
        });
        stepCounterLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,StepCounterActivity.class);
                startActivity(i);
            }
        });


    }
}