package com.example.mysammary1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView function_text = (TextView)findViewById(R.id.function_text);

        String content = function_text.getText().toString();
        SpannableString spannableString = new SpannableString(content);



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
}