package com.example.oderapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Food implements Serializable {
    private int id;
    private String name;
    private int cost;
    private int count;
    public static List<Food> foodList = new ArrayList<Food>();

    public Food(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.count = 0;
        foodList.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void resetCount() {
        for (Food food : foodList) {
            food.setCount(0);
        }
    }
}
