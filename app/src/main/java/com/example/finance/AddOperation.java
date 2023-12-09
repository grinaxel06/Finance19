package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;

import database.data.Operation;

public class AddOperation extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    ImageView to_main_menu;
    Dialog calendar;

    ImageButton callCalendar;


    EditText Op_sum;
    EditText Op_name;
    EditText Op_com;

    Button confirmBtt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_operation);
        Intent intent = new Intent(AddOperation.this, MainActivity.class);
        boolean RoG =intent.getBooleanExtra("RoG",true);
        to_main_menu = findViewById(R.id.to_main_menu);
        to_main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        callCalendar = findViewById(R.id.calendar);
        calendar = new Dialog(AddOperation.this);
        callCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"datepicker");

            }
        });





        Op_sum = findViewById(R.id.editMoney);
        Op_name = findViewById(R.id.editDscr);
        Op_com = findViewById(R.id.editCom);

        confirmBtt = findViewById(R.id.confirm_button);





        confirmBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sum = Op_sum.getText().toString();
                String name = Op_name.getText().toString();
                String com = Op_com.getText().toString();

                Operation op1 = new Operation(name, sum, "OOO", "OOO", com,RoG);

                AppDataBase.getInstance(AddOperation.this).getOperationDao().addOperation(op1);
                Intent intent = new Intent(AddOperation.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


    private void ShowCalendar() {
        calendar.setContentView(R.layout.calendar);
        CalendarView calendarView = findViewById(R.id.cal_view);
        Objects.requireNonNull(calendar.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        calendar.show();
    }
    public void onDateSet(DatePicker view, int year , int month, int dayOfMonth){
        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(c.getTime());
        Toast.makeText(this,currentDateString,Toast.LENGTH_SHORT).show();
    }




}