package com.example.studentregistrationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textViewDisplay = findViewById(R.id.textViewDisplay);

        String selectedSubject = getIntent().getStringExtra("selectedSubject");
        String selectedGender = getIntent().getStringExtra("selectedGender");
        boolean isQualificationChecked = getIntent().getBooleanExtra("isQualificationChecked", false);

        String displayText = "Subject: " + selectedSubject + "\n" +
                "Gender: " + selectedGender + "\n" +
                "Qualification: " + (isQualificationChecked ? "Yes" : "No");

        textViewDisplay.setText(displayText);
    }
}
