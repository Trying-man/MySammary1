package com.example.mysammary1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CommentAdapter adapter;

    Button likeButton;
    Button UnlikeButton;
    Button WriteButton;
    Button CommentTotalButton;
    TextView likeCountView;
    TextView UnlikeCountView;

    //RatingBar ratingBar;

    int likeCount =15;
    boolean likeState = false;

    int UnlikeCount =1;
    boolean UnlikeState = false;

    EditText editText;
    EditText editText2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView function_text = (TextView)findViewById(R.id.function_text);

        String content = function_text.getText().toString();
        SpannableString spannableString = new SpannableString(content);

        likeButton = (Button) findViewById(R.id.likeButton);
        likeCountView = (TextView) findViewById(R.id.likeCountView);

        UnlikeButton = (Button) findViewById(R.id.UnlikeButton);
        UnlikeCountView = (TextView) findViewById(R.id.UnlikeCountView);

        WriteButton = (Button) findViewById(R.id.WriteButton);
        WriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentWrite();
            }
        });







        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeState){
                   decrLikeCount();
                }else if(UnlikeState == true){
                    decrUnLikeCount();
                    UnlikeState = ! UnlikeState;
                    incrLikeCount();
                }else {
                    incrLikeCount();
                }
                likeState = ! likeState;
            }
        });

        UnlikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UnlikeState){
                    decrUnLikeCount();
                }else if(likeState ==true){
                    decrLikeCount();
                    likeState = ! likeState;
                    incrUnLikeCount();
                }else {
                    incrUnLikeCount();


                }
                UnlikeState = ! UnlikeState;

            }
        });






            //String[] word = new String[3];

            /*word[0]="줄거라";
            word[1]="군도";
            word[2]="양반";
            */



            String word= "줄거리";
            int start = content.indexOf(word);
            int end = start + word.length();

            spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, spannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new RelativeSizeSpan(1.1f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);


        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new CommentAdapter();


        adapter.addItem(new CommentItem("kym71**","적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.",R.drawable.user1));
        adapter.addItem(new CommentItem("kym71**","적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.",R.drawable.user1));


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CommentItem item = (CommentItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : " + item.getName(),Toast.LENGTH_LONG).show();
            }
        });


        Button AllButton = (Button) findViewById(R.id.AllButton);
        AllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"버튼이 눌렀음",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), CommentTotal.class);
            }
        });



        function_text.setText(spannableString);
    }

    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        @Override
        public int getCount(){
            return items.size();
        }


        public void addItem(CommentItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position){
            return items.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            CommentItemView view = null;
            if(convertView == null){
                view = new CommentItemView(getApplicationContext());
            }else {
                view = (CommentItemView) convertView;
            }
            CommentItem item = items.get(position);
            view.setId(item.getName());
            view.setComment(item.getComment());
            view.setImageView(item.getResId());

            return view;
        }

    }


    public void incrLikeCount(){
        likeCount +=1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount(){
        likeCount -=1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
    }

    public void incrUnLikeCount(){
        UnlikeCount +=1;
        UnlikeCountView.setText(String.valueOf(UnlikeCount));

        UnlikeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrUnLikeCount(){
        UnlikeCount -=1;
        UnlikeCountView.setText(String.valueOf(UnlikeCount));

        UnlikeButton.setBackgroundResource(R.drawable.thumbs_up_selector);

    }

    public void showCommentWrite(){
        //float rating = ratingBar.getRating();

        Intent intent = new Intent(getApplicationContext(), CommentWrite.class);
        //intent.putExtra("rating",rating);
        startActivityForResult(intent,101);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 101){
            if(intent != null){
                String contents = intent.getStringExtra("contents");

            }
        }

    }
}