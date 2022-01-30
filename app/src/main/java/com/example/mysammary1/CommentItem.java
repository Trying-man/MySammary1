package com.example.mysammary1;

public class CommentItem {

    String name;
    String comment;
    int resId;

    public CommentItem(String name, String comment, int resId) {
        this.name = name;
        this.comment = comment;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", resId=" + resId +
                '}';
    }


}



