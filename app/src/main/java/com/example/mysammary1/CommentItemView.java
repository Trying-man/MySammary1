package com.example.mysammary1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CommentItemView extends LinearLayout {
    TextView textId;
    TextView outputView;
    ImageView imageView;

    public CommentItemView(Context context) {
        super(context);

        init(context);
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);

        textId = (TextView) findViewById(R.id.textId);
        outputView = (TextView) findViewById(R.id.outputView);
        imageView = (ImageView) findViewById(R.id.imageView);
    }


    public void setId(String id) {
        textId.setText(id);
    }

    public void setComment(String comment) {
        outputView.setText(comment);
    }

    public void setImageView(int resId) {
        imageView.setImageResource(resId);
    }
}
