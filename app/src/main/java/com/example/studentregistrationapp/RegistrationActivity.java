package com.example.studentregistrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private Spinner spinnerSubjects;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxQualification;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        spinnerSubjects = findViewById(R.id.spinnerSubjects);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxQualification = findViewById(R.id.checkBoxQualification);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Populate the spinner with subjects
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.subjects_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubjects.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedSubject = spinnerSubjects.getSelectedItem().toString();
                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedGender = findViewById(selectedGenderId);
                boolean isQualificationChecked = checkBoxQualification.isChecked();

                Intent intent = new Intent(RegistrationActivity.this, DisplayActivity.class);
                intent.putExtra("selectedSubject", selectedSubject);
                intent.putExtra("selectedGender", selectedGender.getText().toString());
                intent.putExtra("isQualificationChecked", isQualificationChecked);
                startActivity(intent);
            }
        });
    }
}
