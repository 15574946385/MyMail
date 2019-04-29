package com.example.myapplication2.entity;

import android.widget.ImageView;

public class FromMailEntity {
    int ImageId;
    String From;
    String Subject;

    public FromMailEntity(int imageId, String from, String subject) {
        ImageId = imageId;
        From = from;
        Subject = subject;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
