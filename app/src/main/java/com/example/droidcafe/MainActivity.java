package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.droidcafe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int[] imgIds = new int[]{R.drawable.donut_circle, R.drawable.icecream_circle, R.drawable.froyo_circle};
    private int[] stringIds = new int[]{R.string.donut, R.string.icecream, R.string.froyo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.addlistview();

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        showDonutOrder(view);
                        break;
                    case 1:
                        showIceCreamOrder(view);
                        break;
                    case 2:
                        showFroyoOrder(view);
                        break;
                }
            }
        });
    }
    public void addlistview(){
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < stringIds.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("image", imgIds[i]);
            showitem.put("name", getString(stringIds[i]));
            listitem.add(showitem);
        }
        SimpleAdapter myAdapter = new SimpleAdapter(this, listitem, R.layout.item_listview, new String[]{"image", "name"}, new int[]{R.id.image, R.id.descripcion});
        binding.listview.setAdapter(myAdapter);

    }
    //Todo estos enseña mensajes de pedida
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    public void showFoodOrder(String message) {
        displayToast(message);
        Intent intent = new Intent(this,Order.class);
        startActivity(intent);
    }
    public void showDonutOrder(View view) {
        showFoodOrder(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view) {
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }
    public void showFroyoOrder(View view) {
        showFoodOrder(getString(R.string.froyo_order_message));
    }
}