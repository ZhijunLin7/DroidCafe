package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.droidcafe.databinding.ActivityOrderBinding;

public class Order extends AppCompatActivity {

    private ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);



    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }
    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
        case R.id.sameday: if (checked)
            displayToast("Choosen:"+ getString(R.string.sameday));
        break;
        case R.id.nextday: if (checked)
            displayToast("Choosen:" + getString(R.string.nextday));
        break;
        case R.id.pickup: if (checked)
            displayToast("Choosen:" +getString(R.string.pickup));
        break;
    }
}
}