package com.example.wheresmymoney;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class makeCategoryOrSpending extends Fragment {


    public makeCategoryOrSpending() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_make_category_or_spending, container, false);
        Button makeSpending = (Button) v.findViewById(R.id.makeSpending);
        makeSpending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 MakeSpending mkSpd = new MakeSpending();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.container, mkSpd, mkSpd.getTag()).commit();
            }
        });
        return v;
    }

}
