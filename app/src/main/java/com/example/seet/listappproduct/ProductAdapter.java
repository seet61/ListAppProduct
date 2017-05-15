package com.example.seet.listappproduct;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by seet on 15.05.17.
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    //Конструктор
    public ProductAdapter(Context context, int resource) {
        super(context, resource);
    }
}
