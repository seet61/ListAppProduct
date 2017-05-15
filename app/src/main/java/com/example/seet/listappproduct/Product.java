package com.example.seet.listappproduct;

/**
 * Created by seet on 15.05.17.
 */

public class Product {
    //Переменные
    private String name;
    private int count;
    private String unit;

    //Конструктор
    public Product(String name, String unit) {
        this.name = name;
        this.count=0;
        this.unit = unit;
    }

    //Методы работы с переменными
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }
}
