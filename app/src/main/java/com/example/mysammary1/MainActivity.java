package com.example.mysammary1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*CommnetAdapter adapter;*/

    Button likeButton;
    Button UnlikeButton;
    TextView likeCountView;
    TextView UnlikeCountView;

    int likeCount =0;
    boolean likeState = false;

    int UnlikeCount =0;
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

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeState){
                    decrLikeCount();
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
                }else if(likeState ==true &&UnlikeState ==false){
                    decrLikeCount();
                    incrUnLikeCount();

                    UnlikeState = ! UnlikeState;
                }else {
                    incrUnLikeCount();

                }

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


        function_text.setText(spannableString);
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


}