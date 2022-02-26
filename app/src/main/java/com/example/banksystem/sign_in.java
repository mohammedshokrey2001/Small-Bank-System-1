package com.example.banksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_in extends AppCompatActivity {

    Button login ;
    EditText email_Edit;
    EditText pass_Edit;
    Button create_new_acc;
    public  static final String EMAIL="name";
    public  static final  String First_NAME="name";
    public  static final  String SEC_NAME="name";
    public  static final  String PASS="name";
    public  static final  String BIRTH_DATE="name";
    public  static final  String FIRST_BALANCE="name";
    public  static final  String PHONR_NUMBER="name";
    public  static final  String ID="name";

    SqlHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        login = findViewById(R.id.btnlogin);
        email_Edit = findViewById(R.id.etemail);
        pass_Edit = findViewById(R.id.money_amount);
        create_new_acc = findViewById(R.id.withdraw);

        create_new_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   signUp();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }


    void signUp(){
        Intent intent = new Intent(sign_in.this , SignUp.class);
        startActivity(intent);
    }





        void signIn() {

            String mailText = email_Edit.getText().toString();
            String passText = pass_Edit.getText().toString();

            if (mailText.equals("") || passText.equals("")) {
                Toast.makeText(sign_in.this, "please enter email and password to sign in", Toast.LENGTH_LONG).show();


            }
            else if(mailText.equals("admin") && passText.equals("admin1234")){
                signInAdmin();

            }

            else {
                myDB = new SqlHelper(sign_in.this);

                String [] data = myDB.searchUserData(mailText,passText);

                if (data ==null){
                    Toast.makeText(sign_in.this," email or password not correct",Toast.LENGTH_LONG).show();

                }else {
                    Intent intent = new Intent(sign_in.this, USER_PROFILE.class);
                    String id = data[0];
                    String f_name = data[1];
                    String l_name = data[2];
                    String mail =data[3];
                    String phone_num = data[4];
                    String birth_date = data[6];
                    String balance = data[5];
                    //Toast.makeText(sign_in.this,id+"\n"+f_name+"\n"+l_name+"\n"+mail+"\n"+birth_date+"\n"+balance+"\n"+phone_num, Toast.LENGTH_LONG).show();

                    intent.putExtra("EMAIL",mail);
                    intent.putExtra("ID",id);
                    intent.putExtra("First_NAME",f_name);
                    intent.putExtra("SEC_NAME",l_name);
                    intent.putExtra("PHONR_NUMBER",phone_num);
                    intent.putExtra("BIRTH_DATE",birth_date);
                    intent.putExtra("FIRST_BALANCE",balance);
                    startActivity(intent);

                    email_Edit.setText("");
                    pass_Edit.setText("");

                }


            }

        }

    void signInAdmin(){
        SqlHelper   data_admin = new SqlHelper(sign_in.this);
        Double [] data = data_admin.getDataToAdmin1();
        if (data ==null){
            Toast.makeText(sign_in.this,"its not allowed for you \n cause you are not admin",Toast.LENGTH_LONG).show();

        }else {
            //Toast.makeText(sign_in.this,"hey admin"+data[0]+"\n"+data[1],Toast.LENGTH_LONG).show();

            Intent intent = new Intent(sign_in.this,Admin1.class);
            intent.putExtra("balance_admin_review",String.valueOf(data[1]));
            intent.putExtra("coun_user_admin_review",String.valueOf(data[0]));
            startActivity(intent);
        }
    }
}