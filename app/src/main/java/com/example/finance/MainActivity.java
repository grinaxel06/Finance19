package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.eazegraph.lib.charts.PieChart;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import database.data.Operation;

public class MainActivity extends AppCompatActivity {


    List<Operation> OperList;

    private final static List<Item> items = new ArrayList<>();

    MaterialButton show;
    int profit=0;
    int expenses=0;
    TextView score;
    MaterialButton show1;
    Dialog regular_or_single;
    PieChart pieChart;

    @SuppressLint({"WrongViewCast", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (OperList!=null) {
            for (Operation op : OperList) {
                items.add(new Item(op.getOp_name(), op.getOp_sum(), op.getOp_comm(), op.isRoG()));
            }
        }



        pieChart= (PieChart)findViewById(R.id.piechart);
        addDataSet(pieChart);



        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = new MyAdapter(items);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        score = findViewById(R.id.all_money);
        show = findViewById(R.id.plus_button);
        show1 = findViewById(R.id.minus_button);

        score.setText(AllMoneyScore());


        regular_or_single = new Dialog(MainActivity.this);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showCustomDialog(true);
            }
        });
        show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                showCustomDialog(false);
            }
        });





    }

    private void addDataSet(PieChart pieChart) {

    }
    private int AllMoneyScore(List<Operation> OperList){
        for (Operation op : OperList) {

        }
        return profit-expenses;
    }


    private void showCustomDialog(boolean RoG) {
        regular_or_single.setContentView(R.layout.regular_or_single);
        Objects.requireNonNull(regular_or_single.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        regular_or_single.show();
        MaterialButton btt_on_AddOperation = regular_or_single.findViewById(R.id.single_btt);

        View.OnClickListener oclBtt_on_AddOperation = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddOperation.class);
                intent.putExtra("RoG",RoG);
                startActivity(intent);
            }
        };
        btt_on_AddOperation.setOnClickListener(oclBtt_on_AddOperation);
    }


}