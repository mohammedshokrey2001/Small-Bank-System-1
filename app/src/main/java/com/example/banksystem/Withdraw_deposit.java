package com.example.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Withdraw_deposit extends AppCompatActivity {

    EditText money_amount;
    Button wid ;
    Button dep ;
    TextView result;

    SqlHelper myDB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_deposit);
        money_amount = findViewById(R.id.money_amount);
        wid = findViewById(R.id.withdraw);
        dep = findViewById(R.id.deposit);
        result = findViewById(R.id.result_balance);
        Intent intent = getIntent();
        String balance = intent.getStringExtra("balance");
        String id = intent.getStringExtra("id");
       // Toast.makeText(Withdraw_deposit.this, "new balance is "+balance +id, Toast.LENGTH_LONG).show();
        result.setVisibility(TextView.INVISIBLE);

        myDB = new SqlHelper(Withdraw_deposit.this);

        //to get money
        wid.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String money_user = money_amount.getText().toString();
                result.setVisibility(TextView.VISIBLE);

                double new_balance = Double.parseDouble(balance) - Double.parseDouble(money_user);
              //  Toast.makeText(Withdraw_deposit.this, "new balance is "+new_balance, Toast.LENGTH_LONG).show();
                result.setText("new balance is : "+new_balance);
                myDB.update_money(String.valueOf(new_balance) ,id);


            }
        });


        //to put money
        dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setVisibility(TextView.VISIBLE);

                String money_user = money_amount.getText().toString();

                double new_balance = Double.parseDouble(balance) + Double.parseDouble(money_user);
              //  Toast.makeText(Withdraw_deposit.this, "new balance is "+new_balance, Toast.LENGTH_LONG).show();
                result.setText("new balance is : "+new_balance);
                myDB.update_money(String.valueOf(new_balance) ,id);
                myDB.close();
            }
        });


    }



}