package com.example.ustocktrade;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    ListView lv;
    String title[] = {"Country code", " Change password", "Dummy", "Dummy", "Dummy", "Dummy", "Dummy", "Dummy", "Dummy", "Dummy"};
    int images[] = {R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Dashboard");

        lv = (ListView)findViewById(R.id.listView);

        listViewAdapter lad = new listViewAdapter(this, title, images);
        lv.setAdapter(lad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position == 0)
                {
                    Toast.makeText(Dashboard.this, "No country codes available", Toast.LENGTH_SHORT).show();
                }
                if(position == 1)
                {
                    Intent intent = new Intent(getApplicationContext(), ChangePassword.class);
                    startActivity(intent);
                }
            }
        });
    }

    class listViewAdapter extends ArrayAdapter<String>
    {
        Context context;
        String txtTitle[];
        int avtimg[];

        listViewAdapter(Context c, String t[], int i[])
        {
            super(c, R.layout.row, R.id.txtarr, title);
            this.context = c;
            this.txtTitle = t;
            this.avtimg = i;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.img);
            TextView titles = row.findViewById(R.id.txtimg);

            images.setImageResource(avtimg[position]);
            titles.setText(txtTitle[position]);

            return row;
        }
    }
}
