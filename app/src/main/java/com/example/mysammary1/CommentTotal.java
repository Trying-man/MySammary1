package com.example.mysammary1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class CommentTotal extends AppCompatActivity {
    CommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_total);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = CommentAdapter();


    }
}