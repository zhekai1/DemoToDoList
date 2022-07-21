package sg.edu.rp.c346.id21024750.demotodolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter<ToDoItem> {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> alToDoList;

    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context = parent_context;
        layout_id = resource;
        alToDoList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvDate = rowView.findViewById(R.id.tvDate);
        ImageView iv = rowView.findViewById(R.id.iv);

        ToDoItem currItem = al.get(position);
        tvTitle.setText(currItem.getTitle());
        tvDate.setText(currItem.getDatetoString());

        if (currItem.getDate().get(Calendar.YEAR) < 2022) {
            tvDate.setTextColor(Color.RED);
            iv.setImageResource(android.R.drawable.ic_delete);
        }
        return rowView;
    }
}
