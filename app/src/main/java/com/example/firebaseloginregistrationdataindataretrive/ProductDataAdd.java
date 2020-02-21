package com.example.firebaseloginregistrationdataindataretrive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProductDataAdd extends AppCompatActivity {

    private EditText PName, PPrise, PSize, PDescription;
    private Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_data_add);

        PName = findViewById(R.id.ProductName_ID);
        PPrise = findViewById(R.id.ProductPrize_ID);
        PSize = findViewById(R.id.ProductSize_ID);
        PDescription = findViewById(R.id.ProductDescrip_ID);

        Save= findViewById(R.id.SavePostButton_ID);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

    }

    private void saveData() {

    }
}
