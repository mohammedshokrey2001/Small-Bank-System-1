package com.example.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class USER_PROFILE extends AppCompatActivity {

    public  static final String EMAIL="name";
    public  static final  String First_NAME="name";
    public  static final  String SEC_NAME="name";
    public  static final  String PASS="name";
    public  static final  String BIRTH_DATE="name";
    public  static final  String FIRST_BALANCE="name";
    public  static final  String PHONR_NUMBER="name";
    public  static final  String ID="name";

    TextView first_name;
    TextView last_name;
    TextView phone;
    TextView email;
    TextView balancetv;
    FloatingActionButton next_bt;

    String id;
    String balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_profile);
        first_name = findViewById(R.id.et_number_emp);
        last_name = findViewById(R.id.et_number_clients);
        phone = findViewById(R.id.et_number_loans);
        email = findViewById(R.id.et_total_balancee);
        balancetv = findViewById(R.id.et_total_salaries);
        next_bt = findViewById(R.id.floatingActionButton);
        Intent intent = getIntent();

        id = intent.getStringExtra("ID") ;
        String f_name = intent.getStringExtra("First_NAME");
        String l_name = intent.getStringExtra("SEC_NAME");
        String mail =intent.getStringExtra("EMAIL");
        String phone_num = intent.getStringExtra("PHONR_NUMBER");
        String birth_date = intent.getStringExtra("BIRTH_DATE");
         balance = intent.getStringExtra("FIRST_BALANCE");

        first_name.setText(f_name);
        last_name.setText(l_name);
        email.setText(mail);
        phone.setText(phone_num);
        balancetv.setText(balance);

     //   Toast.makeText(USER_PROFILE.this,"DATA IN USER  \n"+f_name+"\n"+l_name+"\n"+mail+"\n"+birth_date+"\n"+balance+"\n"+phone_num, Toast.LENGTH_LONG).show();

       // dispalyData();

   next_bt.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           wid_dep();
       }
   });



    }






/*
    private void dispalyData(){
        String f_name = intent.getStringExtra("First_NAME");
        String l_name = intent.getStringExtra("SEC_NAME");
        String mail =intent.getStringExtra("EMAIL");
        String phone_num = intent.getStringExtra("PHONR_NUMBER");
        String birth_date = intent.getStringExtra("BIRTH_DATE");
        String balance = intent.getStringExtra("FIRST_BALANCE");

        first_name.setText(f_name);
        last_name.setText(l_name);
        email.setText(mail);
        phone.setText(phone_num);
        balancetv.setText(balance);
    }

*/
  private void wid_dep(){

   Intent intent = new Intent(USER_PROFILE.this,Withdraw_deposit.class);
   intent.putExtra("balance",balance);
   intent.putExtra("id",id);
   startActivity(intent);
 }
}