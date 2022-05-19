package com.prathamesh.attendancetaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Home extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextInputEditText ET_SubjectName, ET_ClassName, ET_Div, ET_DatePicker, ET_TimePicker;
    TextInputLayout TIL_SubjectName, TIL_ClassName, TIL_Div;

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
                    TIL_ClassName.setError("Please Enter Class Name");
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
                    TIL_Div.setError("Please Enter Div");
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



    }

    public void click(View view) {
        if(TextUtils.isEmpty(ET_SubjectName.getText())){
            TIL_SubjectName.setError("Please Enter Subject Name");
        }else if (TextUtils.isEmpty(ET_ClassName.getText())){
            TIL_ClassName.setError("Please Enter Class Name");
        }else if (TextUtils.isEmpty(ET_Div.getText())){
            TIL_Div.setError("Please Enter Div");
        }else {
            Toast.makeText(this, "All ok", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,i);
        calendar.set(Calendar.MONTH,i1);
        calendar.set(Calendar.DAY_OF_MONTH,i2);

//        String selectedDate = DateFormat.getDateInstance(Integer.parseInt("yyyy-MM-dd")).format(calendar.getTime());
        String selectedDate = new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
        ET_DatePicker.setText(selectedDate);
    }

    public void showTimePickerDialog(View view) {
        com.prathamesh.attendancetaker.DatePicker datePicker = new com.prathamesh.attendancetaker.DatePicker();
        datePicker.show(getSupportFragmentManager(),"Date Picker");
    }
}