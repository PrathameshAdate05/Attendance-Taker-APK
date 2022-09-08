package com.prathamesh.attendancetaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;

public class AttendanceActivity extends AppCompatActivity {

    String subName, className, div, date, time, email, studentCount;

    TextView showSubjectName, showClassName, showDiv, showPresentCount, showAbsentCount;

    GridLayout gridLayout;

    boolean[] studentState;

    short presentCount, absentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        gridLayout = findViewById(R.id.GLAttendance);
        gridLayout.setColumnCount(4);
        gridLayout.setColumnOrderPreserved(false);

        showSubjectName = findViewById(R.id.TVShowSubjectName);
        showClassName = findViewById(R.id.TVShowClassName);
        showDiv = findViewById(R.id.TVShowDiv);
        showPresentCount = findViewById(R.id.TVShowPresentCount);
        showAbsentCount = findViewById(R.id.TVShowAbsentCount);

        Intent receiveIntent = getIntent();
        subName = receiveIntent.getStringExtra(Constants.SubjectName);
        className = receiveIntent.getStringExtra(Constants.ClassName);
        div = receiveIntent.getStringExtra(Constants.Div);
        date = receiveIntent.getStringExtra(Constants.Date);
        time = receiveIntent.getStringExtra(Constants.Time);
        email = receiveIntent.getStringExtra(Constants.Email);
        studentCount = receiveIntent.getStringExtra(Constants.StudentCount);

        studentState = new boolean[Integer.parseInt(studentCount)];
        Arrays.fill(studentState,false);

        setData(subName, className, div);

        presentCount = 0;
        absentCount = Short.parseShort(studentCount);
        setPresentAbsentCount(presentCount,absentCount);


        Toast.makeText(this, subName+className+div+date+time+email+studentCount, Toast.LENGTH_LONG).show();





        for (short i = 0; i < Integer.parseInt(studentCount); i++) {
            Button button = new Button(this);
            button.setText(String.valueOf(i+1));
            button.setBackgroundResource(R.drawable.absent_button);
            button.setId(View.generateViewId());
            button.setTextSize(30f);
            button.setOnClickListener(getOnclick(i));
            gridLayout.addView(button);

        }

    }

    private View.OnClickListener getOnclick(final short i) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(AttendanceActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();

                if (studentState[i]){
                    studentState[i] = false;
                    presentCount--;
                    absentCount++;
                    view.setBackgroundResource(R.drawable.absent_button);
                }else{
                    studentState[i] = true;
                    presentCount++;
                    absentCount--;
                    view.setBackgroundResource(R.drawable.present_button);
                }
                setPresentAbsentCount(presentCount,absentCount);
            }
        };
    }

    private void setPresentAbsentCount(short present, short absent){
        showPresentCount.setText(present+"/"+studentCount);
        showAbsentCount.setText(absent+"/"+studentCount);
    }

    private void setData(String subject, String className, String div){
        showSubjectName.setText(subject);
        showClassName.setText(className);
        showDiv.setText(div);
    }


}