package listdemo.androidacademia.com.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by girishkumarshakya on 21/04/18.
 */

public class MyDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "mydb";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "my_reg";
    public static final String COL_UNAME = "u_name";
    public static final String COL_PASS = "u_pass";
    public static final String COL_EMAIL = "u_emai";
    /**
     * create table my_reg (u_name text,u_pass text,u_email text);
     */
    public static final String CREATE_TABLE = "create table " +
            ""+TABLE_NAME+" ("+COL_UNAME+" text,"+COL_PASS+" text,"+COL_EMAIL+" text)";


    public MyDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int newVersion, int oldVersion) {
            if(newVersion>oldVersion){
                //perform updates
            }
    }
}
