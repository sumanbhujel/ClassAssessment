package com.example.classassessment.model;

public class Food {
    private String name;
    private String category;
    private String rate;
    private int img; //R.id bata id tannda return aaune integer ho

    public Food(String name, String category, String rate, int img) {
        this.name = name;
        this.category = category;
        this.rate = rate;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getRate() {
        return rate;
    }

    public int getImg() {
        return img;
    }
}

