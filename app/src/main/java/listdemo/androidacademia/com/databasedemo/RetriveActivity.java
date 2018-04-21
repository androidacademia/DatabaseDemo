package listdemo.androidacademia.com.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RetriveActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyDatabase myDatabase;
    private ArrayList<Users> usersList;
    private MyRetriveAdapter myRetriveAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myDatabase = new MyDatabase(this);
        usersList = new ArrayList<>();

        SQLiteDatabase sd = myDatabase.getReadableDatabase();
        
        String sql = "select * from "+MyDatabase.TABLE_NAME;
        Cursor cursor = sd.rawQuery(sql, null);

        while (cursor.moveToNext()){
            Users user = new Users();
            user.setUsername(cursor.getString(0));
            user.setPassword(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            usersList.add(user);
        }

        myRetriveAdapter = new MyRetriveAdapter(this,usersList);
        recyclerView.setAdapter(myRetriveAdapter);


    }
}
