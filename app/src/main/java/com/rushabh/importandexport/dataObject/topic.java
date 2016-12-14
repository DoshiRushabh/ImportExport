package com.rushabh.importandexport.dataObject;

import android.graphics.drawable.Drawable;

import com.bumptech.glide.load.engine.Resource;

/**
 * Created by Rushabh on 12/14/2016.
 */

public class topic {
    private String title,description;
    private int image;


    public topic(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
