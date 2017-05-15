package com.example.seet.listappproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Массив элементов для отображения
    ArrayList<Product> products = new ArrayList<>();
    ListView productList;

    //Данные для Spinner
    String[] citites = {"Москва", "Самара", "Вологда", "Волгоград", "Саратов", "Воронеж", "Ростов-на-Дону"};

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.header);
        switch (id){
            case R.id.action_settings:
                headerView.setText("Настройки");
                break;
            case R.id.open_action:
                headerView.setText("Открыть");
                break;
            case R.id.save_settings:
                headerView.setText("Сохранить");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
