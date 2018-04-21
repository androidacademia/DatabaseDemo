package listdemo.androidacademia.com.databasedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by girishkumarshakya on 21/04/18.
 */

public class MyRetriveAdapter extends RecyclerView.Adapter<MyRetriveAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Users> usersList;
    private LayoutInflater inflater;
    public MyRetriveAdapter(Context context, ArrayList<Users> usersList) {
        this.context = context;
        this.usersList =usersList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyRetriveAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRetriveAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(usersList.get(position).getUsername());
        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewNames);
        }
    }
}
