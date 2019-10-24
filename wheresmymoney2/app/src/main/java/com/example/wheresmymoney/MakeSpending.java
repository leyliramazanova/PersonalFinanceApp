package com.example.wheresmymoney;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Instant;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class MakeSpending extends Fragment {
    TextView output;
    Button addSpending;
    Database DB = new Database();
    EditText editText;


    public MakeSpending() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_make_spending, container, false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void makeSpending(View v){
        output.setText(editText.getText().toString());
        float spendingAmount = Float.parseFloat(editText.getText().toString());

        Date newdate = Date.from(Instant.now());
        //Category category =
        DB.MakeSpending(spendingAmount, newdate, DB.Categories.get(0));
        //output.setText(DB.Spendings.get(0).amount + DB.Spendings.get(0).date.toString() + DB.Spendings.get(0).category.name +"");
    }

}
