package co.il.dmobile.myapplication_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        Cars Cars = (Cars) b.getSerializable("cars");

        ImageView car_photo = findViewById(R.id.car_photo);
        TextView Brand = findViewById(R.id.brand);
        TextView Model = findViewById(R.id.model);
        TextView Year = findViewById(R.id.year);
        TextView Price = findViewById(R.id.Price);

        car_photo.setImageResource(Cars.getImage());
        Brand.setText(Cars.getBrand());
        Model.setText(Cars.getModel());
        Year.setText(Cars.getYear());
        Price.setText(Cars.getPrice());
    }
}