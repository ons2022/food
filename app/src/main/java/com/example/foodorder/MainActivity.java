package com.example.foodorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorder.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class
MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ListAdapter listAdapter;

    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout using data binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Data for the ListView
        int[] imageList = {R.drawable.pasta, R.drawable.img, R.drawable.cake, R.drawable.pancake,
                R.drawable.pizza, R.drawable.burger, R.drawable.fries};
        int[] ingredientList = {R.string.pastaIngredients, R.string.maggiIngredients,
                R.string.cakeIngredients, R.string.pancakeIngredients, R.string.pizzaIngredients,
                R.string.burgerIngredients, R.string.friesIngredients};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc,
                R.string.cakeDesc, R.string.pancakeDesc,
                R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc};
        String[] nameList = {"Pasta", "Maggi", "Cake", "Pancake", "Pizza", "Burgers", "Fries"};
        String[] timeList = {"30 mins", "2 mins", "45 mins", "10 mins",
                "60 mins", "45 mins", "30 mins"};

        // Populate dataArrayList with ListData objects
        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }

        // Initialize adapter
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);

        // Set adapter to the ListView
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, activity_detailed.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });

    }
}
