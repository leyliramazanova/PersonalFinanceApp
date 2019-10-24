package com.example.wheresmymoney;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Instant;
import java.util.Date;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    TextView output;
    Button addSpending;
    Database DB = new Database();
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);*/
        addSpending = (Button) findViewById(R.id.AddSpending);
        output = (TextView) findViewById(R.id.output);
        editText = (EditText) findViewById(R.id.editText);
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


    private class TextEdit {
    }
}
