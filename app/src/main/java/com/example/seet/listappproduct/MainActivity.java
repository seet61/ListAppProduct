package com.example.seet.listappproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Массив элементов для отображения
    ArrayList<Product> products = new ArrayList<>();
    ListView productList;

    //Данные для Spinner
    String[] citites = {"Москва", "Самара", "Вологла", "Волгоград", "Саратов", "Воронеж", "Ростов-на-Дону"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Работа со спинером
        Spinner spinner = (Spinner) findViewById(R.id.cities);
        //Создаем адаптер c помощью массива строк и стандартной разметки элемента spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, citites);
        //Определяем разметку для использования при выборе
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Применяем адаптер к элементу
        spinner.setAdapter(spinnerAdapter);

        //Работка со сложным списком
        //Инициализация при открытии
        if (products.size() == 0) {
            products.add(new Product("Картофель", "кг."));
            products.add(new Product("Чай", "шт."));
            products.add(new Product("Яйца", "шт."));
            products.add(new Product("Молоко", "л."));
            products.add(new Product("Макароны", "кг."));
        }
        productList = (ListView) findViewById(R.id.productList);
        ProductAdapter adapter = new ProductAdapter(this, R.layout.list_item, products);
        productList.setAdapter(adapter);
    }
}
