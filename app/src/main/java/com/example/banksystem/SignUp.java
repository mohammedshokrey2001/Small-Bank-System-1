package com.example.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private  final  static  String EMAIL="";
    private  final  static  String First_NAME="";
    private  final  static  String SEC_NAME="";
    private  final  static  String PASS="";
    private  final  static  String BIRTH_DATE="";
    private  final  static  double FIRST_BALANCE=0.0;
    private  final  static  String PHONR_NUMBER="";


    Intent intent_to_database ;

    Button sginup_bt;
    EditText email_ET;
    EditText password_ET;
    EditText name_ET;
    EditText birth_date_ET;
    EditText balance_ET;
    EditText phone_number_ET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);
        sginup_bt = findViewById(R.id.buttonAcount);
        email_ET = findViewById(R.id.editEmail);
        password_ET = (EditText) findViewById(R.id.editPass);
        name_ET = findViewById(R.id.editName);
        birth_date_ET = findViewById(R.id.editTextDate);
        balance_ET = findViewById(R.id.first_balance);
        phone_number_ET = findViewById(R.id.editTextPhone);


        sginup_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSginup_bt();

            }
        });

    }



    private void setSginup_bt(){
       //get data from text field to data types
        String[] full_name = name_ET.getText().toString().split(" ");
        String f_name = full_name[0];
        String l_name = full_name[1];
        String mail = email_ET.getText().toString();
        String pass = password_ET.getText().toString();
        String birth_date = birth_date_ET.getText().toString();
        String phone_num = phone_number_ET.getText().toString();

        String first_balance = balance_ET.getText().toString();


        //test data get from activity
        //Toast.makeText(SignUp.this,f_name+"\n"+l_name+"\n"+mail+"\n"+pass+"\n"+birth_date+"\n"+first_balance+"\n"+phone_num, Toast.LENGTH_LONG).show();
        //Toast.makeText(SignUp.this,f_name+"\n"+l_name+"\n"+mail+"\n"+pass+"\n"+birth_date+"\n"+first_balance+"\n"+phone_num, Toast.LENGTH_LONG).show();

        // call function to insert to the data base:-
        SqlHelper sqlHelper = new SqlHelper(SignUp.this);
        sqlHelper.addNewUser(mail,pass,f_name,l_name,phone_num,first_balance,birth_date);

        Intent intent = new Intent(SignUp.this,sign_in.class);
        startActivity(intent);

    }

}