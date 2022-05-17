package com.example.mysammary1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CommentTotal extends AppCompatActivity {
    CommentAdapter adapter;
    Button WriteButton;
    private MainActivity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_total);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new CommentAdapter();

        adapter.addItem(new CommentItem("kym71**", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.", R.drawable.user1));
        adapter.addItem(new CommentItem("kym71**", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요2.", R.drawable.user1));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CommentItem item = (CommentItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 : "+ item.getName(),Toast.LENGTH_LONG).show();
            }
        });

        WriteButton = (Button) findViewById(R.id.WriteButton);
        WriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentWrite();
            }
        });



    }

    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        @Override
        public int getCount() {
            return items.size();
        }


        public void addItem(CommentItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommentItemView view = null;
            if(convertView == null){
                view = new CommentItemView(getApplicationContext());
            } else {
                view = (CommentItemView) convertView;
            }
            CommentItem item =items.get(position);
            view.setId(item.getName());
            view.setComment(item.getComment());
            view.setImageView(item.getResId());

            return view;
        }
    }

    public void showCommentWrite(){
        Intent intent = new Intent(getApplicationContext(), CommentWrite.class);

        startActivityForResult(intent,101);
    }


}


