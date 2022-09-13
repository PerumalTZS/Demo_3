package com.example.demo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;


import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.io.File;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private Button button;
private ShapeableImageView shapeableImageView;
private TextView textView;
private TextInputLayout layout;
private DatePickerDialog.OnDateSetListener dateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
button=findViewById(R.id.button3);
shapeableImageView=(ShapeableImageView)findViewById(R.id.imageView);
textView=findViewById(R.id.tvdate);
layout=findViewById(R.id.datet);
        //Glide.with(this).load("hhtp").into(shapeableImageView);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        BottomSheetClass bottomSheetClass=new BottomSheetClass();
        bottomSheetClass.show(getSupportFragmentManager(),"bottom sheet");

    }
});
        Calendar calendar=Calendar.getInstance();
        final  int YEAR=calendar.get(Calendar.YEAR);
        final int MONTH=calendar.get(Calendar.MONTH);
        final int DAY=calendar.get(Calendar.DAY_OF_MONTH);
layout.getEditText().setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        DatePickerDialog pickerDialog=new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,dateSetListener,YEAR,MONTH,DAY);
        pickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pickerDialog.show();
    }
});
//date picker


    textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog pickerDialog=new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,dateSetListener,YEAR,MONTH,DAY);
                pickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                pickerDialog.show();
            }
        });
dateSetListener=new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        month=month+1;
        String date=year+" "+ month+" "+day;
        textView.setText(date);
         layout.getEditText().setText(date);
    }
};




   /*   textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog pickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date=year+" "+ month+" "+day;
                        textView.setText(date);

                    }
                },YEAR,MONTH,DAY);
                pickerDialog.show();
            }
        });


    */


    }
}