package com.prathamesh.attendancetaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;


public class Home extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    TextInputEditText ET_SubjectName, ET_ClassName, ET_Div, ET_DatePicker, ET_TimePicker, ET_Email, ET_StudentCount;
    TextInputLayout TIL_SubjectName, TIL_ClassName, TIL_Div, TIL_DatePicker, TILTimePicker, TIL_Email, TIL_StudentCount;
    boolean isEmailValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ET_SubjectName = findViewById(R.id.ET_SubjectName);
        TIL_SubjectName = findViewById(R.id.TIL_SubjectName);

        ET_ClassName = findViewById(R.id.ET_ClassName);
        TIL_ClassName = findViewById(R.id.TIL_ClassName);

        ET_Div = findViewById(R.id.ET_Div);
        TIL_Div = findViewById(R.id.TIL_Div);

        ET_DatePicker = findViewById(R.id.ET_DatePicker);
        TIL_DatePicker = findViewById(R.id.TIL_DatePicker);

        ET_TimePicker = findViewById(R.id.ET_TimePicker);
        TILTimePicker = findViewById(R.id.TIL_TimePicker);

        ET_Email = findViewById(R.id.ET_Email);
        TIL_Email = findViewById(R.id.TIL_Email);

        ET_StudentCount = findViewById(R.id.ET_Count);
        TIL_StudentCount = findViewById(R.id.TIL_Count);


        ET_SubjectName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 0){
                    TIL_SubjectName.setError("Please Enter Subject Name");
                }else{
                    TIL_SubjectName.setError(null);
                    TIL_SubjectName.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    TIL_SubjectName.setEndIconDrawable(R.drawable.ic_baseline_check);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        ET_ClassName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0){
                    TIL_ClassName.setError("Enter Class Name");
                }else{
                    TIL_ClassName.setError(null);
                    TIL_ClassName.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    TIL_ClassName.setEndIconDrawable(R.drawable.ic_baseline_check);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ET_Div.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0){
                    TIL_Div.setError("Enter Div");
                }else{
                    TIL_Div.setError(null);
                    TIL_Div.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    TIL_Div.setEndIconDrawable(R.drawable.ic_baseline_check);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ET_DatePicker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0){
                    TIL_DatePicker.setError(null);
                    TIL_DatePicker.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    TIL_DatePicker.setEndIconDrawable(R.drawable.ic_baseline_check);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ET_TimePicker.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0){
                    TILTimePicker.setError(null);
                    TILTimePicker.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    TILTimePicker.setEndIconDrawable(R.drawable.ic_baseline_check);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ET_Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (Patterns.EMAIL_ADDRESS.matcher(Objects.requireNonNull(ET_Email.getText())).matches()){
                    TIL_Email.setError(null);
                    TIL_Email.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    TIL_Email.setEndIconDrawable(R.drawable.ic_baseline_check);
                    isEmailValid = true;
                }else {
                    TIL_Email.setError("Invalid Email");
                    isEmailValid = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ET_StudentCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0){
                    TIL_StudentCount.setError(null);
                    TIL_StudentCount.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
                    TIL_StudentCount.setEndIconDrawable(R.drawable.ic_baseline_check);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void proceedToAttendance(View view) {
        if(TextUtils.isEmpty(ET_SubjectName.getText())){
            TIL_SubjectName.setError("Enter Subject Name");
        }else if (TextUtils.isEmpty(ET_ClassName.getText())){
            TIL_ClassName.setError("Enter Class Name");
        }else if (TextUtils.isEmpty(ET_Div.getText())){
            TIL_Div.setError("Enter Div");
        }else if(TextUtils.isEmpty(ET_DatePicker.getText())){
            TIL_DatePicker.setError("Select Date");
        }else if (TextUtils.isEmpty(ET_TimePicker.getText())){
            TILTimePicker.setError("Select Time");
        }else if (TextUtils.isEmpty(ET_Email.getText()) || !isEmailValid){
            TIL_Email.setError("Enter Email");
        }else if (TextUtils.isEmpty(ET_StudentCount.getText())){
            TIL_StudentCount.setError("Enter Count");
        } else {
            Toast.makeText(this, makeFileName(ET_SubjectName.getText().toString(),ET_ClassName.getText().toString(),ET_Div.getText().toString(),ET_DatePicker.getText().toString(),ET_TimePicker.getText().toString()), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,i);
        calendar.set(Calendar.MONTH,i1);
        calendar.set(Calendar.DAY_OF_MONTH,i2);

        String selectedDate = new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
        ET_DatePicker.setText(selectedDate);
    }

    public void showDatePickerDialog(View view) {
        com.prathamesh.attendancetaker.DatePicker datePicker = new com.prathamesh.attendancetaker.DatePicker();
        datePicker.show(getSupportFragmentManager(),"Date Picker");
    }

    public void showTimePickerDialog(View view) {
        com.prathamesh.attendancetaker.TimePicker timePicker = new com.prathamesh.attendancetaker.TimePicker();
        timePicker.show(getSupportFragmentManager(),"Time Picker");
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,i);
        calendar.set(Calendar.MINUTE,i1);
        String selectedTime  = new SimpleDateFormat("HH:mm aaa ").format(calendar.getTime());
        ET_TimePicker.setText(selectedTime);
    }

    public String makeFileName(String subName, String className, String div, String date, String time){

        StringBuilder filename = new StringBuilder();
        filename.append(subName).append("-").append(className).append("-").append(div).append("-").append(date).append("-").append(time);
        return String.valueOf(filename);

    }
}