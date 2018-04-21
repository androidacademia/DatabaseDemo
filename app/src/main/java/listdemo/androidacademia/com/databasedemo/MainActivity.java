package listdemo.androidacademia.com.databasedemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editUN,editPass,editEmail;
    private MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editEmail = findViewById(R.id.editTextEmail);
        editPass = findViewById(R.id.editTextPassword);
        editUN = findViewById(R.id.editTextUN);
        myDatabase = new MyDatabase(this);
    }

    public void add(View view) {
        String email = editEmail.getText().toString();
        String pass = editPass.getText().toString();
        String un = editUN.getText().toString();
        
        try {
            SQLiteDatabase sd = myDatabase.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(MyDatabase.COL_UNAME, un);
            values.put(MyDatabase.COL_PASS, pass);
            values.put(MyDatabase.COL_EMAIL, email);
            sd.insert(MyDatabase.TABLE_NAME, null, values);
        }catch (Exception e){
            Toast.makeText(this, "Something bad happen", Toast.LENGTH_SHORT).show();
        }

    }

    public void retrive(View view) {
        startActivity(new Intent(this,RetriveActivity.class));
    }
}
