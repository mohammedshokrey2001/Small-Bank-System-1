package com.example.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Admin1 extends AppCompatActivity {

    TextView number_of_emp;
    TextView number_of_clients;
    TextView total_balance;
    TextView total_loans;
    TextView total_salaries;
    FloatingActionButton next_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);

        number_of_emp = findViewById(R.id.et_number_emp);
        number_of_clients = findViewById(R.id.et_number_clients);
        total_balance = findViewById(R.id.et_total_balancee);
        total_loans = findViewById(R.id.et_number_loans);
        total_salaries = findViewById(R.id.et_total_salaries);

        Intent intent_data_came_from_signin = getIntent();

        String num_clients_st =  intent_data_came_from_signin.getStringExtra("coun_user_admin_review");
        String balance_total_st  =  intent_data_came_from_signin.getStringExtra("balance_admin_review");
        String number_of_emp_st ="220";
        String total_loans_st  = "150000.4";
        String total_salaries_st  = "3321453.36";

        number_of_emp.setText(number_of_emp_st);
        number_of_clients.setText(num_clients_st);
        total_loans.setText(total_loans_st);
        total_salaries.setText(total_salaries_st);
        total_balance.setText(balance_total_st);


    }
}