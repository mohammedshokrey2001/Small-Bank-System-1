package com.example.banksystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "mysqldb.db";
    private static final int DATABASE_VERISON = 1;


    //TABLE 1
    private final static String TABLE_NAME_BANK_USER = "BANK_USER";
    private static final String FNAME = "FNAME";
    private static final String LNAME = "LNAME";
    private static final String UID = "_id";
    private static final String PASSWORD = "Password";
    private static final String EMAIL = "Email";
    private static final String PHONE_NUMBER = "Phone";
    private static final String BALANCE = "Balance";
    private static final String BIRTH_DATE = "Bdate";


    //
    SqlHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERISON);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = " Create Table  " + TABLE_NAME_BANK_USER +
                " ( " + UID + " INTEGER  PRIMARY  KEY  AUTOINCREMENT , " +
                FNAME + "  TEXT , " +
                LNAME + "  TEXT , " +
                EMAIL + " TEXT , " +
                PHONE_NUMBER + " TEXT , " +
                BALANCE + " TEXT , " +
                BIRTH_DATE + " TEXT , " +

                PASSWORD + " TEXT ) ; ";

        sqLiteDatabase.execSQL(query);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        SQLiteDatabase db = this.getWritableDatabase();

        String strSQL = "UPDATE BANK_USER SET _id = 12345678958863 WHERE _Id =1 ";

        db.execSQL(strSQL);




    }

    void addNewUser(String email, String password, String firstname, String lastname, String phone, String balance, String birthdate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(EMAIL, email);
        cv.put(PASSWORD, password);
        cv.put(FNAME, firstname);
        cv.put(LNAME, lastname);
        cv.put(PHONE_NUMBER, phone);
        cv.put(BALANCE, balance);
        cv.put(BIRTH_DATE, birthdate);


        long result = db.insert(TABLE_NAME_BANK_USER, null, cv);

        if (result == -1) {
            Toast.makeText(context, "failed to add", Toast.LENGTH_LONG).show();
            Log.i("aaaa", "addNewUser: run");
        } else {
            Toast.makeText(context, "added successfully", Toast.LENGTH_LONG).show();
            Toast.makeText(context, "you can now sign in ", Toast.LENGTH_LONG).show();

            Log.i("aah", "addNewUser: run2");

        }
    }

    String[] searchUserData(String mail, String pass) {


        //onUpgrade(this.getWritableDatabase(),2,3);
        SQLiteDatabase db = this.getWritableDatabase();
        String[] row = new String[7];
        //onUpgrade(db,1,2);
        Cursor cursor = db.rawQuery("select * from " +
                        TABLE_NAME_BANK_USER + "  where  " + EMAIL + " = ? AND " + PASSWORD +
                        " = ?",
                new String[]{mail, pass});


      //  Cursor cursor1  = db.rawQuery(" select * from "+TABLE_NAME_BANK_USER + " where " + EMAIL + " = ? ",new String[]{mail});

        //String query =;
        //   Cursor cursor = db.rawQuery("select * from USERDATA  where  Email = '" + mail + "'", null);
        if (cursor.getCount() == 0) {
            Toast.makeText(context, "noob", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            while (cursor.moveToNext()) {


                //   Toast.makeText(context ,a+"",Toast.LENGTH_LONG).show();
                row[0] = Integer.toString(cursor.getInt(0));
                row[1] = cursor.getString(1);
                row[2] = cursor.getString(2);
                row[3] = cursor.getString(3);
                row[4] = cursor.getString(4);
                row[5] = cursor.getString(5);
                row[6] = cursor.getString(6);

                // Log.i("a1", "searchUserData:  dev =  "+buffer[2]);
            }

            return row;

        }


    }


    void update_money(String money,String id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(BALANCE,money);
        db.update(TABLE_NAME_BANK_USER, cv, "_id = ?", new String[]{id});

    }



    Double[] getDataToAdmin1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Double[] row = new Double[2];
        Double Total=0.0;
        int count =0;
        Cursor cursor = db.rawQuery("select Balance  from  " +
                        TABLE_NAME_BANK_USER ,
                new String[]{ });


        if (cursor.getCount() == 0) {
            Toast.makeText(context, "noooo", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            while (cursor.moveToNext()) {
                Log.i("aa", "getDataToAdmin1: work");
                String a = cursor.getString(0);
                Double b = Double.parseDouble(a);
                Total = Total + b;
                count +=1;

            }

            row[0]= (double) count;
            row[1] = Total;

            return row ;

        }



    }
}
