package co.il.dmobile.myapplication_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Brand = findViewById(R.id.brand);
                EditText Model = findViewById(R.id.model);
                EditText Year = findViewById(R.id.year);
                EditText Price = findViewById(R.id.price);

                 Cars cars = new Cars(R.drawable.bmw,Brand.getText().toString(), Model.getText ().toString(),Year.getText().toString(),Price.getText().toString());


                Intent i = new Intent();
                i.putExtra("cars",cars);
                setResult(1,i);
                finish();



            }
        });

    }
}